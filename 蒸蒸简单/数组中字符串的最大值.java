package 蒸蒸简单;

public class 数组中字符串的最大值 {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    max = Math.max(max, str.length());
                    break;
                }
                if (i == str.length() - 1) max = Math.max(max, Integer.parseInt(str));
            }
        }
        return max;
    }
}
