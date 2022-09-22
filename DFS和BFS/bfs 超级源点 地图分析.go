package DFS和BFS

import (
	"math"
)

//找一个0，使得0到1（最近的1）的距离最远，返回这个最远距离

type xyx struct {
	row      int
	col      int
	distance int
}

//写的要死调试了半天终于过了
func maxDistance(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	distance := make([][]int, m) //distance[i][j] : i，j位置到最近的1的距离
	for i := 0; i < len(distance); i++ {
		distance[i] = make([]int, n)
	}
	for i := 0; i < len(distance); i++ {
		for j := 0; j < len(distance[0]); j++ {
			distance[i][j] = math.MaxInt32
		}
	}
	var bfs func(int, int)
	bfs = func(i, j int) {
		visit := make([][]bool, m)
		for i := 0; i < len(visit); i++ {
			visit[i] = make([]bool, n)
		}

		queue := []*xyx{&xyx{i, j, 0}}
		for len(queue) != 0 {
			x := queue[0]
			queue = queue[1:]
			row := x.row
			col := x.col
			distance[row][col] = x.distance
			if row-1 >= 0 && distance[row-1][col] > distance[row][col]+1 && !visit[row-1][col] { //上
				queue = append(queue, &xyx{row - 1, col, x.distance + 1})
				visit[row-1][col] = true

			}
			if row+1 < m && distance[row+1][col] > distance[row][col]+1 && !visit[row+1][col] { //下
				queue = append(queue, &xyx{row + 1, col, x.distance + 1})
				visit[row+1][col] = true

			}
			if col-1 >= 0 && distance[row][col-1] > distance[row][col]+1 && !visit[row][col-1] { //左
				queue = append(queue, &xyx{row, col - 1, x.distance + 1})
				visit[row][col-1] = true

			}
			if col+1 < n && distance[row][col+1] > distance[row][col]+1 && !visit[row][col+1] { //右
				queue = append(queue, &xyx{row, col + 1, x.distance + 1})
				visit[row][col+1] = true

			}
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				bfs(i, j)
			}
		}
	}
	maxDis := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if distance[i][j] > maxDis {
				maxDis = distance[i][j]
			}
		}
	}
	if maxDis >= math.MaxInt32 || maxDis == 0 {
		return -1
	} else {
		return maxDis
	}
}

///地图分析 超级源点优化版
func maxDistance0(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m) //表示i，j是否被访问过
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}
	distance := make([][]int, m) //表示i，j位置到陆地的最近距离
	for i := 0; i < len(distance); i++ {
		distance[i] = make([]int, n)
		for j := 0; j < n; j++ {
			distance[i][j] = -1
		}
	}
	var queue []*xyx
	for i := 0; i < m; i++ { //经过这个循环，queue中将会得到一个超级源点
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				queue = append(queue, &xyx{i, j, 0})
				visited[i][j] = true
			}
		}
	}

	if len(queue) == m*n { //	全几把是1，没有0
		return -1
	}

	for len(queue) != 0 {
		curP := queue[0]
		queue = queue[1:]
		row := curP.row
		col := curP.col
		distance[row][col] = curP.distance
		if row-1 >= 0 && !visited[row-1][col] {
			queue = append(queue, &xyx{row - 1, col, curP.distance + 1})
			visited[row-1][col] = true
		}
		if row+1 < m && !visited[row+1][col] {
			queue = append(queue, &xyx{row + 1, col, curP.distance + 1})
			visited[row+1][col] = true
		}
		if col-1 >= 0 && !visited[row][col-1] {
			queue = append(queue, &xyx{row, col - 1, curP.distance + 1})
			visited[row][col-1] = true
		}
		if col+1 < n && !visited[row][col+1] {
			queue = append(queue, &xyx{row, col + 1, curP.distance + 1})
			visited[row][col+1] = true
		}
	}

	maxD := -1
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if distance[i][j] > maxD {
				maxD = distance[i][j]
			}
		}
	}
	return maxD
}

func main() {
	grid := [][]int{}
	grid = append(grid, []int{1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0})
	grid = append(grid, []int{1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1})
	grid = append(grid, []int{0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0})
	grid = append(grid, []int{0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1})
	grid = append(grid, []int{1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0})
	grid = append(grid, []int{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1})
	grid = append(grid, []int{0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0})
	grid = append(grid, []int{1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1})
	grid = append(grid, []int{0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0})
	grid = append(grid, []int{1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0})
	grid = append(grid, []int{0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0})
	grid = append(grid, []int{0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0})
	grid = append(grid, []int{0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0})
	grid = append(grid, []int{0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1})
	grid = append(grid, []int{1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1})
	grid = append(grid, []int{0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1})
	grid = append(grid, []int{0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1})
	grid = append(grid, []int{1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0})
	grid = append(grid, []int{1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1})
	grid = append(grid, []int{0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0})
	maxDistance(grid)

}
