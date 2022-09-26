package DFS和BFS

//grid2中子岛屿的数量为？

func countSubIslands(grid1 [][]int, grid2 [][]int) int {
	m := len(grid2)
	n := len(grid2[0])
	var isSub func(i int, j int) bool
	isSub = func(i, j int) bool {
		if i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0 {
			return true
		}
		//现在grid2i，j是陆地了，那么grid1[i][j]如果不是陆地的话，那么grid2必定不是子岛屿

		//先淹没整片岛屿
		grid2[i][j] = 0 //先淹没这块陆地，这是dfs的要求和前提

		//递归 到达边缘了吗，到达海洋了吗
		down := isSub(i+1, j)
		up := isSub(i-1, j)
		left := isSub(i, j-1)
		right := isSub(i, j+1)
		//必要要把up down left right四条写在前面，先淹没完了,再慢慢回溯，判断grid2所在的原本岛屿i，j在grid1的对于位置是不是陆地

		//下面是回溯阶段干的事，判断是不是i，j这一点能不能满足子岛屿
		if grid1[i][j] == 0 { //如果这玩意写在up down left right之前的话，那么又是提前返回false，
			return false
		}

		return up && down && left && right
	}

	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid2[i][j] == 1 { //是陆地
				if isSub(i, j) { //是不是子陆地，不管是不是子陆地，isSub（i,j）执行完之后，该整块陆地都被淹没
					res++
				}
			}
		}
	}
	return res
}
