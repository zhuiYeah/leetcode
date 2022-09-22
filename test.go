package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type NodeX struct {
	Val         int
	subordinate []*NodeX
}

func main() {
	path := "1234"
	fmt.Printf("%v\n", path[0]-'0')
}
