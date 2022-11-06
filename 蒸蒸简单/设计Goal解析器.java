package 蒸蒸简单;

public class 设计Goal解析器 {
    public String interpret(String command) {
        var sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (i == 0) {
                if (c != '(') sb.append(c);
                continue;
            }
            if (c == ')' && command.charAt(i - 1) == '(') sb.append('o');
            if (c != '(' && c != ')') sb.append(c);
        }
        return sb.toString();
    }
}
