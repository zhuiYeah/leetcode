package 面试;

//public class Main {
//    public int numSubarraysWithSum(int[] A, int S) {
//        int count = 0, sum = 0, left = 0;
//        for (int right = 0; right < A.length; right++) {
//            sum += A[right];
//            while (sum > S && left <= right) { // 如果当前子数组和大于S则左指针右移
//                sum -= A[left++];
//            }
//            if (sum == S) { // 如果当前子数组和等于S则计数器增加1
//                count++;
//            }
//        }
//        return count;
//    }
//}

