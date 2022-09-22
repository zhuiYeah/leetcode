package 排序;

import java.util.Arrays;

//如果数组恰有x个大于等于x的数字，则该数组的特征值为x
public class 特殊数组的特征值 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        //int数组的封装
        var nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2, (a, b) -> {
            return b - a;
        });
        //特征值最大为数组长度
        int eigenvalues = n;
        //指向当前数字
        int ptr = 0;
        //记录大于等于eigenvalues的数字的个数
        int count = 0;
        while (eigenvalues >= 0) {
            while (ptr < n && nums2[ptr] >= eigenvalues) {
                count++;
                ptr++;
            }
            if (count == eigenvalues) {
                return eigenvalues;
            } else if (count > eigenvalues) { //count 增， eigenvalues减，两者再也不会相等
                break;
            }
            eigenvalues--;
        }
        return -1;
    }
}
