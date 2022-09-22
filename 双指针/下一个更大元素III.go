package 双指针

import (
	"math"
	"sort"
	"strconv"
)

type sortBytes []byte

func (p sortBytes) Len() int {
	return len(p)
}
func (p sortBytes) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p sortBytes) Less(i, j int) bool {
	return p[i] < p[j]
}

func nextGreaterElement(n int) int {
	if n/9 == 0 {
		return -1
	}
	yy := []byte(strconv.Itoa(n))
	var b sortBytes
	b = yy
	var indexOfSmallNum int
	for i := len(b) - 1; i > 0; i-- { //找到一个相邻的大数在小数后面的数字对
		if b[i] > b[i-1] {
			indexOfSmallNum = i - 1
			break
		}
		if i == 1 {
			return -1
		}
	}
	indexOfBigNum := indexOfSmallNum + 1
	big := b[indexOfBigNum]
	small := b[indexOfSmallNum]

	for i := indexOfBigNum + 1; i < len(b); i++ { //找到big后面比big更小的大数
		if b[i] < big && b[i] > small {
			big = b[i]
			indexOfBigNum = i
		}
	}
	b[indexOfBigNum], b[indexOfSmallNum] = b[indexOfSmallNum], b[indexOfBigNum]
	sort.Sort(b[indexOfSmallNum+1:])
	res, _ := strconv.Atoi(string(b))
	if res > math.MaxInt32 {
		return -1
	}
	return res
}
