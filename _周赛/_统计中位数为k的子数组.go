package _周赛

func countSubarrays(nums []int, k int) int {
	n := len(nums)
	kidx = -1
	for i := 0; i < n; i++ {
		if nums[i] == k {
			kidx = i
			break
		}
	}
	left := []int{}
	right := []int{}
	right = append(right, 0)
	left = append(left, 0)
	for i := kidx + 1; i < n; i++ {
		if nums[i] > k {
			x := right[0] + 1
			x = append(x, 0)

			append(right, x+1)
		}
	}
}
