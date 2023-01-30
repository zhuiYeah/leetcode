package 链蒸蒸简单;

//剑指offer
public class 有效的变位词 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return false;
        var ss = new int[26];
        var tt = new int[26];
        for (int i = 0; i < s.length(); i++) ss[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) tt[t.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;
    }
}
