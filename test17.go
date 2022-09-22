package main

import "fmt"

func setZeroes(matrix [][]int) {
	rows := []int{}
	columns := []int{}
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				rows = append(rows, i)
				columns = append(columns, j)
			}
		}
	}
	fmt.Printf("%v\n", rows)
	fmt.Printf("%v\n", columns)

	for i := 0; i < len(rows); i++ {
		for j := 0; j < len(matrix[0]); j++ { //第rows【i】行全部为0
			matrix[rows[i]][j] = 0
		}
	}
	for i := 0; i < len(columns); i++ {
		for j := 0; j < len(matrix); j++ { //第columns【i】列全为0
			matrix[j][columns[i]] = 0
		}
	}
	fmt.Printf("%v\n", matrix)
}
func main() {
	s := make([][]int, 3)
	for i := 0; i < len(s); i++ {
		s[i] = make([]int, 4)
	}
	s[0][0] = 0
	s[0][1] = 1
	s[0][2] = 2
	s[0][3] = 0

	s[1][0] = 3
	s[1][1] = 4
	s[1][2] = 5
	s[1][3] = 2

	s[2][0] = 1
	s[2][1] = 3
	s[2][2] = 1
	s[2][3] = 5

	setZeroes(s)

}
