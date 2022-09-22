package 数学;

//1~n,构造一个数组，使得数组所有元素的相邻差的不同种类为k个
public class 优美的排列II {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        //构造k个差，最少需要k+1个数
        int i = 0;//i指向数组当前需要构造的数字的下标位置
        for (i = 0; i < n - k - 1; i++) {
            res[i] = i + 1;
        }
        int left = n - k - 1;
        int right = n - 1;
        while (left <= right) {
            if (left == right) {
                res[i] = left + 1;
                break;
            }
            res[i] = left + 1;
            res[i + 1] = right + 1;
            left++;
            right--;
            i += 2;
        }
        return res;
    }
}
