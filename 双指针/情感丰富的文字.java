package 双指针;

//words数组里面的字符串能否扩展成为情感丰富的字符串
public class 情感丰富的文字 {

    public int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (can(s, word)) cnt++;
        }
        return cnt;
    }

    private static boolean can(String a, String b) {
        int m = a.length(), n = b.length();
        int pa = 0, pb = 0;
        while (pa < m && pb < n) {
            int oldpa = pa, oldpb = pb;
            if (a.charAt(pa) != b.charAt(pb)) return false;
            pa++;
            pb++;
            while (pa < m && a.charAt(pa) == a.charAt(pa - 1)) pa++;
            while (pb < n && b.charAt(pb) == b.charAt(pb - 1)) pb++;
            int lena = pa - oldpa, lenb = pb - oldpb;
            if (lena < lenb || lena < 3 && lena != lenb) return false;
        }
        return pa == m && pb == n;
    }

    public static void main(String[] args) {
        can("heeellooo", "hello");
    }
}
