package DFS和BFS

///但在实际的题目中，我们会有不止一个 00。我们会想，要是我们可以把这些 00 看成一个整体好了。有了这样的想法，我们可以添加一个「超级零」，
//它与矩阵中所有的 00 相连，这样的话，任意一个 11 到它最近的 00 的距离，会等于这个 11 到「超级零」的距离减去一。
//由于我们只有一个「超级零」，我们就以它为起点进行广度优先搜索。这个「超级零」只和矩阵中的 00 相连，
//所以在广度优先搜索的第一步中，「超级零」会被弹出队列，而所有的 00 会被加入队列，它们到「超级零」的距离为 11。
//这就等价于：一开始我们就将所有的 00 加入队列，它们的初始距离为 00。这样以来，在广度优先搜索的过程中，我们每遇到一个 11，
//就得到了它到「超级零」的距离减去一，也就是 这个 11 到最近的 00 的距离。
//
//超级0
//超级源点

func updateMatrix0(mat [][]int) [][]int {
	m := len(mat)
	n := len(mat[0])
	res := make([][]int, m)
	for i := 0; i < len(res); i++ {
		res[i] = make([]int, n)
	}

	visit := InitVisit(m, n)

	var queue []*xyx
	for i := 0; i < m; i++ { //初始化队列中的点，即超级0点
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				queue = append(queue, &xyx{i, j, 0})
				visit[i][j] = true
			}
		}
	}
	for len(queue) != 0 {
		x := queue[0]
		queue = queue[1:]
		row := x.row
		col := x.col
		res[row][col] = x.distance
		if row-1 >= 0 && !visit[row-1][col] {
			queue = append(queue, &xyx{row - 1, col, x.distance + 1})
			visit[row-1][col] = true
		}
		if row+1 < m && !visit[row+1][col] {
			queue = append(queue, &xyx{row + 1, col, x.distance + 1})
			visit[row+1][col] = true
		}
		if col-1 >= 0 && !visit[row][col-1] {
			queue = append(queue, &xyx{row, col - 1, x.distance + 1})
			visit[row][col-1] = true
		}
		if col+1 < n && !visit[row][col+1] {
			queue = append(queue, &xyx{row, col + 1, x.distance + 1})
			visit[row][col+1] = true
		}
	}
	return res
}

func InitVisit(m, n int) [][]bool {
	visit := make([][]bool, m)
	for i := 0; i < len(visit); i++ {
		visit[i] = make([]bool, n)
	}
	return visit
}
