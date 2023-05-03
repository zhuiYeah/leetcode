//
// Created by 爽 on 2023/5/3.
//
#include  <stdbool.h>
#include <string.h>

bool isValid(char *s) {
    int n = strlen(s);
    int top = -1;
    char stack[n];//数组模拟栈，top模拟栈顶
    for (int i = 0; i < n; i++) {
        if (s[i] == 'c') {
            if (top >= 1 && stack[top] == 'b' && stack[top - 1] == 'a') {
                top -= 2;
            }else{
                return false;
            }
        } else {
            stack[++top] = s[i];
        }
    }
    return top == -1;
}