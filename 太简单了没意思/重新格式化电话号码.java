package 太简单了没意思;

public class 重新格式化电话号码 {
    public String reformatNumber(String number) {
        var sb = new StringBuilder(number);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' || sb.charAt(i) == '-') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        int rest = sb.length() % 3;
        if (rest == 1) rest = 4;
        var res = new StringBuilder(rest);
        int i = 0;
        for (i = 0; i < sb.length() - rest; i += 3) {
            res.append(sb.substring(i, i + 3));
            res.append('-');
        }
        if (rest == 0) {
            res.deleteCharAt(res.length() - 1);
        } else if (rest == 4) {
            res.append(sb.substring(i, i + 2));
            res.append('-');
            res.append(sb.substring(i + 2));
        } else if (rest == 2) {
            res.append(sb.substring(i, i + 2));
        }
        return res.toString();
    }
}
