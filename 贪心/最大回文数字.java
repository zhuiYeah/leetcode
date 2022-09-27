package 贪心;

//贪心还挺有意思的
//使用num中的数字组成一个最大回文整数
public class 最大回文数字 {
    public String largestPalindromic(String num) {
        int[] count = new int[10];//记录数字0～9出现的次数
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            count[x]++;
        }
        StringBuilder res = new StringBuilder();
        if (onlyZero(count)) {
            for (int i = 9; i >= 0; i--) {
                if (count[i] == 1) {
                    return String.valueOf(i);
                }
            }
            return "0";
        }

        for (int i = 0; i < 10; i++) {
            int x = count[i];//数字i出现了x次
            if (x == 0 || x == 1) {
                continue;
            }
            String repeat = String.valueOf(i).repeat(x / 2);
            res.append(repeat);
            res.insert(0, repeat);
            if (x % 2 == 0) {
                count[i] = 0;
            } else {
                count[i] = 1;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (count[i] == 1) {
                res.insert(res.length() / 2, i);
                break;
            }
        }
        return res.toString();
    }

    //0～9只有0出现了1次以上，并且 其余的数字只出现了一次以下
    public boolean onlyZero(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 9;

        System.out.println(x);
    }
}
