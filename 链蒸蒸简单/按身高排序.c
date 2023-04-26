#include  <stdlib.h>

int *HEIGHT;

int compare(const void *a, const void *b) {
    int aa = *(int *) a, bb = *(int *) b;
    return HEIGHT[bb] - HEIGHT[aa];
}

char **sortPeople(char **names, int namesSize, int *heights, int heightsSize, int *returnSize) {
    HEIGHT = heights;
    int idx[namesSize];
    for (int i = 0; i < namesSize; i++) idx[i] = i;
    qsort(idx, namesSize, sizeof(int), compare);
    char **res = (char **) malloc(namesSize * sizeof(char *));
    for (int i = 0; i < namesSize; i++) res[i] = names[idx[i]];
    *returnSize = namesSize;
    return res;
}