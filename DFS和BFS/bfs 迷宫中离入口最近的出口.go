package DFS和BFS

func nearestExit(maze [][]byte, entrance []int) int {
	type status struct {
		row           int
		col           int
		CurNumOfMoves int
	}

	dirs := []struct{ x, y int }{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	m := len(maze)
	n := len(maze[0])
	maze[entrance[0]][entrance[1]] = '+' //标记入口为走过
	queue := []*status{&status{entrance[0], entrance[1], 0}}
	for len(queue) != 0 {
		x := len(queue) //x表示广度搜索一层中节点的长度
		for i := 0; i < x; i++ {
			cur := queue[0]
			queue = queue[1:]
			for token := 0; token < len(dirs); token++ {
				nextRow := cur.row + dirs[token].x
				nextCol := cur.col + dirs[token].y
				if nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && maze[nextRow][nextCol] == '.' {
					queue = append(queue, &status{nextRow, nextCol, cur.CurNumOfMoves + 1})
					maze[nextRow][nextCol] = '+'
					if nextRow == 0 || nextRow == m-1 || nextCol == 0 || nextCol == n-1 {
						return cur.CurNumOfMoves + 1
					}
				}
			}
		}
	}
	return -1
}
