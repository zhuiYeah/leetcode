package 链蒸蒸简单;

//java向右取整
public class 构成特定和需要添加的最少元素 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        sum = Math.abs(sum - goal);
        double res = sum / (double)limit;
        return (int) Math.ceil(res);
    }
}
