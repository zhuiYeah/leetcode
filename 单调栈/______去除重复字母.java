package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;



/**
 * 去除一个字符串的全部重复字符，只保留一个，并使得剩余字符的字典序最小
 */

public class ______去除重复字母 {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) continue;
            sb.append(arr[i]);
        }
        arr = sb.toString().toCharArray();
        int n = arr.length;

        int[] cnt = new int[26]; //cnt[0]:a必须要删除这么多个
        int[] cntRest = new int[26];//cntRest[0]:a还剩这么多个
        Arrays.fill(cnt, -1);
        for (char c : arr) {
            cnt[c - 'a']++;
            cntRest[c - 'a']++;
        }
        for (int i = 0; i < n - 1; i++) {
            int idx = arr[i] - 'a';
            if (arr[i] > arr[i + 1] && cnt[idx] > 0) {
                arr[i] = '*';
                cnt[idx]--;
            }
            cntRest[idx]--;
        }

        return null;
    }
}



class DDD {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            //如果栈中已包含这个字符 那么不需要了
            if (stack.contains(c)) continue;
            //当前字符比栈顶字符的字典序更小，并且栈顶字符在s[i:]还存在的话，那么栈顶字符可以被弹出
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i + 1) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}