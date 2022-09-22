package 数组

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	left := min(start, destination)
	right := max(start, destination)
	sum := 0
	for i := 0; i < len(distance); i++ {
		sum += distance[i]
	}
	route1 := 0
	for i := left; i < right; i++ {
		route1 += distance[i]
	}
	return min(route1, sum-route1)
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
