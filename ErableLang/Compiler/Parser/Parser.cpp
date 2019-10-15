//
// Created by Qiufeng54321 on 2019-07-12.
//

#include "Parser.hpp"

#include <utility>
#include <Syntax.hpp>
#include <iostream>

namespace Erable::Utils {
}

Erable::Compiler::Parser::NodeData::NodeData(Symbols::SymbolPtr type,
											 std::vector<NodeData> subData, int state) : symbolPtr(std::move(type)),
																						 token(Symbols::EOT_TOKEN),
																						 subData(std::move(subData)),
																						 state(state) {}

Erable::Compiler::Parser::NodeData::NodeData(Erable::Compiler::Token type, std::vector<NodeData> subData, int state)
		: symbolPtr(Symbols::EOT),
		  token(std::move(type)),
		  subData(std::move(subData)),
		  state(state) {

}

std::string Erable::Compiler::Parser::NodeData::getTag() {
	if (token.getName() != Symbols::EOT_TOKEN.getName()) {
		//If both node is a token, then compare their names
		return token.name;
	} else if (symbolPtr->getTag() != Symbols::EMPTY_PLACEHOLDER->getTag()) {
		//If both node holds a symbol, then compare their rules
		return symbolPtr->getTag();
	}
	return "";
}

bool Erable::Compiler::Parser::NodeData::operator==(const Erable::Compiler::Parser::NodeData &rhs) const {
	bool res = false;
	if (token.getName() != Symbols::EOT_TOKEN.getName() and rhs.token.getName() != Symbols::EOT_TOKEN.getName()) {
		//If both node is a token, then compare their names
		res = token.getName() == rhs.token.getName();
	} else if (symbolPtr->getTag() != Symbols::EMPTY_PLACEHOLDER->getTag() and
			   rhs.symbolPtr->getTag() != Symbols::EMPTY_PLACEHOLDER->getTag()) {
		//If both node holds a symbol, then compare their rules
		res = symbolPtr->is(rhs.symbolPtr);
	}
	res = (res and this->state == rhs.state);
	return res;
}

bool Erable::Compiler::Parser::NodeData::operator!=(const Erable::Compiler::Parser::NodeData &rhs) const {
	return !(rhs == *this);
}

namespace Erable::Compiler::Parser {
	bool Parser::parse(TokenList tokenList) {
		std::cout << multiStack.root->value;
		indexes = {{}};
		std::cout << multiStack.root->value;
		for (auto &token : tokenList) {
			auto newIndexes = parseNext(token);
			if (not newIndexes.empty()) {
				if (newIndexes[0].empty()) return false;
			}
			indexes.insert(indexes.end(), newIndexes.begin(), newIndexes.end());
			std::cout << this->multiStack;
		}
		auto newIndexes = parseNext(Symbols::EOT_TOKEN);
		if (not newIndexes.empty()) {
			if (newIndexes[0].empty()) return false;
		}
		indexes.insert(indexes.end(), newIndexes.begin(), newIndexes.end());
		return true;
	}

	bool Parser::allError() {
		return false;
	}

	//Take a token and do an action
	Parser::IndexesType Parser::parseNext(Token token) {
		IndexesType newIndexes;
		for (auto &indexI : indexes) {
			auto data = multiStack.getList(indexI);
			auto lastSymbol = data[data.size() - 1];
			std::cout << multiStack << std::endl;
			auto line = parseTable.getParseTable()[lastSymbol->value.state];
			std::string tag = token.name;
			for (auto it = line.equal_range(tag).first; it != line.equal_range(tag).second; ++it) {
				Action action = it->second;
				auto accepted = next(indexI, action, token);
				if (not accepted.empty())
					if (accepted[0].empty())return {{}};
				newIndexes.insert(newIndexes.end(), accepted.begin(), accepted.end());
			}
		}
		return newIndexes;
	}

	bool Parser::isParsable(Token token) {
		return false;
	}

