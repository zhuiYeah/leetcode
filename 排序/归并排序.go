package 排序

import "fmt"

func mergeSort0(nums []int) {
	var mS func(nums []int, start int, end int)

	mS = func(nums []int, start int, end int) {
		if start == end {
			return
		} //如果只有一个元素 ，你还排序尼玛呢
		mid := start + (end-start)/2
		mS(nums, start, mid) //左半边已经归并排序完了
		mS(nums, mid+1, end) //右半边也已经归并排序完了

		i, j := start, mid+1 //i目前指代左半边的第一个元素，j目前指代右半边的第一个元素
		var tmp []int
		for i <= mid && j <= end {
			if nums[i] <= nums[j] {
				tmp = append(tmp, nums[i])
				i++
			} else {
				tmp = append(tmp, nums[j])
				j++
			}
		}

		for ; i <= mid; i++ {
			tmp = append(tmp, nums[i])
		}
		for ; j <= end; j++ {
			tmp = append(tmp, nums[j])
		}

		for i := start; i <= end; i++ {
			nums[i] = tmp[i-start]
		}
	}
	mS(nums, 0, len(nums)-1)
}

func main() {
	x := []int{3, 2, 5, 7, 8, 32, 9, 8, 2, 2, 46, 7, 32, 4, 6554, 643253, 532423543, 643, 5, 432634, 543, 6, 6, 3, 7}
	mergeSort0(x)
	fmt.Printf("%v\n", x)
}
