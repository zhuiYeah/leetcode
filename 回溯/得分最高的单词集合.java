package 回溯;

import java.util.Arrays;
import java.util.Scanner;

public class 得分最高的单词集合 {
    private int[] restLetters;//实时记录剩余的 a～z的数量
    private int[][] wordNum; //N行27列，前26列表示第i个单词的'a'+ col 的数量，第27列表示该单词的价值
    private int N;//单词总数
    private int res = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        restLetters = new int[26];
        for (char c : letters) restLetters[c - 'a']++;
        N = words.length;
        wordNum = new int[N][27];
        for (int i = 0; i < N; i++) {
            String word = words[i];
            int value = 0;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                wordNum[i][c - 'a']++;
                value += score[c - 'a'];
            }
            wordNum[i][26] = value;
        }
        backtracking(0, 0);
        return res;
    }

    private void backtracking(int idx, int score) {
        res = Math.max(res, score);
        if (idx == N) return;
        for (int i = idx; i < N; i++) {
            if (!canIGetTheWord(i)) continue;
            //现在的我有能力得到这个单词i
            //选择不得到
            backtracking(i + 1, score);
            //选择得到
            getTheWord(i);
            backtracking(i + 1, score + wordNum[i][26]);
            giveTheWord(i);
        }
    }

    private void giveTheWord(int wordIdx) {
        var word = wordNum[wordIdx];
        for (int i = 0; i < 26; i++) restLetters[i] += word[i];
    }

    private void getTheWord(int wordIdx) {
        var word = wordNum[wordIdx];
        for (int i = 0; i < 26; i++) restLetters[i] -= word[i];
    }

    private boolean canIGetTheWord(int wordIdx) {
        var word = wordNum[wordIdx];
        for (int i = 0; i < 26; i++) if (word[i] > restLetters[i]) return false;
        return true;
    }
}


class test {
    public static void main(String[] args) {
        var g = new int[]{1, 2, 3, 4, 5};
        change(g);
        System.out.println(Arrays.toString(g));

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        char b = (char) in.nextByte();
    }

    private static void change(int[] g) {
        g[1] = -999;
    }

}
