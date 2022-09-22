package 模拟;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//其实节点的颜色只跟最后一次的染色有关

////////////////////////////////////////////////////////////////////////////////////////////
//以下代码并发异常  java.util.ConcurrentModificationException
public class 二叉搜索树染色 {
    Set<Integer> set = new HashSet<Integer>();

    public int getNumber(TreeNode root, int[][] ops) {
        inorder(root);
        int n = ops.length;
        int oneCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (ops[i][0] == 0) {
                int start = ops[i][1];
                int end = ops[i][2];
                for (int num : set) {
                    //在for循环遍历set删除元素会导致并发异常
                    if (num >= start && num <= end) {
                        set.remove(num);
                    }
                }
            } else {
                int start = ops[i][1];
                int end = ops[i][2];
                for (int num : set) {
                    if (num >= start && num <= end) {
                        oneCount++;
                        set.remove(num);
                    }
                }
            }
        }
        return oneCount;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}


///////////////////////////////////////////////////////////////////////////////////////
//手动构造迭代器来遍历set，但是超时了 83/89
class dwdewdewed {
    Set<Integer> set = new HashSet<Integer>();

    public int getNumber(TreeNode root, int[][] ops) {
        inorder(root);
        int n = ops.length;
        int oneCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int start = ops[i][1];
            int end = ops[i][2];
            Iterator<Integer> iterator = set.iterator();
            if (ops[i][0] == 0) {
                while (iterator.hasNext()) {
                    Integer element = iterator.next();
                    if (element >= start && element <= end) {
                        iterator.remove();
                    }
                }
            } else {
                while (iterator.hasNext()) {
                    Integer element = iterator.next();
                    if (element >= start && element <= end) {
                        oneCount++;
                        iterator.remove();
                    }
                }
            }
        }
        return oneCount;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//从HashSet升级到TreeSet，使用有序集合 的 set.higher() 方法
// set.ceiling()
//set.floor()
//set.lower()

class dedefdece {
    TreeSet<Integer> set = new TreeSet<>();

    public int getNumber(TreeNode root, int[][] ops) {
        inorder(root);
        int n = ops.length;
        int oneCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int start = ops[i][1];
            int end = ops[i][2];
            while (true) {
                Integer upper = set.ceiling(start);
                if (upper == null || upper > end) break;
                set.remove(upper);
                if (ops[i][0] == 1) oneCount++;
            }
        }
        return oneCount;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}