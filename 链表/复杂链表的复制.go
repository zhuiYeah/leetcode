package 链表

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	//随机指针指向的原始链表的某一个节点
	//对应着新链表的某一个节点
	//所以需要有一个hashmap   key：原始链表的节点   value:新链表的节点
	m := map[*Node]*Node{}
	fakeHead := &Node{114514, nil, nil}
	fake := fakeHead //指向新链表
	p := head        //指向原始链表
	for p != nil {
		fake.Next = &Node{p.Val, nil, nil}
		fake = fake.Next
		m[p] = fake
		p = p.Next

	}
	//到这次已经构建了一个还未更新随机指针的新链表
	p = head
	fake = fakeHead.Next
	for p != nil {
		fake.Random = m[p.Random]
		fake = fake.Next
		p = p.Next
	}
	return fakeHead.Next
}
