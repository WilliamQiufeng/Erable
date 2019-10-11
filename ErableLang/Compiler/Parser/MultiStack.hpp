//
// Created by Qiufeng54321 on 2019-08-15.
//

#ifndef ERABLELANG_MULTISTACK_HPP
#define ERABLELANG_MULTISTACK_HPP

#include "Headers.hpp"

namespace Erable::Utils {

	template<typename T>
	class MultiStack;

	template<typename T>
	struct MultiStackNode;

	typedef std::vector<int> MultiStackPath;

	template<typename T>
	class MultiStack {
	public:
		typedef MultiStackNode<T> Node;
		typedef std::shared_ptr<Node> NodeType;
		typedef std::vector<NodeType> NodeList;
		NodeType root;

		MultiStack(const NodeType &root);

		MultiStack();

		T &&get(MultiStackPath index);

		NodeList getList(MultiStackPath index);

		void set(MultiStackPath index, T &&value);

		void setPath(MultiStackPath index, NodeList list);
	};

	template<typename T>
	struct MultiStackNode {
		T &&value;
		typename MultiStack<T>::NodeList nodes;

		MultiStackNode<T> &operator[](std::size_t size);

		explicit MultiStackNode(T &&value = T(), const typename MultiStack<T>::NodeList &nodes = {});

		bool operator==(const MultiStackNode &rhs) const;

		bool operator!=(const MultiStackNode &rhs) const;
	};
}

template<typename T>
bool
operator==(typename Erable::Utils::MultiStack<T>::NodeType lhs, typename Erable::Utils::MultiStack<T>::NodeType rhs);

template<typename T>
bool
operator!=(typename Erable::Utils::MultiStack<T>::NodeType lhs, typename Erable::Utils::MultiStack<T>::NodeType rhs);

#endif //ERABLELANG_MULTISTACK_HPP
