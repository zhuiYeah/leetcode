package 二分查找

//这二分查找还蛮有意思，统计target在nums内出现的次数
func search00(nums []int, target int) int {
	res := 0
	left := 0
	right := len(nums) - 1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			p, q := mid-1, mid+1
			for p >= 0 {
				if nums[p] == target {
					p--
				} else {
					break
				}
			}
			for q < len(nums) {
				if nums[q] == target {
					q++
				} else {
					break
				}
			}
			res = q - p - 1
			break
		}
	}
	return res
}
