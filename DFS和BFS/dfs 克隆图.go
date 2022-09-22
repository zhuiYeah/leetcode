package DFS和BFS

type Node struct { //图中的一个节点
	Val       int
	Neighbors []*Node //两个
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	visited := map[*Node]*Node{} //key是旧图 ， value是新图
	var cloneG func(*Node) *Node
	cloneG = func(nodeg *Node) *Node {
		//如果旧图中的这个点被访问过，说明这个点在新图中已经存在了，只是还没有写进新图的新nodeg的Neighbors[]*NodeG里面
		if v, ok := visited[nodeg]; ok {
			return v
		}

		cloneNode := &Node{nodeg.Val, nil}
		visited[nodeg] = cloneNode
		//遍历旧图节点的邻居列表，写入新图节点的邻居列表中；如果visit中已存在，则一步返回，如果不存在，还要进行更深的递归
		for i := 0; i < len(nodeg.Neighbors); i++ {
			cloneNode.Neighbors = append(cloneNode.Neighbors, cloneG(nodeg.Neighbors[i])) //这里发生了递归，调用栈，是一个dps算法
		}
		return cloneNode
	}

	return cloneG(node)
}
