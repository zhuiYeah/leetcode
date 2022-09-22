package DFS和BFS

import "math"

type xx struct {
	row          int
	col          int
	bridgeLength int //桥的长度
}

func shortestBridge(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var queue []*xx
	var dfs func(i, j int)
	dfs = func(i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1 {
			return
		}
		grid[i][j] = 114514
		queue = append(queue, &xx{i, j, 0})
		dfs(i-1, j)
		dfs(i+1, j)
		dfs(i, j-1)
		dfs(i, j+1)
	}
	//通过dfs和这个for循环构建超级源点
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				dfs(i, j)
				goto label
			}
		}
	}
label:
	for len(queue) != 0 {
		QueueLengthOfThisLayer := len(queue)
		for i := 0; i < QueueLengthOfThisLayer; i++ {
			cur := queue[0]
			queue = queue[1:]
			row := cur.row
			col := cur.col
			if row-1 >= 0 {
				if grid[row-1][col] == 1 {
					return cur.bridgeLength
				} else if grid[row-1][col] == 0 {
					grid[row-1][col] = 114514
					queue = append(queue, &xx{row - 1, col, cur.bridgeLength + 1})
				}
			}
			if row+1 < m {
				if grid[row+1][col] == 1 {
					return cur.bridgeLength
				} else if grid[row+1][col] == 0 {
					grid[row+1][col] = 114514
					queue = append(queue, &xx{row + 1, col, cur.bridgeLength + 1})
				}
			}
			if col-1 >= 0 {
				if grid[row][col-1] == 1 {
					return cur.bridgeLength
				} else if grid[row][col-1] == 0 {
					grid[row][col-1] = 114514
					queue = append(queue, &xx{row, col - 1, cur.bridgeLength + 1})
				}
			}
			if col+1 < n {
				if grid[row][col+1] == 1 {
					return cur.bridgeLength
				} else if grid[row][col+1] == 0 {
					grid[row][col+1] = 114514
					queue = append(queue, &xx{row, col + 1, cur.bridgeLength + 1})
				}
			}
		}
	}
	//不可到达的代码
	return math.MaxInt32
}
