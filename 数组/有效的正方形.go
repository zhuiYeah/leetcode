package 数组

//判断p1、p2、p3、p4四个点是否组成严格正方形

func validSquare(p1 []int, p2 []int, p3 []int, p4 []int) bool {

	var isSanJiao func(p1, p2, p3 []int) bool
	isSanJiao = func(p1, p2, p3 []int) bool { //判断是不是等腰直角三角形
		l1 := (p1[0]-p3[0])*(p1[0]-p3[0]) + (p1[1]-p3[1])*(p1[1]-p3[1])
		l2 := (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1])
		l3 := (p2[0]-p3[0])*(p2[0]-p3[0]) + (p2[1]-p3[1])*(p2[1]-p3[1])
		if l1 == 0 || l2 == 0 || l3 == 0 {
			return false
		}
		if l1 == l2 && 2*l2 == l3 {
			return true
		}
		if l1 == l3 && 2*l3 == l2 {
			return true
		}
		if l2 == l3 && 2*l2 == l1 {
			return true
		}
		return false
	}

	return isSanJiao(p1, p2, p3) && isSanJiao(p2, p3, p4) && isSanJiao(p1, p2, p4)
}
