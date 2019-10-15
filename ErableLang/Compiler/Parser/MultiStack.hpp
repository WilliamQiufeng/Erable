//
// Created by Qiufeng54321 on 2019-08-15.
//

#ifndef ERABLELANG_MULTISTACK_HPP
#define ERABLELANG_MULTISTACK_HPP

#include "Headers.hpp"

namespace Erable::Utils {

	class MultiStack;

	struct MultiStackNode;

	typedef std::vector<int> MultiStackPath;

	class MultiStack {

	public:
		typedef MultiStackNode Node;
		typedef Compiler::Parser::NodeData T;
		typedef std::shared_ptr<Node> NodeType;
		typedef std::vector<NodeType> NodeList;
		NodeType root = nullptr;

		MultiStack(const NodeType &root);

		MultiStack();

		T get(const MultiStackPath &index);

		NodeType getPtr(const MultiStackPath &index);

		NodeList getList(MultiStackPath index);

		int getElementSize(MultiStackPath index);

		void set(MultiStackPath index, T &&value);

		void setPath(MultiStackPath index, NodeList list);
	};

	struct MultiStackNode {
		using T = MultiStack::T;
		T &&value;
		typename MultiStack::NodeList nodes;

		MultiStack::NodeType operator[](std::size_t size);

		explicit MultiStackNode(T value, typename MultiStack::NodeList nodes = {});

		bool operator==(const MultiStackNode &rhs) const;

		bool operator!=(const MultiStackNode &rhs) const;
	};

	struct Const {
		static MultiStack::T *start_symbol;
	};
}

template<typename T>
bool
operator==(typename Erable::Utils::MultiStack::NodeType lhs, typename Erable::Utils::MultiStack::NodeType rhs);

template<typename T>
bool
operator!=(typename Erable::Utils::MultiStack::NodeType lhs, typename Erable::Utils::MultiStack::NodeType rhs);

#endif //ERABLELANG_MULTISTACK_HPP
