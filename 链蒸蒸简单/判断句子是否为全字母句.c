
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

/* 判断一个字符串是否包含了26个小写英文字母 */
bool checkIfPangram(char *s) {
    // 创建一个长度为26的字符数组，用来存储26个小写英文字母
    char letters[26];
    for (int i = 0; i < 26; i++) {
        letters[i] = 'a' + i;
    }

    // 创建一个长度为26的布尔数组，用来记录26个小写英文字母
}