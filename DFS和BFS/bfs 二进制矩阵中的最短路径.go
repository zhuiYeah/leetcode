package DFS和BFS

type xyz struct {
	row        int
	col        int
	curPathLen int
}

//dirs描述了八个方向
var dirs = []struct{ i, j int }{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}

//从左上角开始，你可以走八个方向，能走的节点必须值为0，给出从左上角走到右下角的最短路径长度
func shortestPathBinaryMatrix(grid [][]int) int {
	n := len(grid)
	if n == 1 && grid[0][0] == 0 {
		return 1
	}
	var queue []*xyz
	if grid[0][0] == 0 {
		queue = append(queue, &xyz{0, 0, 1})
		grid[0][0] = 1 //表示0 0 位置已经走过了
	}
	for len(queue) != 0 {
		x := len(queue)
		for i := 0; i < x; i++ {
			cur := queue[0]
			queue = queue[1:]
			for j := 0; j < len(dirs); j++ { //八个方向各尝试走一次
				nextRow := cur.row + dirs[j].i
				nextCol := cur.col + dirs[j].j
				if nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0 {
					queue = append(queue, &xyz{nextRow, nextCol, cur.curPathLen + 1})
					grid[nextRow][nextCol] = 1
					if nextRow == n-1 && nextCol == n-1 {
						return cur.curPathLen + 1
					}
				}
			}
		}
	}
	return -1
}
