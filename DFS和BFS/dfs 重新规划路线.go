package DFS和BFS

//写的不好，只超过40%的用户
//n个节点之间有n-1个单向通道，变换两节点之间的通道朝向，使得所有的点都朝向节点0，求需要变更的最小次数
func minReorder(n int, connections [][]int) int {
	m1 := map[int][]int{} // value :key节点可以直接到达的节点集合为m1[key] ,需要翻转路线
	m2 := map[int][]int{} // 可以到达key节点的节点集合为m2[key] ，不需要翻转路线
	for i := 0; i < len(connections); i++ {
		m1[connections[i][0]] = append(m1[connections[i][0]], connections[i][1])
		m2[connections[i][1]] = append(m2[connections[i][1]], connections[i][0])
	}
	res := 0
	visited := make([]bool, n)
	var dfs func(curCity int)
	dfs = func(curCity int) {
		for i := 0; i < len(m1[curCity]); i++ { //从当前城市出发能到达的城市，需要翻转路线
			if !visited[m1[curCity][i]] {
				visited[m1[curCity][i]] = true
				res++
				dfs(m1[curCity][i])
			}
		}
		for i := 0; i < len(m2[curCity]); i++ { //能到达当前城市的相邻城市，不需要翻转路线
			if !visited[m2[curCity][i]] {
				visited[m2[curCity][i]] = true
				dfs(m2[curCity][i])
			}
		}
	}
	visited[0] = true
	dfs(0)
	return res
}
