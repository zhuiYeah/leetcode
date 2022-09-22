package 双指针

//给出第n个丑数
func nthUglyNumber(n int) int {
	ugly := []int{1}
	multiplesOf2 := 2
	multiplesOf3 := 3
	multiplesOf5 := 5
	p, q, r := 0, 0, 0 //
	for len(ugly) != n {
		if multiplesOf2 == multiplesOf3 {
			p++
			multiplesOf2 = ugly[p] * 2
			continue
		}
		if multiplesOf2 == multiplesOf5 {
			p++
			multiplesOf2 = ugly[p] * 2
			continue
		}
		if multiplesOf3 == multiplesOf5 {
			q++
			multiplesOf3 = ugly[q] * 3
			continue
		}
		x := min(multiplesOf2, min(multiplesOf3, multiplesOf5))
		ugly = append(ugly, x)
		if x == multiplesOf2 {
			p++
			multiplesOf2 = ugly[p] * 2
		} else if x == multiplesOf3 {
			q++
			multiplesOf3 = ugly[q] * 3
		} else if x == multiplesOf5 {
			r++
			multiplesOf5 = ugly[r] * 5
		}

	}
	return ugly[n-1]
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
