package 蒸蒸简单;


public class 两个相同字符之间的最长子字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] abc = new int[26][2];
        for (int i = 0; i < 26; i++) {
            abc[i][0] = -1;
        }
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (abc[index][0] == -1) {
                abc[index][0] = i;
            } else {
                abc[index][1] = i;
                maxLen = Math.max(maxLen, abc[index][1] - abc[index][0] - 1);
            }
        }
        return maxLen;
    }
}
