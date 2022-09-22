package 回溯

func findDifferentBinaryString(nums []string) string {
	n := len(nums[0])
	var res string
	//本题也不需要一个path变量，因为找到一个正确的结果就立刻返回，不会进行下面的回溯阶段了，res的值也就会在找到正确结果后固定不变
	var backtracking func(curLength int) bool //找到一个正确结果立刻返回
	backtracking = func(curLength int) bool {
		if curLength == n+1 { //叶子结点
			if compare(res, nums) {
				return true
			}
			return false
		}
		for i := 0; i < 2; i++ {
			if i == 0 {
				res += "0"
			} else {
				res += "1"
			}
			if backtracking(curLength + 1) { //找到一个正确结果立刻返回
				return true
			}
			//找到正确结果后不会执行下面的回溯了
			res = res[:len(res)-1]
		}
		return false
	}
	backtracking(1) //注意第一层的当前长度为1，因为第一层在进入backtracking之前就已经选择了0或1扩充了他的长度
	return res
}

func compare(s string, nums []string) bool {
	for i := 0; i < len(nums); i++ {
		if s == nums[i] {
			return false
		}
	}
	return true
}
func main() {
	nums := []string{"01", "10"}
	findDifferentBinaryString(nums)
}
