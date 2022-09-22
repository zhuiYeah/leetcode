package main

import "fmt"

//杨辉三角形

func generate(numRows int) [][]int {
	ans := make([][]int, numRows)
	ans[0] = make([]int, 1) //二维数组必须要空间分配
	ans[0][0] = 1
	for i := 1; i < numRows; i++ {
		ans[i] = make([]int, i+1)
		ans[i][0], ans[i][i] = 1, 1
		for j := 1; j < i; j++ {
			ans[i][j] = ans[i-1][j-1] + ans[i-1][j]
		}
	}
	return ans
}

func main() {

	fmt.Printf("%v\n", getRow(3))
}

func getRow(rowIndex int) []int {
	ans1 := []int{1}
	ans2 := []int{1, 1}
	if rowIndex == 0 {
		return ans1
	}
	if rowIndex == 1 {
		return ans2
	}
	for i := 2; i <= rowIndex; i++ {
		ans1 = ans2
		ans2 = append(ans2, 1)

		for j := 1; j < i; j++ {
			ans2[j] = ans1[j-1] + ans1[j] //为什么总是出错？

			fmt.Printf("%v\n", ans1)

		}

	}
	return ans2

}
