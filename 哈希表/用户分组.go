package 哈希表

//groupSize=[3,3,3,3,3,1,3]  表示第0人位于长为3的分组内，第1人位于长为3的扽分组内，...，第5人位于长为1的分组内，将这些用户分组
func groupThePeople(groupSizes []int) [][]int {
	var res [][]int
	m := map[int][]int{} //key:分组的长度    value：属于该长度组的组中的成员
	for i := 0; i < len(groupSizes); i++ {
		m[groupSizes[i]] = append(m[groupSizes[i]], i)
	}
	for k, v := range m {
		for i := 0; i < len(v)/k; i++ {
			var path []int
			for j := k * i; len(path) < k; j++ {
				path = append(path, v[j])
			}
			res = append(res, path)
		}
	}
	return res
}
