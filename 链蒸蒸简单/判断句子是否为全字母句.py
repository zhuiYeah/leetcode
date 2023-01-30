#!/usr/bin/env python3


class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        xx = set(sentence)
        return len(xx) == 26




if __name__ == "__main__":
    solution = Solution()
    x = solution.checkIfPangram('qwertyuiopasdfghjklzxcvbnm')
    print(x)
