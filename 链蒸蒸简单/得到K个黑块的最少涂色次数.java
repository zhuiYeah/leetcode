package 链蒸蒸简单;

//固定窗口的滑动窗口
//W B
public class 得到K个黑块的最少涂色次数 {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        var arr = blocks.toCharArray();
        int n = arr.length;
        int l = 0, r = k - 1;
        int cnt = 0;
        for (int i = l; i <= r; i++) cnt += arr[i] == 'W' ? 0 : 1;
        min = Math.min(min, cnt);
        for (r = k; r < n; r++) {
            cnt += arr[r] == 'W' ? 0 : 1;
            cnt -= arr[l] == 'B' ? 1 : 0;
            l++;
            min = Math.min(min, cnt);
        }
        return min;
    }
}
