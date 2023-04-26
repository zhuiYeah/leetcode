#include <string.h>
#include <stdio.h>
#include <stdlib.h>


int longestDecomposition(char *text) {
    int n = strlen(text);
    if (n == 0 || n == 1) return n;
    for (int i = 0; i < n / 2; i++) {
//        if (text.substring(0, i + 1).equals(text.substring(n - i - 1))) {
//            return 2 + longestDecomposition(text.substring(i + 1, n - i - 1));
//        }
        char *left_substring = (char *) malloc((i + 2) * sizeof(char));
        //*(left_substring + i + 1) = '\0';
        memset(left_substring, 0, i + 1);
        strncpy(left_substring, text, i + 1);

        char *right_substring = (char *) malloc((i + 2) * sizeof(char));
        *(right_substring + i + 1) = '\0';
        strncpy(right_substring, text + n - i - 1, i + 1);
        if (strcmp(left_substring, right_substring) == 0) {
            char *subtext = (char *) malloc((n - i - 1 - i - 1 + 1) * sizeof(char));
            strncpy(subtext, text + i + 1, n - i - 1 - i - 1);
            *(subtext + n - i - 1 - i - 1) = '\0';
            return 2 + longestDecomposition(subtext);
        }
        free(left_substring);
        free(right_substring);
    }
    return 1;
}


int main() {
//    char str[] = "hello world";
//    char *substring;
//    int i = 4;
//
//    substring = (char *) malloc((i + 2) * sizeof(char));
//    strncpy(substring, str, i + 1);
//
//
//    printf("str: %s\n", str);
//    printf("substring: %s\n", substring);

    char *text = "aaaa";
    int res = longestDecomposition(text);
    printf("%d", res);
    return 0;
}


int help(char *text, int i, int i1);


//int longestDecomposition2(char *text) {
//    int n = strlen(text);
//    if (n == 0 || n == 1) return n;
////    for (int i = 0; i < n / 2; i++) {
//////        if (text.substring(0, i + 1).equals(text.substring(n - i - 1))) {
//////            return 2 + longestDecomposition(text.substring(i + 1, n - i - 1));
//////        }
////        char *left_substring = (char *) malloc((i + 2) * sizeof(char));
////        strncpy(left_substring, text, i + 1);
////        char *right_substring = (char *) malloc((i + 2) * sizeof(char));;
////        strncpy(right_substring, text + n - i - 1, i + 1);
////        if (strcmp(left_substring, right_substring) == 0) {
////            char *subtext = (char *) malloc((n - i - 1 - i - 1 + 1) * sizeof(char));;
////            strncpy(subtext, text + i + 1, n - i - 1 - i - 1);
////            return 2 + longestDecomposition(subtext);
////        }
////        free(left_substring);
////        free(right_substring);
////    }
//
//    return help(text, 0, n - 1);
//}
//
//int help(char *text, int l, int r) {
//    int n = strlen(text);
//    if (n == 0 || n == 1) return n;
//    for (int i = l; i < l + (r - l) / 2; i++) {
//        if (strCmp(text, ,))
//    }
//}

