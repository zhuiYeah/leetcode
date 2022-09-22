package 数组;

public class 在既定时间做作业的学生人数 {
    class Solution {
        int res;

        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            for (int i = 0; i < startTime.length; i++) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                    res++;
                }
            }
            return res;
        }

    }
}
