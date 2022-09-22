package 回溯

import "fmt"

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

var res [][]int

func combine(n int, k int) [][]int {
	res = [][]int{}
	if n <= 0 || k > n || k <= 0 {
		return res
	}
	backTrack(n, k, 1, []int{})
	return res
}

func backTrack(n, k, startIndex int, track []int) { //从n个数中找到长为k的所有组合，当前已找到的数字全部存放在track中，当前从startIndex开始查找
	if len(track) == k { //到达叶子节点，即找到一个组合了 ，在叶子节点收集结果 并 返回
		temp := make([]int, k)
		copy(temp, track)
		res = append(res, temp)
		return
	}

	if len(track)+n-startIndex+1 < k { //剪枝，避免无效搜索
		return
	}

	for i := startIndex; i <= n; i++ { //假设i目前是2
		track = append(track, i)    //处理节点     track目前是 1，2
		backTrack(n, k, i+1, track) //递归，深度搜索这一节点，在树形图里面一层一层向下走 。是否要回溯呢，如果是的话，会进入下一条语句
		//进入backTrack后，backTrack判断已经达到回溯的条件了，直接回溯 ，进入下一条语句，删掉 2
		track = track[:len(track)-1] //回溯 ，撤销节点处理结果
	}

	//如果backTrack函数能够正常执行完的话，说明for 2，3，4 都执行完了 ，会进行回溯，track数组里面会弹出 1 ，回到最初的那一层for 1，2，3，4
}

func main() {
	fmt.Printf("%v\n", combine(20, 4))
}
