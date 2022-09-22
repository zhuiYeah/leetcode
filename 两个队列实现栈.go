package main

type MyStack struct {
	queue1 []int //任何时刻，空的队列作为输入队列，之后将另一个非空队列的元素全部弹出到空队列后面
	queue2 []int
}

func Constructor1() MyStack {
	return MyStack{}
}

func (this *MyStack) Push(x int) {
	if len(this.queue1) == 0 {
		this.queue1 = append(this.queue1, x)
		for len(this.queue2) != 0 {
			this.queue1 = append(this.queue1, this.queue2[0])
			this.queue2 = this.queue2[1:]
		}
		return
	}
	if len(this.queue2) == 0 {
		this.queue2 = append(this.queue2, x)
		for len(this.queue1) != 0 {
			this.queue2 = append(this.queue2, this.queue1[0])
			this.queue1 = this.queue1[1:]
		}
	}

}

func (this *MyStack) Pop() int {
	if len(this.queue1) == 0 {
		x := this.queue2[0]
		this.queue2 = this.queue2[1:]
		return x
	} else {
		x := this.queue1[0]
		this.queue1 = this.queue1[1:]
		return x
	}

}

func (this *MyStack) Top() int {
	if len(this.queue1) == 0 {
		return this.queue2[0]
	} else {
		return this.queue1[0]
	}

}

func (this *MyStack) Empty() bool {
	return len(this.queue2) == 0 && len(this.queue1) == 0
}
