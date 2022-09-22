package 数组

func diagonalSum(mat [][]int) int {
  sum := 0
  n := len(mat)
  for i := 0; i < n; i++ {
    sum += mat[i][i]
    sum += mat[i][n-1-i]
  }

  if n%2 == 1 {
    sum -= mat[n/2][n/2]
  }

  return sum
}
