package 递归

func reversePrint(head *ListNode) []int {
	var res []int
	var help func(head *ListNode)
	help = func(head *ListNode) {
		if head == nil {
			return
		}
		help(head.Next)
		res = append(res, head.Val)
	}
	help(head)
	return res
}
