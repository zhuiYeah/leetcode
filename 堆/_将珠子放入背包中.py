from typing import List


class Solution:
    def putMarbles(self, wt: List[int], k: int) -> int:
        for i in range(len(wt) - 1):
            wt[i] += wt[i + 1]
        wt.pop()  # 删除最后一个索引
        wt.sort()
        return sum(wt[len(wt) - k + 1:]) - sum(wt[:k - 1])
