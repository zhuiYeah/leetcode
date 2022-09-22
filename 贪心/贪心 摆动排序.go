package 贪心

//nums的子序列中，最长的摆动排序子序列有多长？

//贪心思想：找出所有的峰
func wiggleMaxLength(nums []int) int {
	for i := 1; i < len(nums); i++ { //删掉数组中相邻的相同元素，（相邻的相同元素影响了峰的判断）
		if nums[i] == nums[i-1] {
			nums = append(nums[:i], nums[i+1:]...)
			i--
		}
	}
	if len(nums) == 1 {
		return 1
	}
	res := 1 //第一个数必定是峰
	var i int
	for i = 1; i < len(nums)-1; i++ {
		if (nums[i]-nums[i-1])*(nums[i+1]-nums[i]) < 0 { //nums[i]是峰
			res++
		}
	}
	//nums中的最后一个元素是峰吗？ 在去除了数组相邻相同元素的情况下，最后一个元素一定是峰
	res++
	return res
}

//别几把判断啦 最后一个元素一定是峰！
//if len(res) == 1 {
//if nums[i] != res[0] { //只要两个数互不相同，他们必定是摆动排序
//res = append(res, nums[i])
//}
//} else {
//if res[len(res)-1] > res[len(res)-2] && res[len(res)-1] > nums[i] {
//res = append(res, nums[i])
//}
//if res[len(res)-1] < res[len(res)-2] && res[len(res)-1] < nums[i] {
//res = append(res, nums[i])
//}
//}
