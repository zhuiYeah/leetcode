package 动态规划

//你是个小偷，房屋呈现二叉树的分布局势，不能偷盗相邻的房屋，你能偷盗的最大数量财产是多少

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//树形DP就是在树上进行递归公式的推导，只不过平时我们习惯了在一维数组或者二维数组上推导公式，一下子换成了树，就需要对树的遍历方式足够了解！
func rob3(root *TreeNode) int {
	//从下到上遍历节点，所以用的是后序遍历
	//每个节点有两种选择，取这个节点和不取这个节点，dp[0]是不偷这个节点的的最大收益，dp[1]是偷这个节点的最大收益
	//不偷这个节点，那么就可以偷他的两个孩子，至于偷还是不偷他的孩子节点，当然取他的孩子节点里面dp[0],dp[1]较大的一个，即对于当前节点dp[0]=max(left[0],left[1])+max(right[0],right[1])
	//偷这个节点，那么就不能偷他的孩子节点，即dp[1]=left[0]+right[0]+当前节点的价值

	var robbery func(node *TreeNode) [2]int //robbery函数返回打劫和不打劫这个房间的最大收益
	robbery = func(node *TreeNode) [2]int {
		if node == nil {
			return [2]int{0, 0} // 不存在的房间打不打劫都是0
		}
		if node.Left == nil && node.Right == nil { //叶子节点的房间，打劫就是这个房间的价值，不打劫就是0
			return [2]int{0, node.Val}
		}
		var dp [2]int
		left := robbery(node.Left)   //打劫左子节点和不打劫左子节点的最大收益
		right := robbery(node.Right) //打劫右子节点和不打劫右子节点的最大收益

		//如果不打劫当前节点node
		dp[0] = max(left[0], left[1]) + max(right[0], right[1])
		//如果打劫当前节点node
		dp[1] = left[0] + right[0] + node.Val

		return dp
	}
	dp := robbery(root)
	return max(dp[0], dp[1])
}
