package main

//分组法 + hashmap
func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	n := len(nums1)
	m := map[int]int{} //num1[i]+num2[j]=sum,相同sum出现的次数
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			sum := nums1[i] + nums2[j]
			m[-sum]++
		}
	}
	res := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			sum := nums3[i] + nums3[j]
			if _, ok := m[sum]; ok {
				res += m[sum]
			}
		}
	}
	return res

}
