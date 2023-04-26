#include <stdbool.h>
#include <string.h>


bool isRobotBounded(char *instructions) {
    int direction[4][2] = {{0,  1},
                           {-1, 0},
                           {0,  -1},
                           {1,  0}};
    int x = 0, y = 0;
    int c = 0;
    int n = strlen(instructions);
    for (int i = 0; i < 4 * n; i++) {
        int idx = i % n;
        if (instructions[idx] == 'R') {
            c = (c + 3) % 4;
        } else if (instructions[idx] == 'L') {
            c = (c + 1) % 4;
        } else {
            x += direction[c][0];
            y += direction[c][1];
        }
        if (x == 0 && y == 0 && i % n == n - 1) return true;
    }
    return false;
}