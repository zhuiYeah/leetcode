package 蒸蒸简单;

public class 字符串转化后的各位数字之和 {
    public int getLucky(String s, int k) {
        var s1 = "";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            s1 += num;
        }
        var num = 0;
        for (int i = 0; i < k; i++) {
            num = 0;
            for (int j = 0; j < s1.length(); j++)
                num += s1.charAt(j) - '0';
            s1 = String.valueOf(num);
        }

        return num;
    }
}
