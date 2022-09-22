package 链表

func partition(head *ListNode, x int) *ListNode {

	fakeHead := &ListNode{114514, head}
	insert := fakeHead                              //insert指针后一个位置就是咱们的插入位置
	for insert.Next != nil && insert.Next.Val < x { //找到第一个插入位置
		insert = insert.Next
	}
	for tmp := insert; tmp.Next != nil; { //tmp指针的后一个位置有可能是需要插到前面的位置
		if tmp.Next.Val < x {
			xx := tmp.Next
			tmp.Next = tmp.Next.Next
			xx.Next = insert.Next
			insert.Next = xx
			insert = insert.Next
		} else {
			tmp = tmp.Next
		}
	}
	return fakeHead.Next
}

func ConstructLinkedList(arr []int) *ListNode {
	fakeHead := &ListNode{114514, nil}
	tmp := fakeHead
	for i := 0; i < len(arr); i++ {
		tmp.Next = &ListNode{arr[i], nil}
		tmp = tmp.Next
	}
	return fakeHead.Next
}

func main() {
	head := ConstructLinkedList([]int{1, 4, 3, 2, 5, 2})
	head = partition(head, 3)
}

////这只是对对链表排序的笨方法，并且还是错的
//func partition0(head *ListNode, x int) *ListNode {
//	tmp := head
//	var arr []int
//	for tmp != nil {
//		arr = append(arr, tmp.Val)
//		tmp = tmp.Next
//	}
//	sort.Ints(arr)
//	tmp = head
//	for len(arr) != 0 {
//		tmp.Val = arr[0]
//		arr = arr[1:]
//		tmp = tmp.Next
//	}
//	return head
//}
