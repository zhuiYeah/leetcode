package 排序

func reversePairs0(nums []int) int {
	return mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, start int, end int) int {
	if start == end { //拆分到只有一个元素时，当然不需要排序 ，一个元素也不存在逆序对
		return 0
	}
	mid := start + (end-start)/2                                     //取中间点
	res := mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end) //根据中间点拆成两个数组，对两块分别进行排序
	i, j := start, mid+1                                             //i指向左半边，j指向右半边
	tmp := []int{}                                                   //临时储存排序后的数组
	for i <= mid && j <= end {
		if nums[i] <= nums[j] { //左半边元素比当前右半边的小，但比已经排序好的右半边的大，故res加上右边已经排序好的元素个数
			tmp = append(tmp, nums[i])
			res += j - mid - 1 //
			i++
		} else { //右半边元素小比左半边元素小，表明出现逆序对，但是逆序对个数是右边已经排序好的元素个数，仅需要指针右移，做一个指示器的作用即可
			tmp = append(tmp, nums[j])
			j++
		}
	} //这个for循环结束后，要么左半边遍历完，要么右半边遍历完

	//如果左半边没有遍历完的话，说明左半边剩下来的元素是比右半边全部元素都要大的（出现逆序），所以还要加上 逆序对的个数：（左半边元素个数）*（右半边全部排序好的元素）
	for ; i <= mid; i++ {
		tmp = append(tmp, nums[i])
		res += j - mid - 1
	}

	//如果右半边元素没有遍历完的话，说明右半边剩下来的元素更大（未出现逆序），所以res不变
	for ; j <= end; j++ {
		tmp = append(tmp, nums[j])
	}

	//将排序好的元素写入nums的一部分中，完成该部分的排序
	for i := start; i <= end; i++ {
		nums[i] = tmp[i-start]
	}

	return res
}
