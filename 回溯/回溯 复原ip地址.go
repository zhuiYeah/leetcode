package 回溯

//本体比较特殊，给定了回溯深度，即仅切割4次
import "strconv"

func restoreIpAddresses(s string) []string {
	var res []string
	var path []string          //存放切割的四个ip地址
	visit := map[string]bool{} //防止出现重复ip地址
	var backtracking func(startIndex int)
	backtracking = func(startIndex int) { //从startIndex开始切割
		if len(path) == 4 { //叶子节点
			if isIP(path[3]) { //最后一个ip地址是强制添加的，需要检查他的合法性
				ip := getIp(path)
				if visit[ip] == false {
					res = append(res, ip)
					visit[ip] = true
				}
			}
			return
		}
		//i<=len(s)-(3-len(path)) 这是为了保证四次切割不会切割到空   i<=startIndex+3 也是保证了ip地址的合法性(其实可以忽略的)
		for i := startIndex + 1; i <= len(s)-(3-len(path)) && i <= startIndex+3; i++ {
			if len(path) == 3 { //已经到最后一次切割了 必须强制收纳s的剩余所有元素
				path = append(path, s[startIndex:len(s)])
			} else { //前三次正常切割
				//从startIndex开始切割，切割到i（闭区间）
				if isIP(s[startIndex:i]) { //检查切割的合法性
					path = append(path, s[startIndex:i])
				} else { //不合法的话放弃这次切割
					continue
				}
			}
			//是否到达叶子节点？是否需要回溯？
			backtracking(i) //当前切割到i，下一个从i+1开始切割
			//回溯

			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}

func isIP(x string) bool {
	if x[0] == 48 && len(x) >= 2 {
		return false
	}
	a, _ := strconv.Atoi(x)
	if a >= 0 && a <= 255 {
		return true
	} else {
		return false
	}

}

func getIp(path []string) string {
	return path[0] + "." + path[1] + "." + path[2] + "." + path[3]
}
