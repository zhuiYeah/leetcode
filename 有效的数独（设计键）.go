package main

import (
	"fmt"
	"strconv"
)

//需要一个hashmap记录数独中的数字出现的频次，由于只包含数字1～9，故用一个长为9的一维数组模拟hashmap
func isValidSudoku(board [][]byte) bool {
	rows := [9][9]int{}    //表示第i行中， 数字1～9（对应索引0～8）出现的频次
	columns := [9][9]int{} //表示第i列中， 数字1～9（对应索引0～8）出现的频次
	m := [3][3][9]int{}    //表示第i行第j列个3*3宫格内，数字1～9（对应索引0～8）出现的频次

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board); j++ {

			if board[i][j] == '.' {
				continue
			}

			value, _ := strconv.Atoi(string(board[i][j]))
			//目前的元素位于数独表中的第i行第j列奥～

			rows[i][value-1]++
			columns[j][value-1]++
			m[i/3][j/3][value-1]++
			if rows[i][value-1] > 1 || columns[j][value-1] > 1 || m[i/3][j/3][value-1] > 1 {
				return false
			}
		}

	}
	return true
}

func main() {
	s := "."
	b := []byte(s)
	fmt.Printf("%v\n", b[0] == 47)

}
