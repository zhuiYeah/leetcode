package 蒸蒸简单;

//注意比较字符串要用 .equals() method
public class 文件夹操作日志搜集器 {
    public static int minOperations(String[] logs) {
        int depth = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                depth--;
                if (depth < 0) {
                    depth = 0;
                }
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        minOperations(logs);
    }
}
