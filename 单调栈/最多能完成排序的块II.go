package 单调栈

//用大顶栈记录后面的第一个更小元素
//大顶栈中的每一元素都是一个块的最大值 ，后面块的最小值都必须要比本块的最大值大
func maxChunksToSorted(arr []int) int {
	var stack []int
	for i := 0; i < len(arr); i++ {
		var maxOfThisPiece int
		if len(stack) != 0 && arr[i] < stack[len(stack)-1] {
			maxOfThisPiece = stack[len(stack)-1]
			for len(stack) != 0 && arr[i] < stack[len(stack)-1] {
				stack = stack[:len(stack)-1]
			}
		}
		stack = append(stack, max(arr[i], maxOfThisPiece))
	}
	return len(stack)
}
