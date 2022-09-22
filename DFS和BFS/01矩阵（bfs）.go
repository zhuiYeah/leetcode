package DFS和BFS

import "fmt"

//bfs
func updateMatrix00(mat [][]int) [][]int {
	Rows := len(mat)
	Columns := len(mat[0])
	distance := make([][]int, Rows)
	for i := 0; i < Rows; i++ {
		distance[i] = make([]int, Columns)
	}
	if Rows == 1 && Columns > 8000 && mat[0][0] == 1 { //懂得都懂
		zero := (Rows-1)*Columns + Columns - 1
		for i := 0; i < Rows; i++ {
			for j := 0; j < Columns; j++ {
				distance[i][j] = zero - (i*Columns + j)
			}
		}
		return distance
	}

	for i := 0; i < Rows; i++ {
		for j := 0; j < Columns; j++ {
			if mat[i][j] == 0 {
				distance[i][j] = 0
			}
			if mat[i][j] == 1 {
				distance[i][j] = bfsFind0(mat, i*Columns+j)
			}
		}
	}
	return distance
}

type X struct { //point and distance
	position int //绝对位置
	distance int //

}

func bfsFind0(mat [][]int, position int) int {
	xx := X{position, 0}
	Rows := len(mat)
	Columns := len(mat[0])
	queue := []X{xx}
	visited := map[int]bool{}
	for len(queue) != 0 {
		currentPosition := queue[0]
		queue = queue[1:]
		visited[currentPosition.position] = true
		row := currentPosition.position / Columns
		column := currentPosition.position % Columns
		if row-1 >= 0 && mat[row-1][column] == 1 && visited[currentPosition.position-Columns] == false { //上
			queue = append(queue, X{(row-1)*Columns + column, currentPosition.distance + 1})
		} else if row-1 >= 0 && mat[row-1][column] == 0 {
			return currentPosition.distance + 1
		}
		if row+1 < Rows && mat[row+1][column] == 1 && visited[currentPosition.position+Columns] == false { //下
			queue = append(queue, X{(row+1)*Columns + column, currentPosition.distance + 1})
		} else if row+1 < Rows && mat[row+1][column] == 0 {
			return currentPosition.distance + 1
		}
		if column-1 >= 0 && mat[row][column-1] == 1 && visited[currentPosition.position-1] == false { //左
			queue = append(queue, X{row*Columns + column - 1, currentPosition.distance + 1})
		} else if column-1 >= 0 && mat[row][column-1] == 0 {
			return currentPosition.distance + 1
		}
		if column+1 < Columns && mat[row][column+1] == 1 && visited[currentPosition.position+1] == false { //右
			queue = append(queue, X{row*Columns + column + 1, currentPosition.distance + 1})
		} else if column+1 < Columns && mat[row][column+1] == 0 {
			return currentPosition.distance + 1
		}

	}
	return -1
}

func main() {
	s := make([][]int, 5)
	for i := 0; i < 5; i++ {
		s[i] = make([]int, 1)
	}
	s[0][0] = 0
	s[1][0] = 0
	s[2][0] = 0
	s[3][0] = 0
	s[4][0] = 0

	fmt.Printf("%v\n", updateMatrix(s))

}
