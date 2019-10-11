//
// Created by Qiufeng54321 on 2019-08-15.
//

#include <Lexer/Symbols.hpp>
#include "MultiStack.hpp"
#include "Parser.hpp"

namespace Erable::Utils {
	template<typename T>
	T &&MultiStack<T>::get(MultiStackPath index) {
		NodeType current = root;
		for (int i : index) {
			current = current->nodes[i];
		}
		return std::forward<decltype(current->value)>(current->value);
	}

	template<typename T>
	typename MultiStack<T>::NodeList MultiStack<T>::getList(MultiStackPath index) {
		NodeList nodeList;
		NodeType current = root;
		for (int i : index) {
			nodeList.push_back(current);
			current = current->nodes[i];
		}
		nodeList.push_back(current);
		return nodeList;
	}

	template<typename T>
	void MultiStack<T>::set(MultiStackPath index, T &&value) {
		NodeType current = root;
		for (int i : index) {
			current = current->nodes[i];
		}
		current->value = value;
	}

	template<typename T>
	void MultiStack<T>::setPath(MultiStackPath index, MultiStack::NodeList list) {
		assert(index.size() == list.size() - 1);
		NodeType current = root;
		//Because the list starts with the root node's value, so the list's size is 1 bigger than the index list.
		for (int i : index) {
			if (current->value != list[i]->value)
				current->value = list[i]->value;
			current = current->nodes[i];
		}
		current->value = list[list.size() - 1]->value;
	}

	template<typename T>
	MultiStack<T>::MultiStack(const MultiStack::NodeType &root):root(root) {}

	template<typename T>
	MultiStack<T>::MultiStack() {
		static_assert(std::is_class<Compiler::Parser::NodeData>::value,
					  "Constructing MultiStack with no arguments requires type T be NodeData!");
		Compiler::Parser::NodeData data;
		root = std::make_shared<Node>();
	}

	template<typename T>
	MultiStackNode<T> &MultiStackNode<T>::operator[](std::size_t size) {
		return nodes[size];
	}

	template<typename T>
	bool MultiStackNode<T>::operator==(const MultiStackNode &rhs) const {
		return value == rhs.value &&
			   nodes == rhs.nodes;
	}

	template<typename T>
	bool MultiStackNode<T>::operator!=(const MultiStackNode &rhs) const {
		return !(rhs == *this);
	}

	template<typename T>
	MultiStackNode<T>::MultiStackNode(T &&value, const typename MultiStack<T>::NodeList &nodes):value(
			std::forward<T>(value)), nodes(nodes) {}

	template
	class MultiStack<Compiler::Parser::MultiStackIntegralType>;
}

template<typename T>
bool
operator==(typename Erable::Utils::MultiStack<T>::NodeType lhs, typename Erable::Utils::MultiStack<T>::NodeType rhs) {
	return lhs->value == rhs->value && lhs->nodes == rhs->value;
}

template<typename T>
bool
operator!=(typename Erable::Utils::MultiStack<T>::NodeType lhs, typename Erable::Utils::MultiStack<T>::NodeType rhs) {
	return !(lhs == rhs);
}
