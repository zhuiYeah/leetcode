package 递归

func deleteNode(root *TreeNode, key int) *TreeNode {
	if root == nil {
		return nil
	} //没找到删除的节点，遍历到空节点直接返回了

	if key == root.Val { //找到要删除的点了
		if root.Left == nil && root.Right == nil { //要删除的是叶子节点
			return nil
		} else if root.Left == nil && root.Right != nil { //要删除的节点左侧为空
			return root.Right
		} else if root.Left != nil && root.Right == nil { //要删除的节点右侧为空
			return root.Left
		} else if root.Left != nil && root.Right != nil { //要删除的节点左右都不为空
			x := root.Right
			for x.Left != nil { //找到要删除的节点的右子树的最左支
				x = x.Left
			}
			x.Left = root.Left
			return root.Right
		}
	}

	if key < root.Val { //要删除的节点在左边
		root.Left = deleteNode(root.Left, key)
	}

	if key > root.Val { //要删除的节点在右边
		root.Right = deleteNode(root.Right, key)
	}

	return root
}
