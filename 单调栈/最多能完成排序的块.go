package 单调栈

func maxChunksToSorted0(arr []int) int {
	var stack []int
	for i := 0; i < len(arr); i++ {
		var maxOfThisPiece int
		if len(stack) != 0 && arr[i] < stack[len(stack)-1] {
			maxOfThisPiece = stack[len(stack)-1]
			for len(stack) != 0 && arr[i] < stack[len(stack)-1] {
				stack = stack[:len(stack)-1]
			}
		}
		stack = append(stack, max(maxOfThisPiece, arr[i]))
	}
	return len(stack)
}

//以下思路完全错误
////本题简单的地方在于arr中的每一个元素都不相同，于是可以采用最原始的大顶栈
//func maxChunksToSorted00(arr []int) int {
//	var stack []int
//	for i := 0; i < len(arr); i++ {
//		for len(stack) != 0 && arr[i] < stack[len(stack)-1] {
//			stack = stack[:len(stack)-1]
//		}
//		stack = append(stack, arr[i])
//	}
//	return len(stack)
//}
