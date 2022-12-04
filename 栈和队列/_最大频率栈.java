package 栈和队列;

import java.util.*;

public class _最大频率栈 {
}


class FreqStack {
    Map<Integer, Integer> fre = new HashMap<>();
    //stack.get(0) : 1频率栈 ， stack.get(1)：2频率栈
    ArrayList<Deque<Integer>> stack = new ArrayList<>();

    public void push(int val) {
        int idx = fre.getOrDefault(val, 0); //要push到idx频率栈
        if (idx == stack.size()) stack.add(new ArrayDeque<>());
        stack.get(idx).push(val);
        fre.put(val, idx + 1);
    }

    public int pop() {
        var idx = stack.size() - 1; //要pop最后一个栈，即最大频率栈
        int res = stack.get(idx).pop();
        if (stack.get(idx).size() == 0) stack.remove(idx);
        fre.put(res, fre.get(res) - 1);
        return res;
    }
}