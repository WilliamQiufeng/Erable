//
// Created by Qiufeng54321 on 2019-08-15.
//

#include <Lexer/Symbols.hpp>
#include "MultiStack.hpp"
#include "Parser.hpp"

namespace Erable::Utils {
	using T = MultiStack::T;
	using NodeType = MultiStack::NodeType;

	T *Const::start_symbol = new T{Compiler::Symbols::EOT};

	T MultiStack::get(const MultiStackPath &index) {
		return getPtr(index)->value;
	}

	typename MultiStack::NodeType MultiStack::getPtr(const MultiStackPath &index) {
		NodeType current = root;
		for (int i : index) {
			current = current->nodes[i];
		}
		return current;
	}

	int MultiStack::getElementSize(MultiStackPath index) {
		return getPtr(index)->nodes.size();
	}

	typename MultiStack::NodeList MultiStack::getList(MultiStackPath index) {
		NodeList nodeList;
		NodeType current = root;
		for (int i : index) {
			nodeList.push_back(current);
			current = current->nodes[i];
		}
		nodeList.push_back(current);
		return nodeList;
	}

	void MultiStack::set(MultiStackPath index, T &&value) {
		NodeType current = root;
		for (int i : index) {
			current = current->nodes[i];
		}
		current->value = value;
	}

	void MultiStack::setPath(MultiStackPath index, MultiStack::NodeList list) {
		assert(index.size() == list.size() - 1);
		NodeType current = root;
		//Because the list starts with the root node's value, so the list's size is 1 bigger than the index list.
		int j = 0;
		for (int i : index) {
			if (j++ >= list.size() - 1) {
				current->nodes.erase(current->nodes.begin() + i);
				break;
			}
			if (current->value != list[i]->value)
				current->value = list[i]->value;
			current = current->nodes[i];
		}
		current->value = list[list.size() - 1]->value;
	}

	MultiStack::MultiStack(const MultiStack::NodeType &root) : root(root) {}

	MultiStack::MultiStack() {
		static_assert(std::is_base_of<Compiler::Parser::NodeData, T>::value,
					  "Constructing MultiStack with no arguments requires type T be NodeData!");
		root = std::make_shared<Node>(*Const::start_symbol);
	}

	MultiStack::NodeType MultiStackNode::operator[](std::size_t size) {
		return nodes[size];
	}

	bool MultiStackNode::operator==(const MultiStackNode &rhs) const {
		return value == rhs.value &&
			   nodes == rhs.nodes;
	}

	bool MultiStackNode::operator!=(const MultiStackNode &rhs) const {
		return !(rhs == *this);
	}

	MultiStackNode::MultiStackNode(T value, typename MultiStack::NodeList nodes) : value(
			std::move(value)), nodes(std::move(nodes)) {}

}

template<typename T>
bool
operator==(typename Erable::Utils::MultiStack::NodeType lhs, typename Erable::Utils::MultiStack::NodeType rhs) {
	return lhs->value == rhs->value && lhs->nodes == rhs->nodes;
}

template<typename T>
bool
operator!=(typename Erable::Utils::MultiStack::NodeType lhs, typename Erable::Utils::MultiStack::NodeType rhs) {
	return !(lhs == rhs);
}
