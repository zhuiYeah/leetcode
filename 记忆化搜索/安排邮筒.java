package 记忆化搜索;

import java.util.Arrays;

//记忆化搜索 + 中位数贪心
public class 安排邮筒 {
    int[][] f;//f[i][k]:用k个邮筒管理下标为i之后的所有房子，最小的代价为f[i][k]
    int n;  //共有n个房子
    int inf = (int) 1e7;
    int[] houses;

    public int minDistance(int[] houses, int k) {
        this.houses = houses;
        n = houses.length;
        Arrays.sort(houses);
        f = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], inf);
        return f(0, k);
    }

    private int f(int i, int k) {
        //如果邮筒的数量大于房子的数量，那么代价一定为0
        if (k >= n - i) return 0;
        if (f[i][k] != inf) return f[i][k];
        //只有一个邮筒，他处理剩余的从i到n-1的所有房子
        if (k == 1) {
            f[i][k] = countcost(i, n - 1);
            return f[i][k];
        }
        //现在有k个邮筒，处理从i开始的所有房子，考虑当前邮筒处理1,2,3,4,5,6...个房子的所有情况
        int res = f(i + 1, k - 1); //res初始化为当前邮筒只处理一个房子的总代价，即房子i
        int curCost = 0; //记录当前邮筒需要的总代价，如果只处理房子i，他的代价为0
        //当前邮箱处理的房子总数为w，w必须小于等于剩余房屋总数
        for (int w = 2; w <= n - i; w++) {
            curCost = countcost(i, i + w - 1);
            res = Math.min(res, curCost + f(i + w, k - 1));
        }
        f[i][k] = res;
        return res;
    }

    //一个邮箱处理[leftindex,rightindex]房子的总代价
    private int countcost(int leftindex, int rightindex) {
        int mid = -1;//邮箱的位置，需要处在中位数！
        int totalhouse = rightindex - leftindex + 1;
        if (totalhouse % 2 == 1) {
            mid = houses[leftindex + (totalhouse) / 2];
        } else {
            mid = (houses[leftindex + (totalhouse) / 2 - 1] + houses[rightindex - (totalhouse) / 2 + 1]) / 2;
        }
        int res = 0;
        for (int i = leftindex; i <= rightindex; i++) res += Math.abs(houses[i] - mid);
        return res;
    }
}


///debug
class edeef {
    static int[][] f;//f[i][k]:用k个邮筒管理下标为i之后的所有房子，最小的代价为f[i][k]
    static int n;  //共有n个房子
    static int inf = (int) 1e7;
    static int[] housesxx;

    public static int minDistance(int[] houses, int k) {
        housesxx = houses;
        n = houses.length;
        Arrays.sort(houses);
        f = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], inf);
        int res = f(0, k);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(f[i]));
        }
        return f(0, k);
    }

    private static int f(int i, int k) {
        //如果邮筒的数量大于房子的数量，那么代价一定为0
        if (k >= n - i) return 0;
        if (f[i][k] != inf) return f[i][k];
        //只有一个邮筒，他处理剩余的从i到n-1的所有房子
        if (k == 1) {
            f[i][k] = countcost(i, n - 1);
            return f[i][k];
        }
        //现在有k个邮筒，处理从i开始的所有房子，考虑当前邮筒处理1,2,3,4,5,6...个房子的所有情况
        int res = f(i + 1, k - 1); //res初始化为当前邮筒只处理一个房子的总代价，即房子i
        int curCost = 0; //记录当前邮筒需要的总代价，如果只处理房子i，他的代价为0
        int restcost;
        for (int w = 1; w <= n - i; w++) {
            curCost = countcost(i, i + w - 1);
            restcost = f(i + w, k - 1);
            res = Math.min(res, curCost + restcost);
        }
        f[i][k] = res;
        return res;
    }

    //一个邮箱处理[leftindex,rightindex]房子的总代价
    private static int countcost(int leftindex, int rightindex) {
        int mid = -1;//邮箱的位置，需要处在中位数！
        int totalhouse = rightindex - leftindex + 1;
        if (totalhouse % 2 == 1) {
            mid = housesxx[leftindex + (totalhouse) / 2];
        } else {
            mid = (housesxx[leftindex + (totalhouse) / 2 - 1] + housesxx[rightindex - (totalhouse) / 2 + 1]) / 2;
        }
        int res = 0;
        for (int i = leftindex; i <= rightindex; i++) res += Math.abs(housesxx[i] - mid);
        return res;
    }

    public static void main(String[] args) {
        int[] houses = new int[]{1, 4, 8, 10, 20};
        minDistance(houses, 3);
    }
}
