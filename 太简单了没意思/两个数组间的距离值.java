package 太简单了没意思;

public class 两个数组间的距离值 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
