
#include <stdio.h>
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

int main() {
    char s[] = "abcdef";
    int distance[26] = {0, 1, 2, 3, 4};
    //bool result = checkIfPangram(s);
    printf("hello world\n");
    return 0;
}