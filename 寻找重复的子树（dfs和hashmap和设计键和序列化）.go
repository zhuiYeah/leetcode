package main

import "strconv"

//中序遍历存在对称性问题，不可以使用中序遍历
//dfs+hashmap   两个节点，如果前序序列化之后完全相同，认为它们是相同的子树
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
	mapFrequency := map[string]int{}  //储存 序列 出现的 次数
	mapNode := map[string]*TreeNode{} //根据序列找到重复子树后，需要根据序列找到对应的节点
	var dfs func(node *TreeNode) string
	dfs = func(node *TreeNode) string {
		if node == nil {
			return "#"
		}
		var sequence string //序列
		sequence += "-" + strconv.Itoa(node.Val)
		sequence += dfs(node.Left)
		sequence += dfs(node.Right)
		//此时此刻node的序列化已经完成
		mapFrequency[sequence]++
		mapNode[sequence] = node
		return sequence
	}
	dfs(root)
	res := []*TreeNode{}
	for i, v := range mapFrequency { //i是序列，v是序列出现的次数
		if v > 1 {
			res = append(res, mapNode[i])
		}
	}
	return res
}
