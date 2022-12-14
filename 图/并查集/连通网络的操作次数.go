package 并查集

//n表示计算机的个数，编号为0～n-1，connections表示了计算机之间的链接情况；给出最少的操作次数使这个计算机网络连通
func makeConnected(n int, connections [][]int) int {
	cablesNum := len(connections)
	if cablesNum < n-1 { //n个计算机相连最少需要n-1个线
		return -1
	}
	father := make([]int, n)
	//初始化并查集，各自为王
	for i := 0; i < n; i++ {
		father[i] = i
	}
	var find func(x int) int
	find = func(x int) int {
		if x == father[x] {
			return x
		}
		father[x] = find(father[x])
		return father[x]
	}
	var join func(x, y int) //将y所在集群加入x所在集群
	join = func(x, y int) {
		x = find(x)
		y = find(y)
		if x == y {
			return
		}
		father[y] = x
	}
	for i := 0; i < len(connections); i++ {
		join(connections[i][0], connections[i][1])
	}
	var numOfCluster int
	for i := 0; i < len(father); i++ {
		if i == father[i] {
			numOfCluster++
		}
	}
	return numOfCluster - 1
}
