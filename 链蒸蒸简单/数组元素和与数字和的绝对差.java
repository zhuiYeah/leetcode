package 链蒸蒸简单;

public class 数组元素和与数字和的绝对差 {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int bitSum = 0;
        for (int i : nums) sum += i;
        for (int i : nums) {
            while (i > 0) {
                bitSum += i % 10;
                i /= 10;
            }
        }

        return Math.abs(sum - bitSum);
    }
}
