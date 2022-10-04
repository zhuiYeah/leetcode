package 二叉树;

public class 将有序数组转化为二叉搜索树 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return f(0, nums.length - 1);
    }

    public TreeNode f(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        var node = new TreeNode(nums[mid]);
        var l = f(left, mid - 1);
        var r = f(mid + 1, right);
        node.left = l;
        node.right = r;
        return node;
    }
}
