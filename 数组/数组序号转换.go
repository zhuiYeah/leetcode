package 数组

func arrayRankTransform(arr []int) []int {
	if len(arr) == 0 {
		return nil
	}
	tmp := mergeSort(arr)
	m := map[int]int{} //key : arr中的元素  value：元素序号
	m[tmp[0]] = 1
	for i := 1; i < len(tmp); i++ {
		if tmp[i] != tmp[i-1] {
			m[tmp[i]] = i + 1
		}
	}
	var res []int
	for i := 0; i < len(arr); i++ {
		res = append(res, m[arr[i]])
	}
	return res
}

//自己实现了切合本题需要的归并排序，去除了重复元素
func mergeSort(nums []int) []int {
	if len(nums) == 0 || len(nums) == 1 {
		return nums
	}

	mid := (len(nums) - 1) / 2
	left := mergeSort(nums[0 : mid+1])
	right := mergeSort(nums[mid+1:])
	m := len(left)
	n := len(right)
	var tmp []int
	i, j := 0, 0 //两个指针，分别指向左右两个已排序好的数组
	for i < m && j < n {
		if left[i] == right[j] {
			tmp = append(tmp, left[i])
			i++
			j++
		} else if left[i] > right[j] {
			tmp = append(tmp, right[j])
			j++
		} else {
			tmp = append(tmp, left[i])
			i++
		}
	}
	for i < m {
		if i != 0 && left[i] != left[i-1] {
			tmp = append(tmp, left[i])
		} else if i == 0 {
			tmp = append(tmp, left[i])
		}
		i++
	}

	for j < n {
		if j != 0 && right[j] != right[j-1] {
			tmp = append(tmp, right[j])
		} else if j == 0 {
			tmp = append(tmp, right[j])
		}
		j++
	}
	return tmp
}
