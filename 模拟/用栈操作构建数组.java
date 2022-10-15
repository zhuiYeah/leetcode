package 模拟;

import java.util.ArrayList;
import java.util.List;

public class 用栈操作构建数组 {
    public List<String> buildArray(int[] target, int n) {
        int ptr = 0;
        int len = target.length;
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i == target[ptr]) {
                ptr++;
                result.add("Push");
            } else {
                result.add("Push");
                result.add("Pop");
            }
            if (ptr == len) break;
        }
        return result;
    }
}
