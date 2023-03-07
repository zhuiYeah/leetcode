package 模拟;

public class 字母板上的路径 {
    StringBuilder sb = new StringBuilder();

    public String alphabetBoardPath(String target) {
        f('a', target.charAt(0));
        for (int i = 1; i < target.length(); i++) f(target.charAt(i - 1), target.charAt(i));
        return sb.toString();
    }

    private void f(char from, char to) {
        if (from == 'z' && to == 'z') {
            sb.append("!");
            return;
        }
        if (from == 'z') {
            sb.append('U');
            from = 'u';
            help(from, to);
            sb.append('!');
            return;
        }
        if (to == 'z') {
            help(from, 'u');
            sb.append("D!");
            return;
        }
        help(from, to);
        sb.append('!');
    }

    private void help(char from, char to) {
        int sr = (from - 'a') / 5, sc = (from - 'a') % 5, dr = (to - 'a') / 5, dc = (to - 'a') % 5;
        if (sr >= dr) {
            sb.append("U".repeat(sr - dr));
        } else {
            sb.append("D".repeat(dr - sr));
        }
        if (sc >= dc) {
            sb.append("L".repeat(sc - dc));
        } else {
            sb.append("R".repeat(dc - sc));
        }
    }

}
