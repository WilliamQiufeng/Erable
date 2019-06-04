#ifndef _ERABLE_SCANNER_HPP_
#define _ERABLE_SCANNER_HPP_

#include <string>

namespace Erable {
    namespace Compiler {
        namespace Scanner {
            const char CR = '\r';
            const char LF = '\n';
            // tokenizer rules are following erable.txt

            inline bool isWhitespace(char c) {
                switch (static_cast<int>(c)) {
                    case 0x09:
                    case 0x0a:
                    case 0x0b:
                    case 0x0c:
                    case 0x0d:
                    case 0x20:
                    case 0x85:
                    case 0xA0:
                        return true;
                    default:
                        return false;
                }
            }

            inline bool isWS(char c) {
                return isWhitespace(c) || c == CR || c == LF;
            }

            inline bool isLetter(char c) {
                return ('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c);
            }

            inline bool isAlphanumeric(char c) {
                return isLetter(c) || ('0' <= c && '9' >= c);
            }

            inline bool isIDHead(char c) {
                return isLetter(c) || c == '_';
            }

            inline bool isIDTail(char c) {
                return isLetter(c) || isAlphanumeric(c);
            }

            inline bool isNonPrintable(char c) {
                return 0x00 <= c && 0x1f >= c;
            }

            inline bool isPrintable(char c) {
                return !isNonPrintable(c);
            }

            inline bool isBinaryDigit(char c) {
                return c == '0' || c == '1';
            }

            inline bool isOctalDigit(char c) {
                return '0' <= c && '7' >= c;
            }

            inline bool isDecimalDigit(char c) {
                return '0' <= c && '9' >= c;
            }

            inline bool isHexadecimalDigit(char c) {
                return isDecimalDigit(c) ||
                       ('A' <= c && 'F' >= c) ||
                       ('a' <= c && 'f' >= c);
            }

            inline bool isBinaryDigits(char *s) {
                size_t length = sizeof(s) / sizeof(char);
                for (size_t i = 0; i < length; ++i) {
                    if (!isBinaryDigit(s[i])) {
                        return false;
                    }
                }
                return true;
            }

            inline bool isOctalDigits(char *s) {
                size_t length = sizeof(s) / sizeof(char);
                for (size_t i = 0; i < length; ++i) {
                    if (!isOctalDigit(s[i])) {
                        return false;
                    }
                }
                return true;
            }

            inline bool isDecimalDigits(char *s) {
                /*bool isFraction = false;
                bool isExponent = false;
                int i = 0;
                while (s[i++] != '\0')
                {
                    if (!isDecimalDigit(s[i]))
                    {
                        ++i;
                        if (s[i] == '.' && !isFraction)
                        {
                            isFraction = true;
                            continue;
                        }
                        else if (s[i] == 'E' && !isExponent)
                        {
                            i++;
                            if (!isDecimalDigit(s[i]) && s[i + 1] != '+' && s[i + 1] != '-')
                            {
                                return false;
                            }
                            continue;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }*/

                size_t length = sizeof(s) / sizeof(char);
                for (size_t i = 0; i < length; ++i) {
                    if (!isDecimalDigit(s[i])) {
                        return false;
                    }
                }
                return true;
            }

            inline bool isHexadecimalDigits(char *s) {
                //bool isFraction = isExponent = false;
                size_t length = sizeof(s) / sizeof(char);
                for (size_t i = 0; i < length; ++i) {
                    if (!isHexadecimalDigit(s[i])) {
                        return false;
                    }
                }
                return true;
            }


        }
    }
}


#endif // !_ERABLE_SCANNER_HPP_
