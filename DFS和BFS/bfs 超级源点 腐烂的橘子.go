package DFS和BFS

type status struct { //记录橘子的层数和橘子腐烂的时间
	row  int
	col  int
	time int
}

//grid中，2表示腐烂的橘子，1表示好橘子，0表示空格子，问腐烂所有橘子一共需要多久
//秒杀了
func orangesRotting(grid [][]int) int {
	var queue []*status
	m := len(grid)
	n := len(grid[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 2 {
				queue = append(queue, &status{i, j, 0})
			}
		}
	} //这个for循环结束后，构造了一个烂橘子的超级源点，接下来开始烂橘子感染
	res := 0
	for len(queue) != 0 {
		curJuice := queue[0]
		queue = queue[1:]
		i := curJuice.row
		j := curJuice.col
		time := curJuice.time
		res = time
		if i-1 >= 0 && grid[i-1][j] == 1 {
			queue = append(queue, &status{i - 1, j, time + 1})
			grid[i-1][j] = 2
		}
		if i+1 < m && grid[i+1][j] == 1 {
			queue = append(queue, &status{i + 1, j, time + 1})
			grid[i+1][j] = 2
		}
		if j-1 >= 0 && grid[i][j-1] == 1 {
			queue = append(queue, &status{i, j - 1, time + 1})
			grid[i][j-1] = 2
		}
		if j+1 < n && grid[i][j+1] == 1 {
			queue = append(queue, &status{i, j + 1, time + 1})
			grid[i][j+1] = 2
		}
	}
	//现在能感染的都感染完了
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				return -1
			}
		}
	}
	return res
}
