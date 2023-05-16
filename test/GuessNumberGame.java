package test;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // 生成1-100之间的随机数
        int numberOfTries = 0; // 猜测次数

        System.out.println("欢迎来到猜数字游戏！");
        System.out.println("我想了一个1-100之间的整数，请你猜一下它是多少。");
        System.out.println("你有6次机会。");

        while (numberOfTries < 6) { // 最多猜测6次
            System.out.print("请猜一个数：");
            int guess = scanner.nextInt();
            numberOfTries++;

            if (guess == numberToGuess) {
                System.out.println("恭喜你，猜对了！");
                return;
            } else if (guess < numberToGuess) {
                System.out.println("很抱歉，你猜的数太小了。");
            } else {
                System.out.println("很抱歉，你猜的数太大了。");
            }
        }

        System.out.println("很遗憾，你没有在规定次数内猜出正确答案。");
        System.out.println("正确答案是：" + numberToGuess);
    }

}
