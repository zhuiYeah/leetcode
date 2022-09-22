package 贪心

import "sort"

func findContentChildren(g []int, s []int) int {
	n := len(g)
	sort.Ints(g)
	sort.Ints(s)
	//最小的饼干先喂给胃口最小的小孩
	for i := 0; i < len(s) && len(g) != 0; i++ { //遍历饼干
		if s[i] >= g[0] { //如果当前饼干s[i]能满足胃口最小的小孩
			g = g[1:]
		}
	}
	return n - len(g)
}
