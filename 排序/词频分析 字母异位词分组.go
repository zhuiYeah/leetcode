package 排序

import "sort"

//将str数组中的所有字母异位词分到同一组中
func groupAnagrams(strs []string) [][]string {
	m := map[string][]string{}
	var res [][]string
	for i := 0; i < len(strs); i++ {
		b := []byte(strs[i])
		//mergeSortForByte(b, 0, len(b)-1)
		//当然也可以用go语言的排序接口
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		m[string(b)] = append(m[string(b)], strs[i])
	}
	for _, v := range m {
		res = append(res, v)
	}
	return res
}

func mergeSortForByte(b []byte, start int, end int) {
	if start >= end {
		return
	}
	mid := start + (end-start)/2
	mergeSortForByte(b, start, mid)
	mergeSortForByte(b, mid+1, end)
	i, j := start, mid+1
	var tmp []byte
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
	for i := start; i <= end; i++ {
		b[i] = tmp[i-start]
	}
}
