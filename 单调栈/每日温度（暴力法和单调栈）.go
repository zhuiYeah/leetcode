package 单调栈

import "fmt"

//暴力
func dailyTemperatures0(temperatures []int) []int {

	var res []int
	for today := 0; today < len(temperatures)-1; today++ {
		for future := today + 1; future < len(temperatures); future++ {
			if temperatures[future] > temperatures[today] {
				res = append(res, future-today)
				break
			}
			if future == len(temperatures)-1 && temperatures[future] <= temperatures[today] {
				res = append(res, 0)
			}
		}
	}
	res = append(res, 0)
	return res
}

//为什么是一个单调减少栈而不是单调增加栈？ 因为要找后续的更大的元素，当大元素出现在栈顶时，小的栈底部元素都要出栈（被处理），我们由此回溯到了要预测的日期
//通过单调栈的入栈和出栈迅速找到 数组中第一个比当前元素大的元素  （维护一个单调减少栈）
func dailyTemperatures(temperatures []int) []int {
	stack := Stack{[]int{0}}
	res := make([]int, len(temperatures))
	for i := 1; i < len(temperatures); i++ {
		for len(stack.stack) != 0 && temperatures[i] > temperatures[stack.Top()] { //维护单调减少栈
			res[stack.Top()] = i - stack.Top()
			stack.Pop()
		}
		stack.Push(i)
	}
	return res
}

func main() {
	//s := Stack{[]int{0, 1}}
	//s.Pop()
	//println(len(s.stack))
	s := []int{73, 74, 75, 71, 69, 72, 76, 73}
	fmt.Printf("%v\n", dailyTemperatures(s))
}
