package DFS和BFS

//mat所有点到0的距离生成一个新的矩阵
func updateMatrix(mat [][]int) [][]int {
	m := len(mat)
	n := len(mat[0])
	distance := make([][]int, m)
	for i := 0; i < m; i++ {
		distance[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			distance[i][j] = -1
		}
	}
	var queue []*xyx
	for i := 0; i < len(mat); i++ {
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				queue = append(queue, &xyx{i, j, 0})
				distance[i][j] = 0
			}
		}
	} //目前已经得到了的超级0点

	for len(queue) != 0 {
		cur := queue[0]
		queue = queue[1:]
		i := cur.row
		j := cur.col
		dis := cur.distance + 1
		if i-1 >= 0 && distance[i-1][j] == -1 {
			queue = append(queue, &xyx{i - 1, j, dis})
			distance[i-1][j] = dis
		}
		if i+1 < m && distance[i+1][j] == -1 {
			queue = append(queue, &xyx{i + 1, j, dis})
			distance[i+1][j] = dis
		}
		if j-1 >= 0 && distance[i][j-1] == -1 {
			queue = append(queue, &xyx{i, j - 1, dis})
			distance[i][j-1] = dis
		}
		if j+1 < n && distance[i][j+1] == -1 {
			queue = append(queue, &xyx{i, j + 1, dis})
			distance[i][j+1] = dis
		}
	}

	return distance

}
