package 数学;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Runsen * @date 2020/12/9 13:18
 */
 class Decomposing_prime {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("请您输入一个数：");
        int n = Sc.nextInt();
        var list = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n != i) {
                n /= i;
                list.add(i);
                //System.out.print(i + "*");
            }
            if (n == i) {
                list.add(i);
                //System.out.print(i);
                break;
            }
        }
        System.out.println(list);
    }
}