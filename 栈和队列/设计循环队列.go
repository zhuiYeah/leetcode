package 栈和队列

type MyCircularQueue struct {
	List []int
	Head int
	Tail int
	Size int
}

func Constructor1(k int) MyCircularQueue { //构造器，设置队列长度为 k
	return MyCircularQueue{
		List: make([]int, k+1, k+1), //多出来的这一个容量用来标识队列为空
		Head: 0,
		Tail: 0,
		Size: k,
	}

}

func (this *MyCircularQueue) EnQueue(value int) bool { //向循环队列插入一个元素。如果成功插入则返回真。
	if this.IsFull() == true {
		return false
	}
	if this.IsEmpty() == true { //见图解，队列为空时head也要前进
		this.Head++
	}
	if this.Tail == this.Size { //当tail位于队列最后时
		this.Tail = 1
	} else {
		this.Tail++
	}

	this.List[this.Tail] = value
	return true

}

// DeQueue 先进先出，必须从Head开始删
func (this *MyCircularQueue) DeQueue() bool { //从循环队列中删除一个元素。如果成功删除则返回真。
	if this.IsEmpty() == true {
		return false
	}
	if this.Head == this.Tail {
		this.Head = 0
		this.Tail = 0
		return true
	}
	if this.Head == this.Size {
		this.Head = 1
	} else {
		this.Head++
	}
	return true

}

func (this *MyCircularQueue) Front() int { //从队首获取元素。如果队列为空，返回 -1 。
	if this.IsEmpty() == true {
		return -1
	}
	return this.List[this.Head]
}

func (this *MyCircularQueue) Rear() int { //获取队尾元素。如果队列为空，返回 -1
	if this.IsEmpty() == true {
		return -1
	}
	return this.List[this.Tail]
}

func (this *MyCircularQueue) IsEmpty() bool { //检查循环队列是否为空。
	if this.Head == 0 && this.Tail == 0 {
		return true
	} else {
		return false
	}
}

func (this *MyCircularQueue) IsFull() bool { //检查循环队列是否已满 。
	if this.Head == 0 && this.Tail == 0 {
		return false
	}

	if this.Tail-this.Head+1 == this.Size || this.Tail+1 == this.Head { //当size为1是，head和tail均为0，此时原本应当为空，但判断为full
		return true
	} else {
		return false
	}
}
