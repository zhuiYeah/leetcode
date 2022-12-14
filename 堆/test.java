package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

/**动态维护优先队列**/
//优先队列中已经存在的元素被修改，那么怎么更新优先队列 ？
//答 ： 使用remove 之后 再 add
public class test {
    public static void main(String[] args) {
        var pq = new PriorityQueue<int[]>((a,b)->{
            return a[0]-b[0];
        });
        var a1 = new int[]{1,2};
        var a2 = new int[]{3,4};
        var a3 = new int[]{5,6};
        pq.add(a1);
        pq.add(a2);
        pq.add(a3);
        System.out.println(Arrays.toString(pq.peek()));
        a1[0] = 10;
        pq.remove(a1);
        System.out.println(Arrays.toString(pq.peek()));

    }
}
