package 蒸蒸简单;

import java.util.Arrays;

public class 卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int sum = 0;
        int ptr = 0;
        int n = boxTypes.length;
        while (ptr < n && truckSize >= boxTypes[ptr][0]) {
            truckSize -= boxTypes[ptr][0];
            sum += boxTypes[ptr][1] * boxTypes[ptr][0];
            ptr++;
        }
        if (ptr < n) sum += truckSize * boxTypes[ptr][1];
        return sum;
    }
}
