package 哈希表

func maxEqualFreq(nums []int) int {
	maxFre := 0            //维护遍历数组过程中，如果一个数字他的频率最大，那么这个数字的频率就为maxFre
	count := map[int]int{} //数字i出现的频率为count[i]
	fre := map[int]int{}   //出现频率为i的数字有fre[i]个
	res := 0
	for i := 0; i < len(nums); i++ { //当前一共有i+1个数字
		if _, ok := count[nums[i]]; !ok { //目前还不存在数字nums[i]
			count[nums[i]] = 1 //nums[i]出现的次数现在为1
			fre[1]++           //频率为1的数字增加了一个
			maxFre = max(maxFre, 1)
		} else {
			fre[count[nums[i]]]--
			count[nums[i]]++
			fre[count[nums[i]]]++
			maxFre = max(maxFre, count[nums[i]])
		}
		if maxFre == 1 ||
			fre[maxFre]*maxFre+fre[maxFre-1]*(maxFre-1) == i+1 && fre[maxFre] == 1 ||
			fre[1]+fre[maxFre]*maxFre == i+1 && fre[1] == 1 {
			res = i + 1
		}
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
