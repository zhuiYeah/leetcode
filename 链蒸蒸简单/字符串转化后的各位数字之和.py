
# ord函数将单个字符转换为 unicode编码
class Solution:
    def getLucky(self, s: str, k: int) -> int:
        s1 = ""
        for c in s:
            num = ord(c) - ord('a') + 1
            s1 += str(num)
        num = 0
        for i in range(0, k):
            num = 0
            for c in s1:
                num += ord(c) - ord('0')
            s1 = str(num)

        return num
