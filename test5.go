package main

import (
	"fmt"
	"sort"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	for _, v := range nums2 {
		nums1 = append(nums1, v)
	}
	sort.Ints(nums1) //由小到大排序nums1中的元素
	n := len(nums1)

	if n%2 == 0 {
		return (float64(nums1[n/2]) + float64(nums1[(n/2)-1])) / 2
	} else {
		return float64(nums1[n/2])
	}
}
func main() {
	a := []int{3, 2, 1, 4, 2, 6, 15}
	b := []int{3, 22, 1, 3, 4, 4}
	//sort.Ints(a)
	copy(a, b)
	fmt.Printf("%v\n", a)

}
