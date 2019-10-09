//
// Created by Qiufeng54321 on 2019-07-12.
//

#ifndef ERABLELANG_INTLIST_HPP
#define ERABLELANG_INTLIST_HPP

#include "Headers.hpp"

namespace Erable::Utils {
	struct Node {
		typedef int type;

		Node(type value);

		type value;
		Node *last = nullptr, *next = nullptr;
	};

	class BidirectionalIterator {
		Node *node = nullptr;
	public:
		typedef int type;

		BidirectionalIterator(Node *node);

		BidirectionalIterator();

		Node *getNode();

		type operator*();

		BidirectionalIterator operator++();

		BidirectionalIterator operator--();

		bool operator==(const BidirectionalIterator &other) const;

		bool operator!=(const BidirectionalIterator &rhs) const;

		Node *operator->();
	};

	class IntList {
		Node *start, *last;
	public:
		typedef int type;
		typedef BidirectionalIterator iterator;
		typedef Node *nodeptr;

		IntList();

		iterator begin();

		iterator end();

		void push(type val);

		void pop(type val);

		void insert(iterator iterator, type val);

		void insert(nodeptr follow, type val);

		void insert(std::size_t index, type val);

		iterator erase(iterator iterator);

		std::size_t size();

		std::size_t count(type val);

		void reset();

		type &&operator[](std::size_t index);
	};
}

#endif //ERABLELANG_INTLIST_HPP
