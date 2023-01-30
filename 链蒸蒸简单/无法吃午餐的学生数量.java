package 链蒸蒸简单;

import java.util.ArrayDeque;

public class 无法吃午餐的学生数量 {
    public int countStudents(int[] students, int[] sandwiches) {
        var queue = new ArrayDeque<Integer>();
        for (int student : students) queue.add(student);
        int n = sandwiches.length;
        int ptr = 0;
        while (ptr < n) {
            int count = 0;
            while (!queue.isEmpty() && queue.peek() != sandwiches[ptr] && count < queue.size()) {
                queue.add(queue.poll());
                count++;
            }
            if (queue.isEmpty()) return 0;
            if (count >= queue.size()) break;
            queue.poll();
            ptr++;
        }
        return n - ptr;
    }
}
