package 二分查找

//找到第一个错误版本

func firstBadVersion(n int) int {
	left := 1
	right := n
	var BadVer int
	for left <= right {
		mid := left + (right-left)/2
		if isBadVersion(mid) == false {
			left = mid + 1
		}
		if isBadVersion(mid) == true {
			BadVer = mid
			right = mid - 1
		}
	}
	return BadVer
}

func isBadVersion(int) bool {
	return false
}
