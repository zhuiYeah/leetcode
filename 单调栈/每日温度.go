package 单调栈

//单调栈：通常是一维数组，要
//寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
//单调栈的本质是空间换时间

func dailyTemperatures00(temperatures []int) []int {
	res := make([]int, len(temperatures))
	var stack []int
	stack = append(stack, 0)
	//这是一个小顶栈，新入栈的温度要比之前的温度小，如果大于的话，立刻弹出栈中比新入栈的温度都要小的温度
	for i := 1; i < len(temperatures); i++ {
		for len(stack) != 0 && temperatures[i] > temperatures[stack[len(stack)-1]] {
			end := len(stack) - 1 //stack中的最后一个元素的下标
			res[stack[end]] = i - stack[end]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	return res
}
