package 二叉树;

public class 最小高度树 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return help(0, nums.length - 1);
    }

    public TreeNode help(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(start, mid - 1);
        root.right = help(mid + 1, end);
        return root;
    }
}
