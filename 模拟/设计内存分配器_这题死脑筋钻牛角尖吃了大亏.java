package 模拟;



//class ListNode {
//    int startIdx;
//    int capacity;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int stIdx, int capacity) {
//        this.startIdx = stIdx;
//        this.capacity = capacity;
//    }
//
//    ListNode(int stIdx, int capacity, ListNode next) {
//        this.startIdx = stIdx;
//        this.capacity = capacity;
//        this.next = next;
//    }
//}

//想用空闲链表解 吃了大亏
//class Allocator {
//    int[] mem;
//    ListNode head;//空闲表
//    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>(); // mId ->  其全部范围
//
//    public Allocator(int n) {
//        mem = new int[n];
//        head = new ListNode(0, n);
//    }
//
//    public int allocate(int size, int mID) {
//        var tmp = head;
//
//        while (tmp != null) {
//            if (tmp.capacity >= size) break;
//            else tmp = tmp.next;
//        }
//        if (tmp == null) return -1;
//        int res = tmp.startIdx;
//        for (int i = tmp.startIdx; i < tmp.startIdx + size; i++) mem[i] = mID;
//        int left = tmp.startIdx, right = tmp.startIdx + size - 1;
//        if (tmp.capacity == size) {
//            head = tmp.next;
//        } else {
//            tmp.startIdx += size;
//            tmp.capacity -= size;
//        }
//
//
//        var scope = map.getOrDefault(mID, new ArrayList<>() {
//        });
//        for (int i = 0; i < scope.size(); i++) {
//            if (scope.get(i)[0] == right + 1) {
//                scope.get(i)[0] = left;
//                map.put(mID, scope);
//                return res;
//            } else if (scope.get(i)[1] == left - 1) {
//                scope.get(i)[1] = right;
//                map.put(mID, scope);
//                return res;
//            }
//        }
//        scope.add(new int[]{left, right});
//        map.put(mID, scope);
//
//        return res;
//
//    }
//
//    public int free(int mID) {
//        var scope = map.getOrDefault(mID, new ArrayList<>());
//        int res = 0;
//        for (int i = 0; i < scope.size(); i++) {
//            res += scope.get(i)[1] - scope.get(i)[0] + 1;
//            int left = scope.get(i)[0], right = scope.get(i)[1];
//            var tmp = head;
//            var ok = false;
//            while (tmp != null) {
//                if (tmp.startIdx == right + 1) {
//                    tmp.startIdx = left;
//                    tmp.capacity += right - left + 1;
//                    ok = true;
//                    break;
//                } else if (tmp.startIdx + tmp.capacity == left) {
//                    tmp.capacity += right - left + 1;
//                    ok = true;
//                    break;
//                }
//                tmp = tmp.next;
//            }
//            if (!ok) {
//                var node = new ListNode(left, right - left + 1);
//                if (right > head.startIdx) {
//                    node.next = head;
//                    head = node;
//                } else {
//                    tmp = head;
//                    while (tmp.next != null) {
//                        if (tmp.startIdx + tmp.capacity - 1 < left && tmp.next.startIdx > right) break;
//                        tmp = tmp.next;
//                    }
//                    node.next = tmp.next;
//                    tmp.next = node;
//                }
//            }
//        }
////        var tmp = head;
////        while (tmp.next != null) {
////            if (tmp.startIdx + tmp.capacity == tmp.next.startIdx) {
////                tmp.capacity += tmp.next.capacity;
////                tmp.next = tmp.next.next;
////            }
////            tmp = tmp.next;
////        }
//        map.remove(mID);
//        return res;
//    }
//}


//直接对数组操作即可
class Allocator {
    int[] mem;
    int N;

    public Allocator(int n) {
        mem = new int[n];
        N = n;
    }

    public int allocate(int size, int mID) {
        int i = 0;
        while (i < N) {
            if (mem[i] == 0) {
                //找到空闲了，从空闲开始查询，看看空闲区的长度能否满足要求
                int length = 0;
                int j = i;
                while (j < N && mem[j] == 0) { //注意防止越界
                    j++;
                    length++;
                }
                if (length >= size) {
                    for (int x = i; x < i + size; x++) {
                        mem[x] = mID;
                    }
                    return i;
                }
                i = j;
            } else {
                //没找到空闲，那么继续找咯
                i++;
            }

        }
        return -1;
    }

    public int free(int mID) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (mem[i] == mID) {
                mem[i] = 0;
                res++;
            }
        }
        return res;
    }
}