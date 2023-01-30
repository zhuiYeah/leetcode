package 链蒸蒸简单;

public class 多数元素 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (count == 0) {
                    num = nums[i];
                    count++;
                } else {
                    count--;
                }
            }
        }
        return num;
    }
}
