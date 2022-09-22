package 哈希表

func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	m := map[int]int{} //key:nums1和nums2之和的相反数   value:组成这个k有几种方法
	for i := 0; i < len(nums1); i++ {
		for j := 0; j < len(nums2); j++ {
			m[-nums1[i]-nums2[j]]++
		}
	}

	res := 0

	for i := 0; i < len(nums3); i++ {
		for j := 0; j < len(nums4); j++ {
			res += m[nums3[i]+nums4[j]]
		}
	}
	return res
}
