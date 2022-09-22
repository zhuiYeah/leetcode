package 数组

import "math/bits"

//给出x与y两个正整数的汉明距离
func hammingDistance(x, y int) int {
	return bits.OnesCount(uint(x ^ y))
}
