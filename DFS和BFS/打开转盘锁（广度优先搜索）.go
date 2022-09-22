package DFS和BFS

//type Queue2 struct {
//	List []string
//	Head int
//	Tail int
//}
//
//func (this *Queue2) add(value string) {
//	this.List = append(this.List, "") //每次add需要先将切片扩容1
//	if this.isEmpty() {
//		this.Head++
//		this.Tail++
//		this.List[this.Tail] = value
//	} else {
//		this.Tail++
//		this.List[this.Tail] = value
//	}
//
//}
//
//func (this *Queue2) remove() string {
//	if this.isEmpty() {
//		return ""
//	}
//	value := this.List[this.Head]
//	this.Head++
//	if this.Head > this.Tail { //删掉了队列最后一个元素,将队列置空
//		this.Head = 0
//		this.Tail = 0
//	}
//	return value
//}
//
//func (this *Queue2) isEmpty() bool {
//	if this.Head == 0 && this.Tail == 0 {
//		return true
//	} else {
//		return false
//	}
//}

type statusOfLock struct {
	status string
	step   int
}

func openLock(deadends []string, target string) int {
	initial := statusOfLock{"0000", 0} //初始锁状态为"0000"，0步
	seen := map[string]bool{}          //这个哈希表用于写入已出现的锁的状态
	deadlock := map[string]bool{}
	//将所有的死锁状态写入哈希表deadlock
	for i := 0; i < len(deadends); i++ {
		deadlock[deadends[i]] = true
	}
	if deadlock["0000"] {
		return -1
	}
	queue := []statusOfLock{initial} //初始锁状态写入队列
	for len(queue) > 0 {
		currentState := queue[0] //取出队列之首的锁的状态
		queue = queue[1:]
		statusToBeInvestigated := RotateOneStep(currentState)
		for i := 0; i < 8; i++ {
			if statusToBeInvestigated[i].status == target { //如果8种状态中已经有解锁态
				return statusToBeInvestigated[i].step
			}
			//如果非死锁态 也 非重复态，则将该状态写入seen哈希表 , 同时将该状态写入队列
			if deadlock[statusToBeInvestigated[i].status] == false && seen[statusToBeInvestigated[i].status] == false {
				seen[statusToBeInvestigated[i].status] = true
				queue = append(queue, statusToBeInvestigated[i])
			}
		}
	}
	return -1
}

func RotateOneStep(currentState statusOfLock) []statusOfLock { //锁旋转一步之后，返回8种可能
	stepAfterStep := currentState.step + 1 //旋转一步之后的步数
	var s []statusOfLock
	for i := 0; i < 4; i++ {
		b := []byte(currentState.status)
		b[i]++
		if b[i] > '9' {
			b[i] = '0'
		}
		stateAfterOneStep := statusOfLock{string(b), stepAfterStep}
		s = append(s, stateAfterOneStep)
	}
	for i := 0; i < 4; i++ {
		b := []byte(currentState.status)
		b[i]--
		if b[i] < '0' {
			b[i] = '9'
		}
		stateAfterOneStep := statusOfLock{string(b), stepAfterStep}
		s = append(s, stateAfterOneStep)
	}
	return s
}

func main() {
	//queue := Queue2{[]string{"空标记"}, 0, 0}
	//queue.add("hi")
	//queue.add("3211")
	//queue.add("3223")
	//queue.remove()
	//queue.remove()
	//queue.remove()
	initial := statusOfLock{"0000", 0} //初始锁状态为"0000"，0步
	queue := []statusOfLock{initial}   //初始锁状态写入队列
	println(len(queue))
	s := "0000"
	b := []byte(s)
	b[1]++
	b[0] += 2
	s = string(b)
	println(s)
	//fmt.Printf("%v\n", queue)
}
