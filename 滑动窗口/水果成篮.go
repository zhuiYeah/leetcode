package 滑动窗口

func totalFruit(fruits []int) int {
	res := 0
	left := 0
	right := 0
	m := map[int]int{} //key:果子的种类  value：该种类果子已经采摘的个数
	for right < len(fruits) {
		for right < len(fruits) && len(m) <= 2 {
			_, ok := m[fruits[right]]
			if len(m) == 2 && !ok {
				break
			}
			m[fruits[right]]++
			res = max(res, right-left+1)
			right++
		}
		m[fruits[left]]--
		if m[fruits[left]] == 0 {
			delete(m, fruits[left])
		}
		left++
	}
	return res
}

// func main() {
// 	x := []int{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
// 	totalFruit(x)
// }
