package 数组

func matrixReshape(mat [][]int, r int, c int) [][]int {
	if r*c != len(mat)*len(mat[0]) {
		return mat
	}
	res := make([][]int, r)
	for i := 0; i < len(res); i++ {
		res[i] = make([]int, c)
	}
	var nums []int
	for i := 0; i < len(mat); i++ {
		for j := 0; j < len(mat[0]); j++ {
			nums = append(nums, mat[i][j])
		}
	}
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			res[i][j] = nums[0]
			nums = append(nums[:0], nums[1:]...)
		}
	}
	return res
}

func main() {
	mat := [][]int{}
	mat = append(mat, []int{1, 2})
	mat = append(mat, []int{3, 4})
	matrixReshape(mat, 2, 4)

}
