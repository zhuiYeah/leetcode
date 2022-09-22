package main

func reverseList(head *ListNode) *ListNode {
	toolPtr := head
	NewHead := head
	if head == nil {
		return nil
	}
	for head.Next != nil { // head指向1 1->2->3->4                     //head指向1  2->1->3->4      //head永远指向1
		//NewHead=head.Next          // 新头指针指向head.Next 2       //新头指针指向head.Next 3
		toolPtr = head.Next // 工具指针指向 2                   //    工具指针指向3           //工具指针永远指向head.Next

		head.Next = head.Next.Next // 1 - >3 -> 4  (提取出2)          //   2->1->4 （提取出3）

		toolPtr.Next = NewHead // 2 -> 1 -> 3 -> 4 （2写成头）      //   3->2->1->4  （3写成头）            //工具指针这一时刻是链表的头指针

		NewHead = toolPtr //下一个循环，工具指针还要再使用，不再指向头指针 ,用NewHead临时代替头指针

	}
	return NewHead

}
