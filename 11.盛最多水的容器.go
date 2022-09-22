package main

func maxArea(height []int) int {
	p, q := 0, len(height)-1
	capacity := 0
	for p < q {

		capacity = max(capacity, (q-p)*min(height[p], height[q]))
	}
	return capacity
}

//func min(a int, b int) int {
//	if a < b {
//		return a
//	} else {
//		return b
//	}
//}
