package 栈和队列

type CQueue struct {
	stackIn  []int
	stackOut []int
}

func Constructor0() CQueue {
	return CQueue{nil, nil}
}

func (this *CQueue) AppendTail(value int) {
	this.stackIn = append(this.stackIn, value)
}

func (this *CQueue) DeleteHead() int {
	if len(this.stackOut) == 0 && len(this.stackIn) == 0 {
		return -1
	}
	if len(this.stackIn) != 0 && len(this.stackOut) == 0 {
		for len(this.stackIn) != 0 {
			this.stackOut = append(this.stackOut, this.stackIn[len(this.stackIn)-1])
			this.stackIn = append(this.stackIn[:len(this.stackIn)-1], this.stackIn[len(this.stackIn):]...)
		}
	}
	x := this.stackOut[len(this.stackOut)-1]
	this.stackOut = this.stackOut[:len(this.stackOut)-1]
	return x
}

func main() {
	queue := Constructor0()
	queue.AppendTail(123)
	queue.DeleteHead()
}
