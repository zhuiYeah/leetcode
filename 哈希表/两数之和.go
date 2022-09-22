package 哈希表

func twoSum(nums []int, target int) []int {
	seen := map[int]int{} //map中的存储结构为 {key：数据元素，value：数组元素对应的下表}。
	for i := 0; i < len(nums); i++ {
		if v, ok := seen[target-nums[i]]; ok { //v,ok:=seen[target - nums[i]]
			return []int{i, v}
		} else {
			seen[nums[i]] = i
		}
	}
	return []int{}
}
