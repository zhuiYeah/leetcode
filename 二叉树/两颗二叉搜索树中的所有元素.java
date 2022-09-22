package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class 两颗二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < list1.size() && ptr2 < list2.size()) {
            if (list1.get(ptr1) < list2.get(ptr2)) {
                result.add(list1.get(ptr1));
                ptr1++;
            } else {
                result.add(list2.get(ptr2));
                ptr2++;
            }
        }
        while (ptr1 < list1.size()) {
            result.add(list1.get(ptr1));
            ptr1++;
        }
        while (ptr2 < list2.size()) {
            result.add(list2.get(ptr2));
            ptr2++;
        }
        return result;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//库函数排序比自己写的一大堆要快，妈的破防了
class forge {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        inorder(root1, result);
        inorder(root2, result);
        Collections.sort(result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
