package 蒸蒸简单;

public class 计算应缴税款总额 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        for (int i = 0; i < brackets.length; i++) {

            if (i == 0) {
                res += Math.min(income, brackets[i][0]) * brackets[i][1] * 0.01;
            } else {
                res += Math.min(income - brackets[i - 1][0], brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] * 0.01;
            }
            if (i==0 && income<=brackets[0][0]) break;
            if (i != 0 && income >= brackets[i - 1][0] && income <= brackets[i][0]) break;
        }
        return res;
    }
}
