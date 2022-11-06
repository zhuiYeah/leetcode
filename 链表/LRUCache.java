package 链表;

import java.util.HashMap;
import java.util.Map;

//在操作系统里面，可以用双向链表实现LRUCache。lab buffer cache将其改成了利用系统时间戳实现LRU。


//简易双向链表，用于实现LRU策略
class DULIST {
    int val;
    DULIST prev;
    DULIST next;

    DULIST(int v) {
        val = v;
    }
}

public class LRUCache {
    private final int SIZE;
    private Map<Integer, Integer> map1;
    private Map<Integer, DULIST> map2;
    //cacheHead.next永远是最近刚用过的缓存，cacheHead.prev永远是  Least Recently Used缓存
    private DULIST cacheHead;

    public LRUCache(int capacity) {
        SIZE = capacity;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        cacheHead = new DULIST(114514);
        cacheHead.next = cacheHead;
        cacheHead.prev = cacheHead;
    }

    public int get(int key) {
        if (!map1.containsKey(key)) return -1;
        //更新LRU链表结构
//        var thelatest = map2.get(key);
//        thelatest.prev.next = thelatest.next;
//        thelatest.next.prev = thelatest.prev;
//        thelatest.next = cacheHead.next;
//        thelatest.prev = cacheHead;
//        cacheHead.next.prev = thelatest;
//        cacheHead.next = thelatest;
        update(key);
        return map1.get(key);
    }

    public void put(int key, int value) {
        //缓存命中
        if (map1.containsKey(key)) {
//            var thelatest = map2.get(key);
//            thelatest.prev.next = thelatest.next;
//            thelatest.next.prev = thelatest.prev;
//            thelatest.next = cacheHead.next;
//            thelatest.prev = cacheHead;
//            cacheHead.next.prev = thelatest;
//            cacheHead.next = thelatest;
            update(key);
            map1.put(key, value);
            return;
        }
        //缓存未命中，且缓存区还有空余
        if (map1.size() < SIZE) {
//            var thelatest = new DULIST(key);
//            thelatest.next = cacheHead.next;
//            thelatest.prev = cacheHead;
//            cacheHead.next.prev = thelatest;
//            cacheHead.next = thelatest;
//            map1.put(key, value);
//            map2.put(key, thelatest);
            addnewmap(key, value);
            return;
        }
        //缓存未命中，缓存区已满，需要释放一个LRU Cache
        var theLRU = cacheHead.prev;
        map1.remove(theLRU.val);
        map2.remove(theLRU.val);
        cacheHead.prev = theLRU.prev;
        theLRU.prev.next = cacheHead;

//        var thelatest = new DULIST(key);
//        thelatest.next = cacheHead.next;
//        thelatest.prev = cacheHead;
//        cacheHead.next.prev = thelatest;
//        cacheHead.next = thelatest;
//        map1.put(key, value);
//        map2.put(key, thelatest);
        addnewmap(key, value);

    }
    //只有map中存在映射才能调用该函数，将key放入cacheHead.next
    private void update(int key){
        var thelatest = map2.get(key);
        thelatest.prev.next = thelatest.next;
        thelatest.next.prev = thelatest.prev;
        thelatest.next = cacheHead.next;
        thelatest.prev = cacheHead;
        cacheHead.next.prev = thelatest;
        cacheHead.next = thelatest;
    }
    //新建一个映射，并把该key放入cacheHead.next
    private void addnewmap(int key, int value){
        var thelatest = new DULIST(key);
        thelatest.next = cacheHead.next;
        thelatest.prev = cacheHead;
        cacheHead.next.prev = thelatest;
        cacheHead.next = thelatest;
        map1.put(key, value);
        map2.put(key, thelatest);
    }
}



