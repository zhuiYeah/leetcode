package 回溯

import "sort"

//coins表示不同面额的硬币，amount表示要凑成的总数，硬币数目无限，凑出amount共有多少种方案？

//超时
func change(amount int, coins []int) int {
	var res int
	var path int
	sort.Ints(coins)
	var backtracking func(startIndex int)
	backtracking = func(startIndex int) {
		if path == amount { //叶子节点
			res++
		}
		for i := startIndex; i < len(coins); i++ {
			//处理节点
			if path+coins[i] > amount {
				break
			}
			path += coins[i]
			//是否到叶子节点
			backtracking(i) //可以无限重复取硬币，所以从当前取得硬币i开始
			//回溯
			path -= coins[i]
		}
	}
	backtracking(0)
	return res
}

func main() {
	change(500, []int{3, 5, 7, 8, 9, 10, 11})
}
