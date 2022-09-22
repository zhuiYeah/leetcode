package 排序

//给定一个字符串 s 和一个整数 k。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
//
//返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串
//
func orderlyQueue(s string, k int) string {
	b := []byte(s)
	if k == 1 {
		res := s
		for i := 0; i < len(s); i++ {
			tmp := b[0]
			b = append(b[:0], b[1:]...)
			b = append(b, tmp)
			if string(b) < res {
				res = string(b)
			}
		}
		return res
	}

	var mergeSort func(int, int)
	mergeSort = func(start, end int) {
		if start >= end {
			return
		}
		mid := start + (end-start)/2
		mergeSort(start, mid)
		mergeSort(mid+1, end)
		i, j := start, mid+1
		tmp := []byte{}
		for i <= mid && j <= end {
			if b[i] < b[j] {
				tmp = append(tmp, b[i])
				i++
			} else {
				tmp = append(tmp, b[j])
				j++
			}
		}
		for i <= mid {
			tmp = append(tmp, b[i])
			i++
		}
		for j <= end {
			tmp = append(tmp, b[j])
			j++
		}
		for k := start; k <= end; k++ {
			b[k] = tmp[k-start]
		}
	}
	mergeSort(0, len(b)-1)
	return string(b)
}
