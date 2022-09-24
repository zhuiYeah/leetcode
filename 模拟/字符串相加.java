package 模拟;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        int add = 0;
        int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1;
        String res = "";
        while (ptr1 >= 0 && ptr2 >= 0) {
            int a = num1.charAt(ptr1) - '0';
            int b = num2.charAt(ptr2) - '0';
            int sum = a + b + add;
            add = sum / 10;
            sum %= 10;
            res = sum + res;
            ptr1--;
            ptr2--;
        }
        while (ptr1 >= 0) {
            int a = num1.charAt(ptr1) - '0';
            int sum = a + add;
            add = sum / 10;
            sum %= 10;
            res = sum + res;
            ptr1--;

        }
        while (ptr2 >= 0) {
            int a = num2.charAt(ptr2) - '0';
            int sum = a + add;
            add = sum / 10;
            sum %= 10;
            res =  sum + res;
            ptr2--;
        }
        if (add != 0) {
            res = add + res;
        }
        return res;
    }
}
