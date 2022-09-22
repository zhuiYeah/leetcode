package 二叉树;

public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = help(nums, start, maxIndex - 1);
        root.right = help(nums, maxIndex + 1, end);
        return root;
    }
}
