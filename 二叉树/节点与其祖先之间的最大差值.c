
#include <stddef.h>
#include <stdlib.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a): (b))


struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int res;

void dfs(struct TreeNode *root, int min, int max);

int maxAncestorDiff(struct TreeNode *root) {
    res = 0;
    dfs(root, root->val, root->val);
    return res;
}

void dfs(struct TreeNode *root, int min, int max) {
    if (root == NULL) return;
    res = MAX(res, abs(root->val - min));
    res = MAX(res, abs(root->val - max));
    min = MIN(min, root->val);
    max = MAX(max, root->val);
    dfs(root->left, min, max);
    dfs(root->right, min, max);
}


