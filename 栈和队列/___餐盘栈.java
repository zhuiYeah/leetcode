package 栈和队列;

import java.util.*;

public class ___餐盘栈 {
}


class DinnerPlates {
    ArrayList<Deque<Integer>> infStack;
    int CAPACITY;
    //记录左边第一个未满栈
    PriorityQueue<Integer> pqLeft;
    //记录右边第一个非空栈
    PriorityQueue<Integer> pqRight;

    public DinnerPlates(int capacity) {
        infStack = new ArrayList<Deque<Integer>>();
        for (int i = 0; i < 2000; i++) infStack.add(new ArrayDeque<>());
        CAPACITY = capacity;
        pqLeft = new PriorityQueue<Integer>((a, b) -> a - b);
        pqRight = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < 2000; i++) pqLeft.add(i);
    }

    //推入左边第一个未满栈
    public void push(int val) {
        Integer idx = pqLeft.poll();
        if (idx == null) {
            infStack.add(new ArrayDeque<>());
            pqLeft.add(infStack.size() - 1);
            idx = pqLeft.poll();
        }
        if (infStack.get(idx).size() == 0) pqRight.add(idx);
        infStack.get(idx).push(val);
        if (infStack.get(idx).size() < CAPACITY) pqLeft.add(idx);
    }

    //推出右边第一个非空栈的栈顶元素
    public int pop() {
        Integer idx = pqRight.poll();
        if (idx == null) return -1;
        if (infStack.get(idx).size() == CAPACITY) pqLeft.add(idx);
        int val = infStack.get(idx).pop();
        if (infStack.get(idx).size() != 0) pqRight.add(idx);
        return val;
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= infStack.size()) return -1;
        if (infStack.get(index).size() == 0) return -1;
        if (infStack.get(index).size() == CAPACITY) pqLeft.add(index);
        int val = infStack.get(index).pop();
        if (infStack.get(index).size() == 0) pqRight.remove(index);
        return val;
    }
}