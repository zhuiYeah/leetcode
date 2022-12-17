package test;


/**产生死锁的四个必要条件得烂熟于心：

 互斥条件：进程要求对所分配的资源进行排他性控制，即在一段时间内某资源仅为一个进程所占用。此时若有其他进程请求该资源，则请求进程只能等待。
 不剥夺条件：进程所获得的资源在未使用完毕之前，不能被其他进程强行夺走，即只能由获得该资源的进程自己来释放。
 请求和保持条件：进程已经保持了至少一个资源，但又提出了新的资源请求，而该资源已被其他进程占有，此时请求进程被阻塞，但对自己已获得的资源保持不放。
 循环等待条件：存在一种进程资源的循环等待链，连中每一个进程已获得的资源同时被链中下一个进程所请求。
 相应的，如果想在程序运行之前预防发生死锁（也成为 “死锁预防”），必须设法破坏产生死锁的四个必要条件之一

 破坏互斥条件：允许系统资源都能共享使用，则系统不会进行死锁状态。这种方案并不太可行，因为有些资源根本就不能同时访问，比如打印机。
 破坏不剥夺条件：当一个已经保持了某些不可剥夺资源的进程，<u>请求新的资源时得不到满足，它必须释放已经保持的所有资源</u>，待以后需要时再重新申请。这种方法常用于状态易于保存和恢复的资源，如 CPU 的寄存器及内存资源，一般不能用于打印机之类的资源。
 破坏请求和保持条件：采用预先静态分配方法，即<u>进程在运行前一次申请完他所需要的全部资源，在他的资源未满足前，不把它投入运行。一旦运行后，这些资源就一直归它所有，也不再提出其他资源请求</u>，这样就可以保证系统不会发生死锁。
 破坏循环等待条件：采用顺序资源分配法。首先给系统中的资源编号，规定每个进程，必须按编号递增的顺序请求资源，同类资源一次申请完。也就是说，<u>只要进程提出申请分配资源，则该进程在以后的资源申请中，只能申请编号比之前大的资源</u>。
 光看罗列出来的几点文字肯定还是不能完全理解，下面会结合实例来给大伙解释。

 用 Java 写一个死锁
 这绝对是面试中 Java 手写题的 TOP2！！！除了人尽皆知的手写单例模式，手写死锁可能有些小伙伴会遗漏掉。

 逻辑其实非常简单，我们申请两个资源，开两个线程，每个线程持有其中的一个资源，并且互相请求对方的资源，就构成了死锁。**/


public class DeadLock {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            synchronized (obj1) {
                System.out.println("线程t1占据了obj1");
                try {
                    Thread.sleep(100);
                    synchronized (obj2) {
                        System.out.println("线程t1占据了obj1 和obj2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            };
        },"t1");
        var t2 = new Thread(() -> {
            synchronized (obj2){
                System.out.println("线程t2占据了obj2");
            }
            try {
                Thread.sleep(100);
                synchronized (obj1) {
                    System.out.println("线程t2占据了obj1 和obj2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();

    }
}
