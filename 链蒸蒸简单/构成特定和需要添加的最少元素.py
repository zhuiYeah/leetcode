from math import ceil
from typing import List


class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        sum = 0
        for num in nums:
            sum += num
        sum = abs(sum - goal)
        res = sum / limit
        return ceil(res)
