package DFS和BFS

import "math"

//访问过的点仍可以访问，所以不能设置visit记录访问，但是题中节点成环，这会导致无限循环， 所以这题卡在这里了
func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	mRed := map[int][]int{}  //key：某节点  value：key节点走红色边可以到达所有的节点
	mBlue := map[int][]int{} //key：某节点  value：key节点走蓝色边可以到达所有的节点
	for i := 0; i < len(redEdges); i++ {
		mRed[redEdges[i][0]] = append(mRed[redEdges[i][0]], redEdges[i][1])
	}
	for i := 0; i < len(blueEdges); i++ {
		mBlue[blueEdges[i][0]] = append(mBlue[blueEdges[i][0]], blueEdges[i][1])
	}
	type status struct {
		preEdgeColor string //
		curNode      int    //记录当前节点的位置 0～n-1
		curStep      int    //记录走到当前节点已经走了多少步
	}
	res := make([]int, n)
	res[0] = 0

	//从节点0到节点0的距离为0，其他节点暂时认为不可到达
	for i := 1; i < len(res); i++ {
		res[i] = math.MaxInt32
	}
	var queue []*status
	visit := make([]bool, n) //标记节点i是否被访问过
	visit[0] = true
	for i := 0; i < len(mRed[0]); i++ {
		queue = append(queue, &status{"red", mRed[0][i], 1})
		visit[mRed[0][i]] = true
	}
	for i := 0; i < len(mBlue[0]); i++ {
		queue = append(queue, &status{"blue", mBlue[0][i], 1})
		visit[mBlue[0][i]] = true
	}
	for len(queue) != 0 {
		x := len(queue)
		for i := 0; i < x; i++ {
			cur := queue[0]
			queue = queue[1:]
			curNode := cur.curNode
			res[curNode] = min(res[curNode], cur.curStep)
			//接下来curNode可以往哪里走呢？
			if cur.preEdgeColor == "red" {
				for j := 0; j < len(mBlue[curNode]); j++ {
					if !visit[mBlue[curNode][j]] {
						queue = append(queue, &status{"blue", mBlue[curNode][j], cur.curStep + 1})
						visit[mBlue[curNode][j]] = true
					}
				}
			} else if cur.preEdgeColor == "blue" {
				for j := 0; j < len(mRed[curNode]); j++ {
					if !visit[mRed[curNode][j]] {
						queue = append(queue, &status{"red", mRed[curNode][j], cur.curStep + 1})
						visit[mRed[curNode][j]] = true
					}
				}
			}
		}
	}
	for i := 0; i < len(res); i++ {
		if res[i] >= math.MaxInt32 {
			res[i] = -1
		}
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
