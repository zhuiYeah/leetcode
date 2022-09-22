package 哈希表

func intersection(nums1 []int, nums2 []int) []int {
	seen := map[int]bool{}
	var res []int
	for i := 0; i < len(nums1); i++ {
		seen[nums1[i]] = true
	}
	for i := 0; i < len(nums2); i++ {
		if seen[nums2[i]] {
			res = append(res, nums2[i])
			seen[nums2[i]] = false
		}
	}
	return res
}
