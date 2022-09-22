package main

type MyQueue struct {
   inStack  []int
   outStack []int
}

func Constructor0() MyQueue {
   return MyQueue{}
}

func (this *MyQueue) Push(x int) {
   this.inStack = append(this.inStack, x)
}

func (this *MyQueue) Pop() int {
   if len(this.outStack) == 0 {
      this.inToOut()
   }
   x := this.outStack[len(this.outStack)-1]
   this.outStack = this.outStack[:len(this.outStack)-1]
   return x
}

func (this *MyQueue) Peek() int {
   if len(this.outStack) == 0 {
      this.inToOut()
   }

   return this.outStack[len(this.outStack)-1]
}

func (this *MyQueue) Empty() bool {
   return len(this.inStack) == 0 && len(this.outStack) == 0
}

func (this *MyQueue) inToOut() {
   for len(this.inStack) != 0 {
      this.outStack = append(this.outStack, this.inStack[len(this.inStack)-1])
      this.inStack = this.inStack[:len(this.inStack)-1]
   }
}

func main() {
   queue := MyQueue{}
   queue.Push(0)
}
