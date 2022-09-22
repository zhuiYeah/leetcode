package main

import "fmt"

func strStr(haystack string, needle string) int {

	n := len(needle)
	m := -1
	for i := 0; i < len(haystack)-n+1; i++ {
		if haystack[i:i+n] == needle {
			m = i
			break
		}
	}
	return m

	//strings.Index(haystack, needle)
}

func main() {
	a := []int{1, 2, 3, 4, 5}
	a = append(a, 0) //先把原来的切片长度+1
	//要把新元素插入到第二个位置
	copy(a[2+1:], a[2:])
	a[2] = 0 //新元素的值是0

	fmt.Printf("%v\n", a)

}
