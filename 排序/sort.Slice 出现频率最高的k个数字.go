package 排序

import "sort"

func topKFrequent2(nums []int, k int) []int {
	frequency := map[int]int{}
	for i := 0; i < len(nums); i++ {
		frequency[nums[i]]++
	}
	var res []int
	for key, _ := range frequency {
		res = append(res, key)
	}

	sort.Slice(res, func(i int, j int) bool {
		return frequency[res[i]] > frequency[res[j]] //排序规则：频率更高的元素在前
	})

	return res[:k]
}
