#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

bool compare(const char *s, const char *pattern) {
    int n = strlen(pattern);
    int p = 0;
    for (int i = 0; i < strlen(s); i++) {
        if (s[i] >= 'A' && s[i] <= 'Z' && (p == n || pattern[p] != s[i])) return false;
        if (s[i] >= 'A' && s[i] <= 'Z' && pattern[p] == s[i]) p++;
        if (s[i] >= 'a' && s[i] <= 'z' && p < n && s[i] == pattern[p]) p++;
    }
    return p == n;
}


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool *camelMatch(char **queries, int queriesSize, char *pattern, int *returnSize) {
    bool *res = (bool *) malloc(queriesSize * sizeof(bool));
    *returnSize = queriesSize;
    for (int i = 0; i < queriesSize; i++) {
        if (compare(queries[i], pattern)) res[i] = true;
        else res[i] = false;
    }
    return res;

//    int x[10];
//    int * x = (int *)malloc( 10 * sizeof(int));
}


//int main() {
//    char **words;
//
//    // 分配存储 3 个字符串指针的内存空间
//    words = (char **) malloc(3 * sizeof(char *));
//
//    // 分别为每个字符串指针分配内存，并将其赋值给指针数组
//    words[0] = (char *) malloc(20 * sizeof(char));
//    words[1] = (char *) malloc(20 * sizeof(char));
//    words[2] = (char *) malloc(2 * sizeof(char));
//
//    // 给每个字符串赋值
//    strcpy(words[0], "hello");
//    strcpy(words[1], "world");
//    strcpy(words[2], "x");
//
//
//    bool *res = camelMatch(words, 3, "o", 0);
//
//    for (int i = 0; i < 3; i++) {
//        printf("%d\n", res[i]);
//    }
//    // 释放分配的内存
//    for (int i = 0; i < 3; i++) {
//        free(words[i]);
//    }
//    free(words);
//
//}


int *test() {
    int x[10];
    //int *x = malloc(10 * sizeof(int));
    for (int i = 0; i < 10; i++) {
        x[i] = i;
    }
    return x;
}



int main() {
    int *x = test();
    for (int i = 0; i < 100; i++) printf("%d \t", x[i]);
}

