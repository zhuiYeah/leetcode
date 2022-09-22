package main

import (
	"math"
)

type MinStack struct {
	list     []int
	minStack []int //需要保持这个栈顶部的元素为list内最小元素，并且list发生出栈的时候，它也要出掉相应的元素（或者不相应的重复最小的元素）
}

func Constructor00() MinStack {
	return MinStack{[]int{}, []int{math.MaxInt}}
}

func (this *MinStack) Push(val int) { //入栈
	this.list = append(this.list, val)
	top := this.minStack[len(this.minStack)-1]
	this.minStack = append(this.minStack, min(top, val))
}

func (this *MinStack) Pop() { //出栈
	if len(this.list) == 0 {
		return
	}
	//top := this.minStack[len(this.minStack)-1]
	this.list = this.list[:len(this.list)-1]
	this.minStack = this.minStack[:len(this.minStack)-1]

}

func (this *MinStack) Top() int { //获得顶部元素
	return this.list[len(this.list)-1]
}

func (this *MinStack) GetMin() int {
	if len(this.minStack) == 1 {
		return -math.MaxInt
	}
	return this.minStack[len(this.minStack)-1]
}

//func main() {
//	stack := Constructor()
//	stack.Push(-2)
//	stack.Push(0)
//	stack.Push(-3)
//	stack.GetMin()
//
//}
