package 并查集

//计算连通分量的个数
func findCircleNum(isConnected [][]int) int {
	n := len(isConnected) //一共有n个城市
	var father []int = make([]int, n)
	//初始化并查集
	for i := 0; i < len(father); i++ {
		father[i] = i
	}
	var find func(x int) int //找跟节点
	find = func(x int) int {
		if x == father[x] {
			return x
		}
		father[x] = find(father[x])
		return father[x]
	}
	//var same func(x, y int) bool
	//same = func(x, y int) bool {
	//	x = find(x)
	//	y = find(y)
	//	return x == y
	//}
	var join func(x, y int) //将y所在集群加入x所在的集群
	join = func(x, y int) {
		x = find(x)
		y = find(y)
		if x == y {
			return
		}
		father[y] = x
	}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if isConnected[i][j] == 1 {
				join(i, j)
			}
		}
	}
	var numOfCluster int
	for i := 0; i < n; i++ {
		//跟节点的唯一特征就是father[i] == i
		if father[i] == i {
			numOfCluster++
		}
	}
	return numOfCluster
}
