package 数组;

public class 拆炸弹 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int left, right;
        int sum = 0;
        if (k > 0) {
            left = 1;
            right = k;
            for (int i = left; i <= right; i++) {
                sum += code[i];
            }
        } else if (k < 0) {
            left = n + k;
            right = n - 1;
            for (int i = left; i <= right; i++) {
                sum += code[i];
            }
        } else {
            return new int[code.length];
        }
        int[] result = new int[n];
        result[0] = sum;
        for (int i = 1; i < n; i++) {
            sum -= code[left];
            left++;
            right++;
            if (left >= n) left = 0;
            if (right >= n) right = 0;
            sum += code[right];
            result[i] = sum;
        }
        return result;

    }
}
