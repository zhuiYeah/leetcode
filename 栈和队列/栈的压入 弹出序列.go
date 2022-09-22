package 栈和队列

//模拟栈的压入弹出全过程
func validateStackSequences(pushed []int, popped []int) bool {
	if len(pushed) == 0 {
		return true
	}
	p, q := 0, 0
	stack := []int{pushed[0]}
	p++
	for p < len(pushed) {
		for len(stack) != 0 && popped[q] == stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
			q++
		}
		stack = append(stack, pushed[p])
		p++
	}
	//当p==len(push)时，表明栈的压入已经全部完成，但栈的弹出可能还没有完成
	for len(stack) != 0 && popped[q] == stack[len(stack)-1] {
		stack = stack[:len(stack)-1]
		q++
	}
	if len(stack) == 0 {
		return true
	} else {
		return false
	}
}
