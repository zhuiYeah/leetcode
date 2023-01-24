# 给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
#
# 每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
#
# 秩是从 1 开始的一个整数。
# 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
# 如果 p < q ，那么 rank(p) < rank(q)
# 如果 p == q ，那么 rank(p) == rank(q)
# 如果 p > q ，那么 rank(p) > rank(q)
# 秩 需要越 小 越好。
import collections
# 难度2500+

from collections import *
from typing import List


# 拓扑排序 + 并查集
class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        LTM = 512
        R, C = len(matrix), len(matrix[0])
        res = [[0] * C for _ in range(R)]
        countR, countC = [0] * R, [0] * C

        # 按元素大小分别存储元素坐标 到字典ls中 : 7 -> (1,1) (3,4) (5,9)
        ls = defaultdict(list)
        for r, row in enumerate(matrix):  # r指行数 ， row指matrix[r]
            for c, val in enumerate(row):
                ls[val].append((r, c))

        # 并查集用于合并行或列中 值相同的元素
        union = list(range(LTM * 2))

        def find(i):
            if union[i] == i: return i
            union[i] = find(union[i])
            return union[i]

        # ls字典只映射值相同的坐标，pool字典不仅映射值相同的坐标，还需要这些坐标位于同行或同列  a -> (1,1) (3,4) // b-> (5,9)
        pool = collections.defaultdict(list)
        # 按val从小到大遍历
        for val in sorted(ls.keys()):
            # 用并查集合并行和列中 相同的元素并分组
            for (r, c) in ls[val]:
                union[find(r)] = find(c + LTM)
            pool.clear()
            for (r, c) in ls[val]:
                pool[find(r)].append((r, c))
            # 行和列相同的元素，共享相同的rank
            for group in pool.values():
                rank = max(max((countR[r], countC[c])) for r, c in group) + 1
                for (r, c) in group:
                    countR[r] = countC[c] = res[r][c] = rank
                    # 重置并查集
                    union[r] = r
                    union[c + LTM] = c + LTM
        return res
