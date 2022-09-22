package main

//栈
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

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

//对[]byte切片的排序
type sortBytes []byte

func (p sortBytes) Len() int {
	return len(p)
}
func (p sortBytes) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p sortBytes) Less(i, j int) bool {
	return p[i] < p[j]
}
