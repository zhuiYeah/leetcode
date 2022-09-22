package 栈和队列

type MyCircularDeque struct {
	queue []int
	head  int
	tail  int
}

func Constructor00(k int) MyCircularDeque {
	queue := make([]int, k+1)
	queue[0] = -1
	//head tail同时为0时，循环队列为空
	return MyCircularDeque{queue, 0, 0}
}

func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	if this.head == 0 && this.tail == 0 {
		this.head++
		this.tail++
		this.queue[this.head] = value
	} else if this.head == 1 {
		this.head = len(this.queue) - 1
		this.queue[this.head] = value
	} else {
		this.head--
		this.queue[this.head] = value
	}
	return true
}

func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	if this.head == 0 && this.tail == 0 {
		this.head++
		this.tail++
		this.queue[this.tail] = value
	} else if this.tail == len(this.queue)-1 {
		this.tail = 1
		this.queue[this.tail] = value
	} else {
		this.tail++
		this.queue[this.tail] = value
	}
	return true
}

func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	if this.head == this.tail {
		this.head = 0
		this.tail = 0
		return true
	}
	if this.head == len(this.queue)-1 {
		this.head = 1
		return true
	} else {
		this.head++
		return true
	}
}

func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	if this.head == this.tail {
		this.head = 0
		this.tail = 0
		return true
	}
	if this.tail == 1 {
		this.tail = len(this.queue) - 1
	} else {
		this.tail--
	}
	return true
}

func (this *MyCircularDeque) GetFront() int {

	return this.queue[this.head]
}

func (this *MyCircularDeque) GetRear() int {
	return this.queue[this.tail]
}

func (this *MyCircularDeque) IsEmpty() bool {
	if this.head == 0 && this.tail == 0 {
		return true
	}
	return false

}

func (this *MyCircularDeque) IsFull() bool {
	if this.head == 1 && this.tail == len(this.queue)-1 {
		return true
	}
	if this.head-this.tail == 1 {
		return true
	}
	return false
}
