package 排序

//import (
//	"container/heap"
//	"sort"
//)
//
//type KthLargest struct {
//	sort.IntSlice
//	k int
//}
//
//func Constructor6(k int, nums []int) KthLargest {
//	kl := KthLargest{nil, k}
//	for _, val := range nums {
//		kl.add(val)
//	}
//	return kl
//}
//
//func (kl *KthLargest) Push(v interface{}) {
//	kl.IntSlice = append(kl.IntSlice, v.(int))
//}
//
//func (kl *KthLargest) Pop() interface{} {
//	a := kl.IntSlice
//	v := a[len(a)-1]
//	kl.IntSlice = a[:len(a)-1]
//	return v
//}
//
//func (kl *KthLargest) add(val int) int {
//	heap.Push(kl, val)
//	if kl.Len() > kl.k {
//		heap.Pop(kl)
//	}
//	return kl.IntSlice[0]
//}
//
//func main() {
//	kthLargest := Constructor5(3, []int{4, 5, 8, 2})
//	println(kthLargest.add(3))
//	println(kthLargest.add(5))
//	println(kthLargest.add(10))
//	println(kthLargest.add(9))
//	println(kthLargest.add(4))
//}
