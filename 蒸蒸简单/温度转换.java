package 蒸蒸简单;

//来自319场周赛
public class 温度转换 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
