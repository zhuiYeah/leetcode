package 贪心;

public class 部分排序 {
    public int[] subSort(int[] array) {

        int right = -1;
        int left = -1;
        if (array.length == 0) {
            return new int[]{left, right};
        }
        int curMax = array[0];
        int curMin = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= curMax) {
                curMax = array[i];
            } else {
                right = i;
            }
            if (array[array.length - 1 - i] <= curMin) {
                curMin = array[array.length - 1 - i];
            } else {
                left = array.length - 1 - i;
            }
        }
        return new int[]{left, right};
    }
}
