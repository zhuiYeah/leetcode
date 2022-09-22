package 链表

//有点难度 ， 纯自己完成
func insertionSortList(head *ListNode) *ListNode {
	fakeHead := &ListNode{-1231, head}
	end := head //end之前的节点包含自身已经完成排序
	tmp := fakeHead.Next.Next
	for tmp != nil {
		//判断tmp指针指向的元素是否需要重新排列
		if tmp.Val >= end.Val { //不需要，end 后面 是tmp ，正好是升序的
			end = end.Next //完成tmp的排序
			tmp = tmp.Next //下一个元素
		} else { //需要重排了
			end.Next = tmp.Next
			for insert := fakeHead; insert != end; insert = insert.Next {
				if insert.Next.Val >= tmp.Val { //找到插入位置了，插入在inset之后
					tmp.Next = insert.Next //tmp插入在insert之后
					insert.Next = tmp      //tmp插入在insert之后
					tmp = end.Next         //新的tmp，当然永远在end后面
					break
				}
			}
		}

	}
	return fakeHead.Next
}
