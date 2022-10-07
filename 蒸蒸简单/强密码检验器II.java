package 蒸蒸简单;

import java.util.HashSet;
import java.util.Set;

//第80场双周赛
public class 强密码检验器II {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        Set<Character> set = new HashSet<Character>();
        char[] x = new char[]{'!', '@', '#', '%', '^', '&', '*', '+', '-', '(', ')', '$'};
        for (char c : x) {
            set.add(c);
        }
        boolean num = false, small = false, big = false, special = false;
        for (int i = 0; i < password.length(); i++) {
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false;
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') {
                num = true;
            } else if (c >= 'a' && c <= 'z') {
                small = true;
            } else if (c >= 'A' && c <= 'Z') {
                big = true;
            } else if (set.contains(c)) {
                special = true;
            }
        }
        return num && small && big && special;
    }
}
