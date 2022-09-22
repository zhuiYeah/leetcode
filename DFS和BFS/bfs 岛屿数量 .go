package DFS和BFS

type Queue struct {
	List []int
	Head int
	Tail int
}

func (this *Queue) add(value int) {
	this.List = append(this.List, 0) //每次add需要先将切片扩容1
	if this.isEmpty() {
		this.Head++
		this.Tail++
		this.List[this.Tail] = value
	} else {
		this.Tail++
		this.List[this.Tail] = value
	}

}

func (this *Queue) remove() int {
	if this.isEmpty() {
		return -1
	}
	value := this.List[this.Head]
	this.Head++
	if this.Head > this.Tail { //删掉了队列最后一个元素,将队列置空
		this.Head = 0
		this.Tail = 0
	}
	return value
}

func (this *Queue) isEmpty() bool {
	if this.Head == 0 && this.Tail == 0 {
		return true
	} else {
		return false
	}
}

func numIslands0(grid [][]byte) int {
	neighbor := Queue{[]int{0}, 0, 0} //新建一个空队列
	numOfLands := 0
	totalRows := len(grid)       //海洋陆地总行数
	totalColumns := len(grid[0]) //海洋陆地总列数
	for r := 0; r < totalRows; r++ {
		for c := 0; c < totalColumns; c++ {
			if grid[r][c] == '1' {
				neighbor.add(r*totalColumns + c) //	记录第一块陆地的绝对位置
				numOfLands++                     //每次广度优先搜索一次的话，岛屿数量加1，因为能一次循环搜索到的陆地已经全部被淹没
				grid[r][c] = '0'
			}
			for neighbor.isEmpty() == false { //
				currentPoint := neighbor.remove()             //队列的第一个元素，代表陆地的绝对位置
				currentRow := currentPoint / totalColumns     //当前行
				currentColumns := currentPoint % totalColumns // 当前列

				//识别一个点的上下左右四个位置是否为'1'，如果为'1'的话，将其归0并将其绝对位置写入队列，之后的循环中观察这个点的上下左右是否有陆地
				if currentColumns-1 >= 0 && grid[currentRow][currentColumns-1] == '1' { //左
					grid[currentRow][currentColumns-1] = '0'
					neighbor.add(currentRow*totalColumns + currentColumns - 1)
				}
				if currentColumns+1 < totalColumns && grid[currentRow][currentColumns+1] == '1' { //右
					grid[currentRow][currentColumns+1] = '0'
					neighbor.add(currentRow*totalColumns + currentColumns + 1)
				}
				if currentRow-1 >= 0 && grid[currentRow-1][currentColumns] == '1' { //上
					grid[currentRow-1][currentColumns] = '0'
					neighbor.add((currentRow-1)*totalColumns + currentColumns)
				}
				if currentRow+1 < totalRows && grid[currentRow+1][currentColumns] == '1' { //下
					grid[currentRow+1][currentColumns] = '0'
					neighbor.add((currentRow+1)*totalColumns + currentColumns)
				}
			}
		}
	}
	return numOfLands
}

func main() {
	//queue := Queue{[]int{0}, 0, 0}
	//queue.add(9)
	//queue.add(3)
	//queue.add(98)
	//println(queue.remove())
	//println(queue.remove())
	//queue.add(102)
	////queue.remove()
	//
	//fmt.Printf("%v\n", queue)
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

	println(numIslands0(grip))
}
