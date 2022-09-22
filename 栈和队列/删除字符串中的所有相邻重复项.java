package 栈和队列;

import java.util.ArrayList;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        //本来想用 ArrayList 来储存char ，但Arraylist转换为String太麻烦
        StringBuffer stack = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == s.charAt(i)) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(s.charAt(i));
            }
        }
        return stack.toString();
    }
}
