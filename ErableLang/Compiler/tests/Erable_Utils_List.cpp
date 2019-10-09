//
// Created by Qiufeng54321 on 2019-07-18.
//
#define CATCH_CONFIG_MAIN


#include <catch2/catch.hpp>
#include "Erable_Utils_List.hpp"

using namespace Erable::Utils;

TEST_CASE("Insert and iterate", "[insertion][iteration]") {
	List<int> list;
	list.insert(list.begin(), 1);
	list.push(2);
	list.push(3);
	for (auto &&item : list) {

	}
}
