public class Test {
    public static void main(String[] args) {
        String s = "author : zhui";
        String x = "to : 雪雪宝贝";
        var sChar = x.toCharArray();
        for (char c : sChar) {
            System.out.print((int) c + " ");
        }
    }
}
