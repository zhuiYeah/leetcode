package 回溯

//将字符串s分割成很多子串，使得每个子串都是回文串 给出所有分割结果

//即使清楚地知道回溯过程，但一些细节仍然非常致命
func partition(s string) [][]string {
	var result [][]string
	var path []string
	var backtracking func(startIndex int) //startIndex表示切割的起始点
	backtracking = func(startIndex int) {
		if startIndex == len(s) { //叶子节点
			tmp := make([]string, len(path))
			copy(tmp, path)
			result = append(result, tmp)
			return
		}
		for i := startIndex + 1; i <= len(s); i++ { //当然不能切割一个空片了，所以从start+1开始切割
			if isP(s[startIndex:i]) { //	切割下来的这部分是回文串吗 ，剪枝
				path = append(path, s[startIndex:i])
			} else {
				continue
			}
			//是否到达叶子结点？  是：下一步回溯  否：深度搜索，扩充path
			backtracking(i)
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return result
}

func isP(x string) bool {
	for i := 0; i < len(x)/2; i++ {
		if x[i] != x[len(x)-1-i] {
			return false
		}
	}
	return true
}

func main() {
	//x := partition("bb")
	//fmt.Printf("%v\n", x)

}
