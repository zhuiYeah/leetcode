package 贪心;


/**你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:

 subtexti 是 非空 字符串
 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 返回k可能最大值。

 text = "ghiabcdefhelloadamhelloabcdefghi"
 输出：7
 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。

 */


//贪心 + 递归
public class 段式回文 {
    public int longestDecomposition(String text) {
        int n = text.length();
        if (n == 0 || n == 1) return n;
        for (int i = 0; i < n / 2; i++) {
            if (text.substring(0, i + 1).equals(text.substring(n - i - 1))) {
                return 2 + longestDecomposition(text.substring(i + 1, n - i - 1));
            }
        }
        return 1;
    }
}

class Test{
    public static void main(String[] args){
        new 段式回文().longestDecomposition(new String("aaaa"));
    }
}



