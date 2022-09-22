package DFS和BFS

import "fmt"

func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	numsOfLand := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				numsOfLand++
				dfs(grid, i, j)
			}
		}
	}
	return numsOfLand
}

func dfs(grid [][]byte, i int, j int) { //grid是值传递？为什么会改变原函数的grid呢？     go中的切片传递都是引用传递哦
	totalRows := len(grid)
	totalColumns := len(grid[0])
	if i < 0 || j < 0 || i >= totalRows || j >= totalColumns || grid[i][j] == '0' { //递归结束条件
		return
	}

	grid[i][j] = '0' //代表这个点已经被visit过了
	dfs(grid, i+1, j)
	dfs(grid, i-1, j)
	dfs(grid, i, j+1)
	dfs(grid, i, j-1)
}

func main() {

	grip := make([][]byte, 4)
	for i := 0; i < 4; i++ {
		grip[i] = make([]byte, 5)
	}
	grip[0][0] = '1'
	grip[0][1] = '1'
	grip[0][2] = '1'
	grip[0][3] = '1'
	grip[0][4] = '0'
	grip[1][0] = '1'
	grip[1][1] = '1'
	grip[1][2] = '0'
	grip[1][3] = '1'
	grip[1][4] = '0'
	grip[2][0] = '1'
	grip[2][1] = '1'
	grip[2][2] = '0'
	grip[2][3] = '0'
	grip[2][4] = '0'
	grip[3][0] = '0'
	grip[3][1] = '0'
	grip[3][2] = '0'
	grip[3][3] = '0'
	grip[3][4] = '0'

	fmt.Printf("%v\n", numIslands(grip))
}
