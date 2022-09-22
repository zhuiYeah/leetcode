package DFS和BFS

//func pacificAtlantic(heights [][]int) [][]int {
//	m := len(heights)
//	n := len(heights[0])
//	var pacific func(int, int) bool
//	var atlantic func(int, int) bool
//	pacific = func(i, j int) bool {
//		if i == 0 || j == 0 {
//			return true
//		}
//		up := false
//		if i-1 >= 0 && heights[i-1][j] <= heights[i][j] {
//			up = pacific(i-1, j)
//		}
//	}
//}

////刚写了bfs超时了，看了leetcode的评论，这是个起点不确定而终点（边界条件）确定的问题，那么就从终点开始找起点
func pacificAtlantic(heights [][]int) [][]int {
	m := len(heights)
	n := len(heights[0])
	visit := make([][]bool, m) //如果太平洋的水流逆流而上，能否流到i，j位置
	for i := 0; i < len(visit); i++ {
		visit[i] = make([]bool, n)
	}
	var res [][]int
	var dfs1 func(int, int) //太平洋的水逆流而上
	var dfs2 func(int, int) //大西洋的水逆流而上

	dfs1 = func(i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n || visit[i][j] { //如果越界或者已经访问过这一点，那么返回
			return
		}
		visit[i][j] = true
		if i-1 >= 0 && heights[i-1][j] >= heights[i][j] {
			dfs1(i-1, j)
		}
		if i+1 < m && heights[i+1][j] >= heights[i][j] {
			dfs1(i+1, j)
		}
		if j-1 >= 0 && heights[i][j-1] >= heights[i][j] {
			dfs1(i, j-1)
		}
		if j+1 < n && heights[i][j+1] >= heights[i][j] {
			dfs1(i, j+1)
		}
	}

	for j := 0; j < n; j++ {
		dfs1(0, j)
	}
	for i := 0; i < m; i++ {
		dfs1(i, 0)
	}

	visit000 := make([][]bool, m) //如果大西洋的水流逆流而上，能否流到i，j位置
	for i := 0; i < len(visit); i++ {
		visit000[i] = make([]bool, n)
	}
	dfs2 = func(i, j int) {
		if visit000[i][j] == true { //之前已经逆流到这儿了，不要重复来了
			return
		}
		if visit[i][j] == true { //大西洋的水能够逆流到i，j时，发现太平洋的水也能逆流到这里
			res = append(res, []int{i, j})
		}
		visit000[i][j] = true
		if i-1 >= 0 && heights[i-1][j] >= heights[i][j] {
			dfs2(i-1, j)
		}
		if i+1 < m && heights[i+1][j] >= heights[i][j] {
			dfs2(i+1, j)
		}
		if j-1 >= 0 && heights[i][j-1] >= heights[i][j] {
			dfs2(i, j-1)
		}
		if j+1 < n && heights[i][j+1] >= heights[i][j] {
			dfs2(i, j+1)
		}
	}
	for i := 0; i < m; i++ {
		dfs2(i, n-1)
	}
	for j := 0; j < n; j++ {
		dfs2(m-1, j)
	}
	return res
}
