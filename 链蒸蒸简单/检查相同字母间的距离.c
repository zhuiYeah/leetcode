
#include <stdbool.h>
#include <string.h>
#include <printf.h>

//s是一个字符串 ， ditance是一个int数组 ， distanceSize是数组长度
bool checkDistances(char *s, int *distance, int distanceSize) {
    int realDis[26];
    int preIndex[26];
    memset(realDis, -1, 26 * sizeof(int));
    memset(preIndex, -1, 26 * sizeof(int));
    for (int i = 0; i < strlen(s); i++) {
        int idx = s[i] - 'a';
        if (preIndex[idx] == -1) preIndex[idx] = i;
        else realDis[idx] = i - preIndex[idx] - 1;
    }
    //for (int i = 0 ; i < 26;i++) printf("%d ", realDis[i]);
    for (int i = 0; i < distanceSize; i++) {
        if (realDis[i] == -1) continue;
        if (realDis[i] != distance[i]) return false;
    }
    return true;
}

int main() {
    char s[] = "aa";
//    int distance[] = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//    checkDistances(s, distance, 26);
    char * str = "Hello World";
    char st[] = "Hello World";
    printf("%c", *(str + 7));
    printf("\n");
    printf("%c", *(st + 7));
    return 0;
}