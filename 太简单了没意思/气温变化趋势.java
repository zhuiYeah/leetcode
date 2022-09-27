package 太简单了没意思;

//没什么好说的 简单题
public class 气温变化趋势 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            int a = temperatureA[i] - temperatureA[i - 1];
            int b = temperatureB[i] - temperatureB[i - 1];

            if (a == 0 && b == 0 || a > 0 && b > 0 || a < 0 && b < 0) {
                max = Math.max(max, i - start);
            } else {
                start = i;
            }
        }
        return max;
    }
}
