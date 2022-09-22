package DFS和BFS

//有0～n-1 共n个员工，其中编号为headID的为老大，manager[i] 是第 i 名员工的直属负责人，第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属
//通知所有员工共需要多少时间

//type NodeX struct {
//	Val         int
//	subordinate []*NodeX
//}

//func numOfMinutes(n int, headID int, manager []int, informTime []int) int {
//	maxTime := 0
//	head := buildRelationshipTree(headID, manager)
//	var dfs func(head *NodeX, curTime int)
//	dfs = func(head *NodeX, curTime int) {
//		if head.subordinate == nil { //叶子节点
//			if curTime > maxTime {
//				maxTime = curTime
//			}
//			return
//		}
//		for i := 0; i < len(head.subordinate); i++ {
//			dfs(head.subordinate[i], curTime+informTime[head.Val])
//		}
//	}
//	dfs(head, 0)
//	return maxTime
//}

//func buildRelationshipTree(headID int, manager []int) *NodeX {
//	head := &NodeX{headID, nil}
//	x := 1 //记录已经写入树结构的员工数量
//	var build func(boss *NodeX)
//	build = func(boss *NodeX) {
//		if x == len(manager) {
//			return
//		}
//		for i := 0; i < len(manager); i++ {
//			if manager[i] == boss.Val {
//				boss.subordinate = append(boss.subordinate, &NodeX{i, nil})
//				x++
//			}
//		}
//		for i := 0; i < len(boss.subordinate); i++ {
//			build(boss.subordinate[i])
//		}
//	}
//	build(head)
//	return head
//}

//上面的被超时玩死了
//之后想到用hashmap记录一个员工的直系下属
func numOfMinutes(n int, headID int, manager []int, informTime []int) int {
	maxTime := 0
	m := map[int][]int{} //key:某员工号码    value:key员工的所有直系下属
	//更新hashmap 即下属对应表
	for i := 0; i < len(manager); i++ {
		m[manager[i]] = append(m[manager[i]], i)
	}
	var dfs func(curID int, curTime int)
	dfs = func(curID int, curTime int) {
		if informTime[curID] == 0 { //叶子节点，到了没有下属的最底层员工了
			if curTime > maxTime {
				maxTime = curTime
			}
			return
		}
		for i := 0; i < len(m[curID]); i++ {
			dfs(m[curID][i], curTime+informTime[curID])
		}
	}
	dfs(headID, 0)
	return maxTime
}
