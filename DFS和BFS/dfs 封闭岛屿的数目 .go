package DFS和BFS

//  1⃣️	return isClosed(i-1, j) && isClosed(i+1, j) && isClosed(i, j-1) && isClosed(i, j+1)
//  2⃣️   up := isClosed(i-1, j)
//		down := isClosed(i+1, j)
//		left := isClosed(i, j-1)
//		right := isClosed(i, j+1)
//      return up && down && right && left

//深刻思考这两种写法之间的区别
//1⃣️ 假设isClosed（i-1，j）已经判断出错了，后面的三个函数都不会进入，而isClosed函数里面还有漫水操作，就表示这些操作也不会进行
//1⃣️是一种更快的写法，但是如果函数里面有一些步骤需要执行的话，那1⃣️就不会进入之后的函数，造成错误

func closedIsland(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var isClosed func(int, int) bool
	isClosed = func(i, j int) bool {
		if i < 0 || j < 0 || i >= m || j >= n { //岛屿越界，必定不封闭
			return false
		}
		if grid[i][j] == 1 { //岛屿边界是水，这一边是封闭的
			return true
		}
		grid[i][j] = 1 //当前值必定为0，也就是说是陆地， 填满水,

		//return isClosed(i-1, j) && isClosed(i+1, j) && isClosed(i, j-1) && isClosed(i, j+1)

		up := isClosed(i-1, j)
		down := isClosed(i+1, j)
		left := isClosed(i, j-1)
		right := isClosed(i, j+1)
		return up && down && right && left //上下左右都封闭才算封闭
	}
	num := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 { //碰到陆地了
				if isClosed(i, j) {
					num++
				}
			}
		}
	}
	return num
}

func main() {
	//grid := make([][]int, 10)
	//for i:=0;i<len(grid);i++{
	//   grid[i]=make([]int,)
	//}
	var grid [][]int
	grid = append(grid, []int{0, 0, 1, 1, 0, 1, 0, 0, 1, 0})
	grid = append(grid, []int{1, 1, 0, 1, 1, 0, 1, 1, 1, 0})
	grid = append(grid, []int{1, 0, 1, 1, 1, 0, 0, 1, 1, 0})
	grid = append(grid, []int{0, 1, 1, 0, 0, 0, 0, 1, 0, 1})
	grid = append(grid, []int{0, 0, 0, 0, 0, 0, 1, 1, 1, 0})
	grid = append(grid, []int{0, 1, 0, 1, 0, 1, 0, 1, 1, 1})
	grid = append(grid, []int{1, 0, 1, 0, 1, 1, 0, 0, 0, 1})
	grid = append(grid, []int{1, 1, 1, 1, 1, 1, 0, 0, 0, 0})
	grid = append(grid, []int{1, 1, 1, 0, 0, 1, 0, 1, 0, 1})
	grid = append(grid, []int{1, 1, 1, 0, 1, 1, 0, 1, 1, 0})
	println(closedIsland(grid))

}
