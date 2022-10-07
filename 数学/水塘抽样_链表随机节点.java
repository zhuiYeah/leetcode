package 数学;


import java.util.Random;

public class 水塘抽样_链表随机节点 {
}

class Solution11 {
    ListNode head;
    Random random;
    public Solution11(ListNode head) {
        this.head=head;
        this.random=new Random();
    }

    public int getRandom() {
        // 蓄水池算法
        // 第一次拿第一个数 第一个数的概率是100%
        // 第二次 拿第二个数 取第二个数的概率是50%
        // 第三次 拿第三个数是 33% 则保留原本数的概率是66%
        ListNode p=this.head;
        int count=0;
        int res=0;
        while(p!=null){
            //现在是链表中的第count个数
            count++;
            //在[1,count]之间给出一个随机数（伪）
            int randomint=random.nextInt(count)+1;//因为生成的是[0，count)的值 而不包含count  所以要加1
            if(randomint==count){
                res=p.val;
            }
            p=p.next;
        }
        return res;
    }
}