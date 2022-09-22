package DFS和BFS

//广度优先搜索bfs
func floodFill(image [][]int, sr int, sc int, color int) [][]int {
	totalRows := len(image)
	totalColumns := len(image[0])
	x := image[sr][sc]
	if x == color {
		return image
	}
	queue := []int{sr*totalColumns + sc}

	for len(queue) != 0 {
		currentPosition := queue[0]

		queue = queue[1:]
		currentRow := currentPosition / totalColumns
		currentColumn := currentPosition % totalColumns
		image[currentRow][currentColumn] = color
		if currentRow-1 >= 0 && image[currentRow-1][currentColumn] == x { //上
			queue = append(queue, (currentRow-1)*totalColumns+currentColumn)
			image[currentRow-1][currentColumn] = color
		}
		if currentRow+1 < totalRows && image[currentRow+1][currentColumn] == x { //下
			queue = append(queue, (currentRow+1)*totalColumns+currentColumn)
			image[currentRow+1][currentColumn] = color
		}
		if currentColumn-1 >= 0 && image[currentRow][currentColumn-1] == x { //左
			queue = append(queue, currentRow*totalColumns+currentColumn-1)
			image[currentRow][currentColumn-1] = color
		}
		if currentColumn+1 < totalColumns && image[currentRow][currentColumn+1] == x {
			queue = append(queue, currentRow*totalColumns+currentColumn+1)
			image[currentRow][currentColumn+1] = color
		}
	}
	return image
}

//dfs
func floodFill0(image [][]int, sr int, sc int, color int) [][]int {
	x := image[sr][sc]
	if x == color { //当前的颜色
		return image
	}
	rows := len(image)
	columns := len(image[0])
	var dps func(int, int)
	dps = func(sr int, sc int) {
		if sr < 0 || sc < 0 || sr >= rows || sc >= columns || image[sr][sc] != x {
			return
		}
		image[sr][sc] = color
		dps(sr+1, sc)
		dps(sr-1, sc)
		dps(sr, sc+1)
		dps(sr, sc-1)

	}
	dps(sr, sc)

	return image
}

func main() {

	grip := make([][]int, 3)
	for i := 0; i < 3; i++ {
		grip[i] = make([]int, 3)
	}
	grip[0][0] = 1
	grip[0][1] = 1
	grip[0][2] = 1

	grip[1][0] = 1
	grip[1][1] = 1
	grip[1][2] = 0

	grip[2][0] = 1
	grip[2][1] = 0
	grip[2][2] = 1

	println(floodFill(grip, 1, 1, 1))
}
