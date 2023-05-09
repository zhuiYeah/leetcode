//
// Created by 爽 on 2023/5/1.
//
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define INITIAL_CAPACITY 16

/**
 * ArrayList 的实现
 * */
struct ArrayList {
    int size;
    int capacity;
    int *data;
};

void init(struct ArrayList *list) {
    list->size = 0;
    list->capacity = INITIAL_CAPACITY;
    list->data = (int *) malloc(sizeof(int) * list->capacity);
}

int get(struct ArrayList *list, int idx) {
    if (idx < 0 || idx >= list->size) {
        printf("Index out of bounds.\n");
        exit(1);
    }
    return list->data[idx];
}

void set(struct ArrayList *list, int idx, int val) {
    if (idx < 0 || idx >= list->size) {
        printf("Index out of bounds.\n");
        exit(1);
    }
    list->data[idx] = val;
}

void add(struct ArrayList *list, int val) {
    if (list->size == list->capacity) {
        list->capacity *= 2;
        list->data = realloc(list->data, sizeof(int) * list->capacity);
    }
    list->data[list->size++] = val;
}

void removeAt(struct ArrayList *list, int idx) {
    if (idx < 0 || idx >= list->size) {
        printf("Index out of bounds.\n");
        exit(1);
    }
    for (int i = idx + 1; i < list->size; i++) {
        list->data[i - 1] = list->data[i];
    }
    list->size--;
}

void freeList(struct ArrayList *list) {
    free(list->data);
}


void dfs(int cur, int usedTime, int *res, struct ArrayList *g, int *informTime) {
    if (usedTime > *res) *res = usedTime;
    for (int i = 0; i < g[cur].size; i++) {
        int nxt = g[cur].data[i];
        dfs(nxt, usedTime + informTime[cur], res, g, informTime);
    }
}

int numOfMinutes(int n, int headID, int *manager, int managerSize, int *informTime, int informTimeSize) {
    struct ArrayList g[n];
    for (int i = 0; i < n; i++) init(&g[i]);
    for (int i = 0; i < n; i++) {
        int a = manager[i], b = i;
        if (a == -1) continue;
        add(&g[a], b);
    }
    int *res = malloc(sizeof(int));
    memset(res, 0, sizeof(int));
    dfs(headID, 0, res, g, informTime);
    for (int i = 0; i < n; i++) freeList(&g[i]);
    return *res;
}


#define  message_for(a, b)  printf(#a " and " #b ": We love you!\n")

#if !defined (MESSAGE)
#define MESSAGE "You wish!"
#endif
int main()
{
    printf("File :%s\n", __FILE__ );
    printf("Date :%s\n", __DATE__ );
    printf("Time :%s\n", __TIME__ );
    printf("Line :%d\n", __LINE__ );
    printf("ANSI :%d\n", __STDC__ );
    message_for(Carole, Debra);
    printf("Here is the message: %s\n", MESSAGE);
    return 0;
}

