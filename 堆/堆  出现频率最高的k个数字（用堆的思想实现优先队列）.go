package 堆

import "sort"

func topKFrequent(nums []int, k int) []int {
	FrequencyOfOccurrence := map[int]int{}
	for i := 0; i < len(nums); i++ {
		FrequencyOfOccurrence[nums[i]]++
	}

	var up func([]int)
	var down func([]int)
	up = func(heap []int) {
		i := len(heap) - 1
		for i > 0 { //上浮到顶端即停止
			parent := (i - 1) >> 1
			if FrequencyOfOccurrence[heap[i]] < FrequencyOfOccurrence[heap[parent]] {
				heap[i], heap[parent] = heap[parent], heap[i]
				i = parent
			} else {
				break
			}
		}
	}
	down = func(heap []int) {
		i := 0
		for 2*i+1 < len(heap) { //下沉到越界即停止
			child := 2*i + 1                                                                                      //左子节点
			if child+1 < len(heap) && FrequencyOfOccurrence[heap[child+1]] < FrequencyOfOccurrence[heap[child]] { //如果右子节点存在并且右子节点更小
				child++
			}
			if FrequencyOfOccurrence[heap[i]] > FrequencyOfOccurrence[heap[child]] {
				heap[i], heap[child] = heap[child], heap[i]
				i = child
			} else {
				break
			}
		}
	}

	var heap []int //用一个数组模拟堆
	for key, value := range FrequencyOfOccurrence {
		if len(heap) < k {
			heap = append(heap, key)
			up(heap) //将新加入的元素上浮至合适的位置
		} else if value > FrequencyOfOccurrence[heap[0]] {
			heap[0] = key
			down(heap) //将新换的堆顶元素下沉至合适的位置
		}
	}
	return heap
}

//如果把模拟堆heap中的上浮下沉操作直接换做调用库函数对数组的排序
//哈哈哈哈哈 完全错了，因为排序是基于哈希表的value值进行比较的！！！
//方法是自己调用sort.Slice 进行排序 ，自己定义排序规则
func topKFrequent0(nums []int, k int) []int {
	FrequencyOfOccurrence := map[int]int{}
	for i := 0; i < len(nums); i++ {
		FrequencyOfOccurrence[nums[i]]++
	}

	var heap []int //用一个数组模拟堆
	for key, value := range FrequencyOfOccurrence {
		if len(heap) < k {
			heap = append(heap, key)
			sort.Ints(heap)
		} else if value > FrequencyOfOccurrence[heap[0]] {
			heap[0] = key
			sort.Ints(heap)
		}
	}
	return heap
}
