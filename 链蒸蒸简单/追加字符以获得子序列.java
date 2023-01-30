package 链蒸蒸简单;

public class 追加字符以获得子序列 {
    public int appendCharacters(String s, String t) {
        int ptrS = 0, ptrT = 0;
        int m = s.length(), n = t.length();
        while (ptrS < m) {
            if (ptrT == n) return 0;
            while (ptrS < m && s.charAt(ptrS) != t.charAt(ptrT)) ptrS++;
            if (ptrS >= m) break;
            ptrS++;
            ptrT++;
        }
        return n - ptrT;
    }
}


