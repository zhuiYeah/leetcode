from typing import List, Counter


class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        cnt = Counter()
        ans = left = pairs = 0
        for x in nums:
            pairs += cnt[x]
            cnt[x] += 1
            while left < len(nums) and pairs - cnt[nums[left]] + 1 >= k:
                pairs -= cnt[nums[left]] - 1
                cnt[nums[left]] -= 1
                left += 1
            if pairs >= k:
                ans += left + 1
        return ans