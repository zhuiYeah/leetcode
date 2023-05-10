package 面试;


//华为第一题
import java.util.ArrayList;
import java.util.Scanner;

public class 栈数据合并 {
    static int[] stack = new int[1000];
    static int top = -1;

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner sc = new Scanner(System.in);


        ArrayList<Integer> list = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
//        int[] preSum = new int[1005];//preSum[i]表示前i个数的和
//        for (int i = 0; i < list.size(); i++) {
//            preSum[i+1]
//        }
        for (int i = 0; i < list.size(); i++) {
            int n1 = list.get(i);
            processN1(n1);
//            if (top == -1) {
//                stack[++top] = n1;
//                continue;
//            }
//            //判断栈顶的数字连续和是否等于n1
//            int sum = 0;
//            boolean flag = false;
//            int j = top;
//            for (j = top; j >= 0; j--) {
//                sum += stack[j];
//                if (sum == n1) {
//                    flag = true;
//                    break;
//                }
//                if (sum > n1) break;
//            }
//            if (flag) {
//                stack[j] = 2 * n1;
//                top = j;
//            } else {
//                stack[++top] = n1;
//            }
        }
        if (top < 0) {
            return;
        }
        for (int i = top; i > 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println(stack[0]);
    }

    //将n1 进行压栈处理
    private static void processN1(int n1) {
        if (top == -1) {
            stack[++top] = n1;
            return;
        }
        long sum = 0;
        boolean flag = false;
        int j = top;
        for (j = top; j >= 0; j--) {
            sum += stack[j];
            if (sum == n1) {
                flag = true;
                break;
            }
            if (sum > n1) break;
        }
        if (!flag) {
            stack[++top] = n1;
        } else {
            top = j - 1;
            processN1(2 * n1);
        }
    }
}
