package 回溯

import "sort"

type pair struct {
	destination string
	visited     bool
}

type pairs []*pair //一个指针数组，指向pair类型的指针

func (p pairs) Len() int {
	return len(p)
}
func (p pairs) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p pairs) Less(i, j int) bool {
	return p[i].destination < p[j].destination
}

func findItinerary(tickets [][]string) []string {
	var res []string
	res = append(res, "JFK")
	AllAirportsThatThisAirportCanVisit := map[string]pairs{} //出发地 对应 所有的目的地

	//遍历所有机票，初始化这个hash表
	for i := 0; i < len(tickets); i++ {
		//tickets[i]表示第i张机票 ， tickets[i][0]表示第i张机票的出发地,tickets[i][1]代表第i张机票的目的地
		if AllAirportsThatThisAirportCanVisit[tickets[i][0]] == nil {
			AllAirportsThatThisAirportCanVisit[tickets[i][0]] = make(pairs, 0)
		}
		AllAirportsThatThisAirportCanVisit[tickets[i][0]] = append(AllAirportsThatThisAirportCanVisit[tickets[i][0]], &pair{tickets[i][1], false})
	}

	for k, _ := range AllAirportsThatThisAirportCanVisit {
		sort.Sort(AllAirportsThatThisAirportCanVisit[k]) //对pairs数组进行排序，调用库函数的时候需要自定义Len Swap Less接口。
	}

	var backtracking func() bool //如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。
	backtracking = func() bool {
		if len(res) == len(tickets)+1 { //行程数等于机票数加了，表示以及到达叶子节点，找到了一条路线了
			return true
		}
		for _, v := range AllAirportsThatThisAirportCanVisit[res[len(res)-1]] { //取出起飞航班对应的所有目的地

			//v是当前所在地能飞去的所有地点之一
			if v.visited == false {
				res = append(res, v.destination)
				v.visited = true
			} else {
				continue
			}

			//当前节点是否以及到达叶子节点？
			if backtracking() {
				return true
			}

			//回溯
			res = res[:len(res)-1]
			v.visited = false
		}
		return false
	}

	backtracking()

	return res
}
