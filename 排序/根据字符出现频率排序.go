package 排序

import "sort"

//有待改进
func frequencySort(s string) string {
	frequency := map[byte]int{}
	for i := 0; i < len(s); i++ {
		frequency[s[i]]++
	}
	var res []byte
	for key, _ := range frequency {
		res = append(res, key)
	}

	sort.Slice(res, func(i int, j int) bool {
		return frequency[res[i]] > frequency[res[j]] //排序规则：频率更高的元素在前
	})
	var ss string
	for i := 0; i < len(res); i++ {
		for j := 0; j < frequency[res[i]]; j++ {
			ss += string(res[i])
		}
	}
	return ss
}
