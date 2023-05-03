//
// Created by 爽 on 2023/5/2.
//
#include  <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>


typedef struct {
    int key;
    int val;
    UT_hash_handle hh;
} HashItem;

HashItem *hashFindItem(HashItem **obj, int key) {
    HashItem *pEntry = NULL;
    HASH_FIND_INT(*obj, &key, pEntry);
    return pEntry;
}

bool hashAddItem(HashItem **obj, int key, int val) {
    if (hashFindItem(obj, key)) {
        return false;
    }
    HashItem *pEntry = (HashItem *) malloc(sizeof(HashItem));
    pEntry->key = key;
    pEntry->val = val;
    HASH_ADD_INT(*obj, key, pEntry);
    return true;
}

bool hashSetItem(HashItem **obj, int key, int val) {
    HashItem *pEntry = hashFindItem(obj, key);
    if (!pEntry) {
        hashAddItem(obj, key, val);
    } else {
        pEntry->val = val;
    }
    return true;
}

int hashGetItem(HashItem **obj, int key, int defaultVal) {
    HashItem *pEntry = hashFindItem(obj, key);
    if (!pEntry) {
        return defaultVal;
    }
    return pEntry->val;
}

void hashEraseItem(HashItem **obj, const char *key) {
    HashItem *pEntry = NULL;
    HASH_FIND_INT(*obj, &key, pEntry);
    HASH_DEL(*obj, pEntry);
    free(pEntry);
}

void hashFree(HashItem **obj) {
    HashItem *curr = NULL, *tmp = NULL;
    HASH_ITER(hh, *obj, curr, tmp)
    {
        HASH_DEL(*obj, curr);
        free(curr);
    }
}

int *powerfulIntegers(int x, int y, int bound, int *returnSize) {
    HashItem *set = NULL;
    int val1 = 1;
    for (int i = 0; i <= 20; i++) {
        int val2 = 1;
        for (int j = 0; j <= 20; j++) {
            int val = val1 + val2;
            if (val > bound) break;
            hashAddItem(&set, val, 1);
            val2 *= y;
            if (val2 >= bound) break;
        }
        val1 *= x;
        if (val1 >= bound) break;
    }
    HashItem *tmp = NULL;
    *returnSize = HASH_COUNT(set);
    int *res = (int *) malloc(sizeof(int) * *returnSize);
    int i = -1;
    for (tmp = set ; tmp != NULL; tmp = (HashItem *) tmp->hh.next) {
        res[++i] = tmp->key;
    }
    return res;
}