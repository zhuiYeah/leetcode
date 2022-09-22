package 单调栈

type Stack struct {
	stack []int
}

func (s *Stack) Top() int {
	return s.stack[len(s.stack)-1]
}
func (s *Stack) Pop() {
	s.stack = append(s.stack[:len(s.stack)-1], s.stack[len(s.stack):]...)
}
func (s *Stack) Push(val int) {
	s.stack = append(s.stack, val)
}
func (s *Stack) isEmpty() bool {
	return len(s.stack) == 0
}

//在维护一个 小顶栈 的过程中计算出雨水的总量
func trap(height []int) int {
	var sum int
	index := &Stack{[]int{0}} //index栈储存height数组中元素的下标
	for i := 1; i < len(height); i++ {
		for !index.isEmpty() && height[i] >= height[index.Top()] {
			mid := index.Top()
			index.Pop()
			if height[i] == height[mid] {
				continue
			}
			if height[i] > height[mid] && !index.isEmpty() {
				h := min(height[i], height[index.Top()])
				w := i - index.Top() - 1
				sum += h * w
			}
		}
		index.Push(i)
	}
	return sum
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
