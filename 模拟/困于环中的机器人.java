package 模拟;


/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * <p>
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 */

// 如果任何一个纬度超出了100，则可以出去
// 如果回到了0 0 点 则 成环

public class 困于环中的机器人 {
    int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int c = 0;
        while (true) {
            for (int i = 0; i < instructions.length(); i++) {
                char operation = instructions.charAt(i);
                if (operation == 'L') {
                    c = (c + 1) % 4;
                } else if (operation == 'R') {
                    c = (c + 3) % 4;
                } else {
                    x += direction[c][0];
                    y += direction[c][1];
                }
            }
            if (x == 0 && y == 0 && c == 0) return true;
            if (Math.abs(x) > 400 || Math.abs(y) > 400) return false;
        }
    }

    private int nextDir(String instruction, int cur, int i) {
        int n = instruction.length();
        for (int k = 0; k < n; k++) {
            int idx = (k + i) % n;
            char v = instruction.charAt(idx);
            if (v == 'L') {
                cur = (cur + 1) % 4;
                break;
            } else if (v == 'R') {
                cur = (cur + 3) % 4;
                break;
            }
        }
        return cur;
    }

}