	/**
	 * Does an action
	 * @param path the stack path of this
	 * @param action the action to be done
	 * @return if the action is accepted
	 */
	Parser::IndexesType Parser::next(Utils::MultiStackPath path, Action action, Token token) {
		MultiStackType::NodeList nodes = multiStack.getList(path);
		Utils::MultiStackPath newPath = path;
		if (action.type == ActionType::STATE) {
			return doState(newPath, nodes, token, action.i);
		} else if (action.type == ActionType::REDUCE) {
			return doReduce(newPath, nodes, action.i);
		} else if (action.type == ActionType::ACCEPT) {
			return {{}};
		}
		return {};
	}

	Parser::IndexesType
	Parser::doState(Utils::MultiStackPath &path, MultiStackType::NodeList &list, Token token, int state) {
		MultiStackType::NodeType nodeData = std::make_shared<MultiStackType::Node>(
				Utils::MultiStackNode(MultiStackIntegralType{token, {}, state}));
		auto cpList = list;
		auto cpPath = path;
		cpList.push_back(nodeData);
		cpPath.push_back(multiStack.getElementSize(cpPath));
		multiStack.setPath(cpPath, cpList);
		return {cpPath};
	}

	Parser::IndexesType Parser::doReduce(Utils::MultiStackPath &path, MultiStackType::NodeList &list, int reduce) {
		IndexesType ret;
		std::vector<Utils::MultiStackPath> newPaths{path};
		std::vector<MultiStackType::NodeList> newLists{list};

		Symbols::SymbolPtr symbolPtr = Syntax::syntaxList[reduce];
		//Cast the symbol
		auto combination = std::static_pointer_cast<Symbols::CombineSymbol>(symbolPtr);

		int len = combination->list.size();
		MultiStackType::NodeList collected{list.end() - len, list.end()};

		std::vector<NodeData> newNodeData;
		for (auto &item : collected) {
			newNodeData.push_back(item->value);
		}

		//Reduce the collected symbols
		list.erase(list.end() - len, list.end());
		path.erase(path.end() - len, path.end());

		int lastState = list[list.size() - 1]->value.state;

		ParseTable::ActionLine line = parseTable.getParseTable()[lastState];
		std::string tag = symbolPtr->getTag();
		for (auto it = line.equal_range(tag).first; it != line.equal_range(tag).second; ++it) {
			auto copyPath = path;
			auto copyList = list;
			Action action = it->second;
			MultiStackType::NodeType nodeData = std::make_shared<MultiStackType::Node>(
					Utils::MultiStackNode(MultiStackIntegralType{symbolPtr, newNodeData, action.i}));

			copyList.push_back(nodeData);
			auto items = multiStack.getList(copyPath);
			bool found = false;
			auto foundPath = findDuplicate(nodeData->value);
			if (not foundPath.empty()) {
				found = true;
				auto got = multiStack.getPtr(foundPath);
				copyList.push_back(got);
				copyPath.push_back(multiStack.getElementSize(copyPath));
			}
			if (not found)
				copyPath.push_back(0);
			multiStack.setPath(copyPath, copyList);
			ret.push_back(copyPath);
		}
		return ret;
	}

	Utils::MultiStackPath Parser::findDuplicate(const NodeData &nodeData, Utils::MultiStackPath indexBuff) {
		auto got = multiStack.get(indexBuff);
		if (got.subData.empty()) {
			return (got == nodeData ? indexBuff : Utils::MultiStackPath{});
		}
		for (int i = 0; i < got.subData.size(); i++) {
			auto cpy = indexBuff;
			cpy.push_back(i);
			auto res = findDuplicate(nodeData, cpy);
			if (not res.empty()) return res;
		}
		return {};
	}

	Parser::Parser(ParseTable parseTable) : parseTable(std::move(parseTable)) {
		multiStack = MultiStackType();
	}
}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::NodeData nodeData) {
	os << nodeData.getTag();
	os << " " << nodeData.state << ", {";
	for (auto &item : nodeData.subData) {
		os << item << ", ";
	}
	if (not nodeData.subData.empty())os << "\b";
	os << "}";
	return os;
}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::MultiStackType multiStack) {
	os << multiStack.root->value;
	return os;
}

