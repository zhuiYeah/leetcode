#include  <stdlib.h>
#include <stdbool.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

int top = -1; //栈顶指针

void push(int *stack, int val) {
    top++;
    stack[top] = val;
}

int pop(int *stack) {
    int res;
    res = stack[top];
    top--;
    return res;
}

int peek(int *stack) {
    return stack[top];
}

bool isEmpty() {
    return top < 0;
}


int *nextLargerNodes(struct ListNode *head, int *returnSize) {
    top = -1;
    struct ListNode *tmp = head;
    int n = 0;//链表长度
    while (tmp) {
        tmp = tmp->next;
        n++;
    }
    int *ans = (int *) calloc(n, sizeof(int));
    tmp = head;
    int list[n];
    int idx = -1;
    while (tmp) {
        idx++;
        list[idx] = tmp->val;
        tmp = tmp->next;
    }
    int stack[10005];
    for (int i = 0; i < n; i++) {
        while (!isEmpty() && list[i] > list[peek(stack)]) {
            int index = pop(stack);
            ans[index] = list[i];
        }
        push(stack, i);
    }
    *returnSize = n;
    return ans;
}


int main() {
    struct ListNode *head = (struct ListNode *) malloc(sizeof(struct ListNode));
    head->val = 1;
    int n = 1;
    int *ptr = &n;
    nextLargerNodes(head, ptr);
}

