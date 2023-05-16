package 面试;

import java.util.Scanner;

public class Main {
    // 1 ~ n
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); //n个员工
//        int m = sc.nextInt(); //m次升职
//        int[] level = new int[n];
//        for (int i = 0; i < m; i++) {
//            int l = sc.nextInt() - 1;
//            int r = sc.nextInt() - 1;
//            for (int j = l; j <= r; j++) level[j]++;
//        }
//        for (int i = 0; i < n; i++) System.out.print(level[i] + " ");
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个员工
        int m = sc.nextInt(); //m次升职
        int[] diff = new int[n];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            diff[l]++;
            if (r + 1 < n) diff[r + 1]--;
        }
        int[] level = new int[n];
        level[0] = diff[0];
        System.out.print(level[0] + " ");
        for (int i = 1; i < n; i++) {
            level[i] = level[i - 1] + diff[i];
            System.out.print(level[i] + " ");
        }
    }
}

