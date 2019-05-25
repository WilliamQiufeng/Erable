# 编译后文件头

文件头共5 Bytes，其中包含：

+ 魔数 2 Bytes（0xe4,0xab)代表erab
+ 版本号 2 Bytes（Major version 1B + Minor version 1B = 2B)
+ ID和CID长度 1 Byte（ID length 4bits + CID length 4bits = 1B）





# Header in Compiled erable file

There are 5 bytes for the header including:

+ Magic Number 2 Bytes (0xe4, 0xab representing "erab")
+ Version 2 Bytes (Major version 1B + Minor version 1B = 2B)
+ Length of ID and CID: 1 Byte (ID length 4 bits + CID length 4bits = 1B)