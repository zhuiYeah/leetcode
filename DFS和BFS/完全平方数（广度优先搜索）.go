package DFS和BFS

import "math"

type sumAndLayer struct { //多叉树的节点，sum目前为止的总和。layer表示树的层次，即目前求和用了多少个完全平方数
	sum   int
	layer int
}

func numSquares(n int) int {
	if n == 0 {
		return 0
	}
	layer0 := sumAndLayer{0, 0}    //初始，总和为0，用了0个数求和
	queue := []sumAndLayer{layer0} //初始化队列
	x := int(math.Sqrt(float64(n)))
	for len(queue) > 0 {
		currentPoint := queue[0]            //弹出队列
		nextLayer := currentPoint.layer + 1 //每次广度优先搜索，求和的总个数加一
		queue = queue[1:]                   //弹出队列
		for i := 1; i <= x; i++ {
			varietySum := currentPoint.sum
			varietySum += i * i
			if varietySum == n {
				return nextLayer
			}
			if varietySum < n {
				newPoint := sumAndLayer{varietySum, nextLayer}
				queue = append(queue, newPoint)
			}
		}
	}
	return -1
}

func main() {
	println(numSquares(-10))
}
