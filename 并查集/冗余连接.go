package 并查集

//删掉一个冗余连接使得数据之间的连接构成一个类树状无循环结构

//并查集基本模板
var n int = 1003               //节点数量3 到 1000
var father = make([]int, 1003) //father[i] : 节点i的父节点是father[i]

//并查集初始化
func initialize() {
	for i := 0; i < len(father); i++ {
		father[i] = i //初始的时候每个节点各自为王，每个节点是自己的父节点，就互不相关
	}
}

//并查集寻根，节点u寻找他的最祖先根节点
func find(u int) int {
	if u == father[u] { //这是根节点的特征
		return u
	}
	father[u] = find(father[u]) //寻找u的父节点的父节点
	return father[u]
}

//将 u <- v 这条边加入并查集
func join(u, v int) {
	u = find(u)
	v = find(v)
	if u == v {
		return
	}
	father[v] = u
}

//判断 u 和 v是否找到同一个根
func same(u, v int) bool {
	u = find(u)
	v = find(v)
	return u == v
}

//以上就是 并查集的基本模板
func findRedundantConnection(edges [][]int) []int {
	initialize()
	for i := 0; i < len(edges); i++ {
		if same(edges[i][0], edges[i][1]) { //如果两个节点能寻到同一个根，那么连接这两个节点就会导致出现循环
			return edges[i]
		} else {
			join(edges[i][0], edges[i][1])
		}
	}
	return nil
}
