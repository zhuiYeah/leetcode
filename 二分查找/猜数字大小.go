package 二分查找

func guessNumber(n int) int {
	left := 1
	right := n
	for left <= right {
		mid := left + (right-left)/2
		if guess(mid) == 0 {
			return mid
		}
		if guess(mid) == -1 {
			left = mid + 1
		}
		if guess(mid) == 1 {
			right = mid - 1
		}
	}
	return 0
}

func guess(n int) int {
	if n == 6 {
		return 0
	}
	if n < 6 {
		return -1
	}
	if n > 6 {
		return 1
	}
	return 123
}
