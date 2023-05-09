#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#include "/Users/zhui/IdeaProjects/leetcode/uthash/include/uthash.h"

/***
 * hashtable的实现
 * */

typedef struct {
    int key;
    int val;
    UT_hash_handle hh;
} HashItem;

HashItem* hashFindItem(HashItem** obj, int key) {
    HashItem* pEntry = NULL;
    HASH_FIND_INT(*obj, &key, pEntry);
    return pEntry;
}

bool hashAddItem(HashItem** obj, int key, int val) {
    if (hashFindItem(obj, key)) {
        return false;
    }
    HashItem* pEntry = (HashItem*)malloc(sizeof(HashItem));
    pEntry->key = key;
    pEntry->val = val;
    HASH_ADD_INT(*obj, key, pEntry);
    return true;
}

bool hashSetItem(HashItem** obj, int key, int val) {
    HashItem* pEntry = hashFindItem(obj, key);
    if (!pEntry) {
        hashAddItem(obj, key, val);
    } else {
        pEntry->val = val;
    }
    return true;
}

int hashGetItem(HashItem** obj, int key, int defaultVal) {
    HashItem* pEntry = hashFindItem(obj, key);
    if (!pEntry) {
        return defaultVal;
    }
    return pEntry->val;
}

void hashEraseItem(HashItem** obj, const char* key) {
    HashItem* pEntry = NULL;
    HASH_FIND_INT(*obj, &key, pEntry);
    HASH_DEL(*obj, pEntry);
    free(pEntry);
}

void hashFree(HashItem** obj) {
    HashItem *curr = NULL, *tmp = NULL;
    HASH_ITER(hh, *obj, curr, tmp) {
        HASH_DEL(*obj, curr);
        free(curr);
    }
}

bool equalFrequency(char* word) {
    int cnt[26] = {0};
    int n = strlen(word);
    for (int i = 0; i < n; i++)
        cnt[word[i] - 'a']++;

    // 映射频率   -》 该频率的字母有多少个
    HashItem* freqCount = NULL;
    for (int i = 0; i < 26; i++) {
        if (cnt[i] == 0)
            continue;

        hashSetItem(&freqCount, cnt[i], hashGetItem(&freqCount, cnt[i], 0) + 1);
    }

    HashItem* tmp = NULL;
    if (HASH_COUNT(freqCount) == 1) {
        int key , value;
        for (tmp = freqCount; tmp != NULL; tmp = (HashItem*)tmp->hh.next) {
            key = tmp->key;
            value = tmp->val;
        }
        hashFree(&freqCount);
        return key == 1 || value == 1; 
    }

    if (HASH_COUNT(freqCount) == 2) {
        int pre = -1;
        int preFre = 0;
        int now = 0;
        int nowFre = 0;
        for (tmp = freqCount; tmp != NULL; tmp = (HashItem*)tmp->hh.next) {
            if (pre == -1) {
                pre = tmp->val;
                preFre = tmp->key;
            } else {
                now = tmp->val;
                nowFre = tmp->key;
            }
        }
        if (preFre == 1 && pre == 1) {
            hashFree(&freqCount);
            return true;
        }
        if (nowFre == 1 && now == 1) {
            hashFree(&freqCount);
            return true;
        }
        if (nowFre - preFre == 1 && now == 1) {
            hashFree(&freqCount);
            return true;
        }
        if (preFre - nowFre == 1 && pre == 1) {
            hashFree(&freqCount);
            return true;
        }
    }

    hashFree(&freqCount);
    return false;
}

int main() {
    bool res = equalFrequency("abcc");
    printf("%u\n", res);
}