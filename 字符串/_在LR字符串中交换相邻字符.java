package 字符串;


//思路分析： 题目的意思是说 ‘R’只能向右移动，并且只能移向’X’，‘L’只能向左移动，并且只能移向’X’。
//
//第一：如果将start、end中的‘X’全部去掉得到的newStart 和 newEnd相等才有可能转换成功。
//第二：如果start中'R'的左边'X'的个数超过在end中对应位置的'R'的左边'X'的个数，则不能转换成功，因为start中的'R'只能向右移动，右边的'X'只能增加不能减少
//第三：如果end中'L'的左边'X'的个数超过在start中对应位置的'L'的左边'X'的个数，则不能转换成功，因为start中的'L'只能向左移动，左边的'X'只能减少不能增加
public class _在LR字符串中交换相邻字符 {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while(i<n && start.charAt(i) == 'X') i++;
            while(j<n && end.charAt(j) == 'X') j++;
            if (i>=n && j>=n) return true;
            if(i==n || j ==n) return false;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i)=='L' && i< j || start.charAt(i)=='R' && i>j) return false;
            i++;
            j++;
        }
        return true;
    }
}
