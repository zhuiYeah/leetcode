package 栈和队列

type MinStack struct {
	stackReal []int //储存真实的栈中元素
	stackMin  []int //所谓的最小栈,栈顶时刻储存着栈中最小元素
}

func Constructor() MinStack {
	return MinStack{nil, nil}
}

func (this *MinStack) Push(x int) {
	n := len(this.stackReal)
	if n == 0 {
		this.stackMin = append(this.stackMin, x)
		this.stackReal = append(this.stackReal, x)
	} else {
		this.stackReal = append(this.stackReal, x)
		if x < this.stackMin[n-1] {
			this.stackMin = append(this.stackMin, x)
		} else {
			this.stackMin = append(this.stackMin, this.stackMin[n-1])
		}
	}
}

func (this *MinStack) Pop() {
	n := len(this.stackMin)
	this.stackMin = append(this.stackMin[:n-1], this.stackMin[n:]...)
	this.stackReal = append(this.stackReal[:n-1], this.stackReal[n:]...)
}

func (this *MinStack) Top() int {
	return this.stackReal[len(this.stackReal)-1]
}

func (this *MinStack) Min() int {
	return this.stackMin[len(this.stackMin)-1]
}
