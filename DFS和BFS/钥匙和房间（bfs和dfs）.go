package DFS和BFS

//bfs
func canVisitAllRooms(rooms [][]int) bool {
	queue := []int{0}         //第0个房间的钥匙先写入队列
	visited := map[int]bool{} //记录已经去过的房间
	for len(queue) != 0 {
		currentVisitingRoom := queue[0]
		queue = queue[1:]
		visited[currentVisitingRoom] = true                    //进入队首的房间
		for i := 0; i < len(rooms[currentVisitingRoom]); i++ { //遍历该房间的钥匙，如果发现未去过钥匙对应的房间，则将这把钥匙放入队列
			if !visited[rooms[currentVisitingRoom][i]] {
				queue = append(queue, rooms[currentVisitingRoom][i])
			}
		}

	} //这个for循环结束后，所有能去过的房间都记录在hashmap中

	for i := 0; i < len(rooms); i++ {
		if visited[i] == false { //如果有一个房间没进去过
			return false
		}
	}
	return true
}

//dfs
func canVisitAllRooms0(rooms [][]int) bool {
	visited := make([]bool, len(rooms))

	var dfs func(roomNum int)
	dfs = func(roomNum int) {
		visited[roomNum] = true

		for _, v := range rooms[roomNum] { //for循环的截止就是递归的结束条件
			if visited[v] == false {
				dfs(v)
			}
		}
	}
	dfs(0)
	for _, v := range visited {
		if !v {
			return false
		}
	}
	return true
}

//最新写的
func canVisitAllRooms00(rooms [][]int) bool {
	n := len(rooms)
	visited := make([]bool, n)
	var dfs func(roomNum int)
	dfs = func(roomNum int) {
		//没有边界条件的dfs
		visited[roomNum] = true
		for i := 0; i < len(rooms[roomNum]); i++ {
			if !visited[rooms[roomNum][i]] {
				dfs(rooms[roomNum][i])
			}
		}
	}
	dfs(0)
	for i := 0; i < len(visited); i++ {
		if !visited[i] {
			return false
		}
	}
	return true
}
