package 排序

func reversePairs(nums []int) int {
	var mergeSort func(nums []int, start int, end int) int
	mergeSort = func(nums []int, start int, end int) int {
		if start >= end {
			return 0
		}
		mid := start + (end-start)/2
		n := 0
		n += mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end)

		//now，nums[start:mid] nums[mid+1,end]两部分已经排序完成
		//现在查找 nums[start:mid] nums[mid+1,end]两部分中的翻转对
		j2 := mid + 1
		for i := start; i <= mid; i++ {
			for j2 <= end && nums[i] > 2*nums[j2] {
				j2++
			}
			n += j2 - mid - 1
		}

		//现在,nums[start:mid] nums[mid+1,end]两部分的翻转对已经全部查找完毕
		//现将nums[start:mid] nums[mid+1,end]合并成nums[start,end]完成排序
		i, j := start, mid+1
		tmp := []int{}
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

		return n
	}

	return mergeSort(nums, 0, len(nums)-1)
}
