package 二分查找

func peakIndexInMountainArray(arr []int) int {
	left := 1
	right := len(arr) - 2
	for left <= right {
		mid := left + (right-left)/2
		if arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1] {
			return mid
		}
		if arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1] {
			right = mid - 1
		}
		if arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1] {
			left = mid + 1
		}
	}
	return 0

}
