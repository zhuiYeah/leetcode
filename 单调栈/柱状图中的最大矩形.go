package 单调栈

//在维护一个 大顶栈 的过程中不断比较出现的矩形哪个最大
func largestRectangleArea(heights []int) int {
	//切片头部加入元素0
	heights = append(heights, 0)
	copy(heights[1:], heights[0:])
	heights[0] = 0
	heights = append(heights, 0) //不解释
	res := heights[0]
	index := &Stack{[]int{0}} // index储存height元素的下标，这是个大顶栈（栈顶的柱子高度必须最高）
	for i := 1; i < len(heights); i++ {
		for !index.isEmpty() && heights[i] < heights[index.Top()] {
			mid := index.Top()
			index.Pop()
			w := i - index.Top() - 1
			h := heights[mid]
			res = max(res, w*h)
		}
		index.Push(i)
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
