package DFS和BFS

func cloneGraph0(node *Node) *Node {
	queue := []*Node{node} //该队列用于存放Node类指针
	visited := map[*Node]*Node{}

	for len(queue) != 0 {
		currentClonedNode := queue[0]
		queue = queue[1:]
		cloneNode := &Node{currentClonedNode.Val, nil} //先把所有的点克隆出来，因为在克隆的时候，有的邻居节点还未存在，所以先nil
		visited[currentClonedNode] = cloneNode
		for i := 0; i < len(currentClonedNode.Neighbors); i++ {
			//遍历当前被克隆节点的邻居节点，如果邻居节点还visit过，写进队列中
			if _, ok := visited[currentClonedNode.Neighbors[i]]; !ok {
				queue = append(queue, currentClonedNode.Neighbors[i])
			}
		}
	} //这个for循环结束后，原图已被完全克隆，但是新图的Neighbors为空

	queue = append(queue, node)
	visited2 := map[*Node]bool{}
	//这个for循环广度遍历原图，补全新图的邻居节点
	for len(queue) != 0 {
		currentClonedNode := queue[0]
		queue = queue[1:]

		if visited2[currentClonedNode] == false { //如果当前节点未被遍历到过，就填充新图里面对应节点的邻居节点
			for i := 0; i < len(currentClonedNode.Neighbors); i++ {
				visited[currentClonedNode].Neighbors = append(visited[currentClonedNode].Neighbors, visited[currentClonedNode.Neighbors[i]])
			}
		}
		visited2[currentClonedNode] = true //当前节点已被遍历过
		for i := 0; i < len(currentClonedNode.Neighbors); i++ {
			if !visited2[currentClonedNode.Neighbors[i]] {
				queue = append(queue, currentClonedNode.Neighbors[i])
			}
		}
	}
	return visited[node]
}
