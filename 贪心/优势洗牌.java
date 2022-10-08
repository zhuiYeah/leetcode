package 贪心;

//nums1和nums2是两个长度相同的数组，进行田忌赛马，改变nums1的排列使得nums1取得最大优势，
import java.util.ArrayDeque;
import java.util.Arrays;

//思路：nums1和nums2进行排序，ptr1，ptr2，不断滑动ptr1找到最小的使得ptr1大于ptr2的数字，填入res；未使用的ptr1指向的数字存入一个队列unused
public class 优势洗牌 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        var res = new int[n];
        Arrays.fill(res, -1);
        //记录nums1中暂时未使用的较小数字（田忌赛马中的弱小马去跟对面的强大马比较）
        var unused = new ArrayDeque<Integer>();
        //num2X 记录 num2的数字和下标，因为nums2要被排序打乱顺序
        var num2X = new int[n][2];
        for (int i = 0; i < num2X.length; i++) {
            num2X[i][0] = nums2[i];
            num2X[i][1] = i;
        }
        Arrays.sort(num2X, (a, b) -> {
            return a[0] - b[0];
        });
        Arrays.sort(nums1);
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < n) {
            while (ptr1 < n && nums1[ptr1] <= num2X[ptr2][0]) {
                unused.add(nums1[ptr1]);
                ptr1++;
            }
            //循环之后 要么 num1[ptr1] > num2X[ptr2][0] ，要么ptr1越界
            if (ptr1 == n) break;
            res[num2X[ptr2][1]] = nums1[ptr1];
            ptr1++;
            ptr2++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                res[i] = unused.poll();
            }
        }
        return res;
    }
}
