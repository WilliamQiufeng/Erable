//
// Created by Qiufeng54321 on 2019-07-12.
//

#include ".IntList.hpp"

namespace Erable::Utils {
	Node *BidirectionalIterator::getNode() {
		return node;
	}

	BidirectionalIterator::type BidirectionalIterator::operator*() {
		return node->value;
	}

	BidirectionalIterator BidirectionalIterator::operator++() {
		this->node = this->node->next;
		return *this;
	}

	BidirectionalIterator BidirectionalIterator::operator--() {
		this->node = this->node->last;
		return *this;
	}

	bool BidirectionalIterator::operator==(const BidirectionalIterator &other) const {
		if (this->node == nullptr or other.node == nullptr) {
			//Compare Null pointer
			return this->node == other.node;
		}
		return this->node->value == other.node->value;
	}

	Node *BidirectionalIterator::operator->() {
		return node;
	}

	bool BidirectionalIterator::operator!=(const BidirectionalIterator &rhs) const {
		return !(rhs == *this);
	}

	BidirectionalIterator::BidirectionalIterator(Node *node) : node(node) {}

	BidirectionalIterator::BidirectionalIterator() : BidirectionalIterator(nullptr) {}

	BidirectionalIterator IntList::begin() {
		return BidirectionalIterator(start);
	}

	BidirectionalIterator IntList::end() {
		return BidirectionalIterator(nullptr);
	}

	void IntList::push(type val) {
		insert(end(), val);
	}

	void IntList::pop(type val) {
		erase(end());
	}

	/**
	 **         /next = newNode
	 * last  = last/       \\next = iterator->next
	 * @param iterator the iterator which val will be inserted after
	 * @param val the value being wished to be inserted
	 */
	void IntList::insert(iterator iterator, type val) {
		//O(1)
		if (start->next == start) { //The list is empty
			start->value = val; // change the value of the first element
			start->next = nullptr;
			return;
		}
		if (last->last == last and
			start->next == nullptr) { //The list only contains one element and *last* is not proper
			start->next = last;
			last->value = val;
			last->next = nullptr;
			last->last = start;
			return;
		}
		nodeptr newNode = new Node{val};
		if (BidirectionalIterator(iterator) == end()) {
			newNode->last = last;
			last->next = newNode;
			last = newNode;
		} else {
			newNode->last = iterator.getNode();
			iterator->next->last = newNode;
			newNode->next = iterator->next;
			iterator->next = newNode;
		}
	}

	/**
	 * wraps void IntList::insert(iterator iterator, type val)
	 * @param iterator the iterator which val will be inserted after
	 * @param val the value being wished to be inserted
	 */
	void IntList::insert(nodeptr follow, type val) {
		insert(iterator(follow), val);
	}

	void IntList::insert(std::size_t index, type val) {
		iterator st = begin();
		//O(n)
		for (std::size_t i = 0; i < index and st != end(); i++, ++st);
		insert(st, val);
	}

	std::size_t IntList::size() {
		std::size_t size = 0;
		for (iterator st = begin(); st != end(); ++st, size++);
		return size;
	}

	std::size_t IntList::count(type val) {
		return 0;
	}

	IntList::type &&IntList::operator[](std::size_t index) {
		iterator st = begin();
		//O(n)
		for (std::size_t i = 0; i < index and st != end(); i++, ++st);
		return *st;
	}

	typename IntList::iterator IntList::erase(IntList::iterator iterator) {
		if (iterator.getNode() == end().getNode()) {
			last->last->next = nullptr;
			last = last->last;
		} else if (iterator.getNode() == begin().getNode()) {
			if (iterator->next) {
				iterator->next->last = nullptr;
				iterator->next->next = last;
				start = iterator->next;
			}
		} else if (iterator.getNode()) {
			iterator->last->next = iterator->next;
		}

		return Erable::Utils::IntList::iterator();
	}

	IntList::IntList() {
		reset();
	}

	void IntList::reset() {
		start = new Node{0};
		last = new Node{-1};
		start->next = start;
		start->last = last;
		last->last = last;
		last->next = nullptr;
	}

	Node::Node(Node::type value) : value(value) {}
}