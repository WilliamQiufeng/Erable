#include <iostream>
#include <regex>
#include <string>


class A{
public:
    explicit A(int a) : a(a) {}
    int a = 0;
};
class B : public A{
public:
    B(int a) : A(a) {}
};
class C : public A{
public:
    C(int a) : A(a) {}
};
typedef std::unique_ptr<A> Aptr;
Aptr operator+(Aptr& a, Aptr& b) {
    return std::make_unique<A>(a->a + b->a);
}
struct i512 {
	long long u1,u2,u3,u4,u5,u6,u7,u8;
};
int main() {
    std::regex regex("\".*", std::regex_constants::ECMAScript | std::regex_constants::icase);
    std::string testMatch = "\"h";
    bool matches = std::regex_match(testMatch, regex);
    std::cout<<"The testMatch " << (matches?"":"doesn't ") << "match the regex." <<std::endl;
    Aptr a = std::make_unique<B>(2);
    Aptr b = std::make_unique<C>(3);
    Aptr c = a + b;
    std::cout<<c->a<<std::endl;
    i512 i{1111111111,222222222222,333333333333,444444444444,555555555555,666666666666,777777777777,888888888888};
    std::cout.write((char*)&i, sizeof(i));
    return 0;
}