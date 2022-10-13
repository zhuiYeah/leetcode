package 贪心;


import java.util.ArrayDeque;

//错误解法
//45 / 52
public class _最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        int ptr = 0;
        int res = 0;
        while (ptr < arr.length) {
            int next = ptr;
            for (int i = ptr + 1; i < arr.length; i++) {
                if (arr[i] < arr[ptr]) next = i;
            }
            res++;
            ptr = next + 1;
        }
        return res;
    }
}


//贪心 + 栈
//用一个区块中的最大元素来表示这一个块 ， 在从前向后遍历的过程中，出现比我小的，那你归我这个块 ， 比我大 那你自己成块
//错误
class dwde {
    public int maxChunksToSorted(int[] arr) {
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] > stack.peek()) {
                stack.push(arr[i]);
            }
        }
        return stack.size();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
//用一个区块中的最大元素来表示这一个块 ,遇到小的要不断将大的块出栈，最后将能代表这个块的最大数字入栈
class dwdwdew{
    public int maxChunksToSorted(int[] arr) {
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int maxOfThisBlock = 0;
            if (!stack.isEmpty() && arr[i]<stack.peek()){
                maxOfThisBlock = stack.peek();
                while(!stack.isEmpty() && arr[i]<stack.peek()) {
                    stack.pop();
                }
            }
            stack.push(Math.max(arr[i], maxOfThisBlock));

        }
        return stack.size();
    }
}
