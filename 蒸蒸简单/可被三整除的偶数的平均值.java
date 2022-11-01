package 蒸蒸简单;

public class 可被三整除的偶数的平均值 {
    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]%2 ==0 && nums[i]%3 ==0 ){
                count++;
                sum += nums[i];
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }
}
