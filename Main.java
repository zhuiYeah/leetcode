import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "192.168.0.1";
        String[] val = s.split("\\.");
        long[] nums = new long[4];
        int i = -1;
        for (String x : val) {
            i++;
            nums[i] = Long.parseLong(x);
        }
        long res = 0;
        res = ( nums[0] << 24) + (nums[1] << 16) + (nums[2] << 8) + (nums[3]);
//        int bits = 0;
//        for (i = 3; i >= 0; i--) {
//            for (int j = 0; j < 8; j++) {
//                if ((1 << j & nums[i]) != 0) {
//                    res = res + (1L << bits);
//                }
//                bits++;
//            }
//        }
        System.out.println(res);
    }
}
