package main

func addTwoNumbers0(l1 *ListNode, l2 *ListNode) (head *ListNode) {
	tail := head   //尾巴指针先指向头指针，头指针此时为空
	carry := 0     // 进位初始化为0
	n1, n2 := 0, 0 //n1,n2用作储存l1和l2指向节点的值
	sum := 0
	for l1 != nil || l2 != nil { //只要l1或l2任意一个没加完就要加
		if l1 != nil { //为什么不直接加上l1.Val呢？ 因为l1为非空指针的时候，l2可能是空指针
			n1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			n2 = l2.Val
			l2 = l2.Next
		}
		sum = n1 + n2 + carry
		carry = sum / 10
		sum = sum % 10

		if head == nil { //第一次进入for循环时head必定是nil
			head = &ListNode{Val: sum} //给head指针指向一节点并分配空间
			tail = head                //为什么不能tail=head.Next呢？好好思考下，这样的话无法让tail作为head.Next
		} else { //此后的每一次循环head都不为空了
			tail.Next = &ListNode{Val: sum}
			tail = tail.Next
		}
	}

	if carry > 0 { //l1 l2都为空指针是，如果还有进位的话，在为尾节点加上一个尾巴结点，写入进位
		tail.Next = &ListNode{Val: carry}
	}
	return head
}
