package 记忆化搜索

func eventualSafeNodes(graph [][]int) []int {
	n := len(graph) //一共有n个节点
	var res []int
	//memory
	//0：该节点未访问过
	//1：该节点已访问过,当前在栈中，或已经成环
	//2：该节点为安全节点 ，从该节点开始走，不管怎么走都能到达终端节点
	memory := make([]int, n)
	var safe func(int) bool //判断一个节点是不是安全节点
	safe = func(curNode int) bool {
		if memory[curNode] != 0 { //已经访问过该节点
			return memory[curNode] == 2
		}
		//走到这一步说明没访问过这个节点，先标记为已访问
		memory[curNode] = 1
		for i := 0; i < len(graph[curNode]); i++ {
			if !safe(graph[curNode][i]) { //如果该节点出发的任意一条路径是不安全的，那么直接false返回结果，该节点无法到达回溯阶段，memory对于该点的标记永远为1
				return false
			}
		}
		//能走到这里，说明该节点的所有路径都访问完了（或自己本身是终端节点，没有出度），但没有成环
		//如果不能走到这里，说明curNode是环中的一部分，成环 这里其实是一个"回溯"
		memory[curNode] = 2
		return true
	}
	for i := 0; i < n; i++ {
		if safe(i) {
			res = append(res, i)
		}
	}
	return res
}

func main() {
	gra := [][]int{}
	gra = append(gra, []int{1, 2})
	gra = append(gra, []int{2, 3})
	gra = append(gra, []int{5})
	gra = append(gra, []int{0})
	gra = append(gra, []int{5})
	gra = append(gra, []int{})
	gra = append(gra, []int{})
	eventualSafeNodes(gra)

}
