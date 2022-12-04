package 蒸蒸简单;

public class 移动所有球到每个盒子所需的最小操作数 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        //cnt[i][j] = 将i 移到 j需要的操作数
        var cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '0') continue;
            for (int j = 0; j < n; j++) {
                cnt[i][j] = Math.abs(i - j);
            }
        }
        var res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j] += cnt[i][j];  //80ms
                //res[i] += cnt[j][i]; //400ms ，很有趣
            }
        }

        return res;
    }
}
