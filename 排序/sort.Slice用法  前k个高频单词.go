package 排序

import (
	"sort"
)

func topKFrequent1(words []string, k int) []string {
	frequency := map[string]int{}
	for i := 0; i < len(words); i++ {
		frequency[words[i]]++
	}
	var res []string
	for k, _ := range frequency {
		res = append(res, k)
	}

	//下面的就看不懂了！！！
	sort.Slice(res, func(i int, j int) bool { //对切片进行排序
		s, t := res[i], res[j]
		//frequency[s] > frequency[t] 代表频率由高到低排序     s<t表示按照字典顺序排序
		return frequency[s] > frequency[t] || (frequency[s] == frequency[t] && s < t) //指定排序规则
	})
	return res[:k]
}
