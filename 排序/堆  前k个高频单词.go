package 排序

import "fmt"

func topKFrequent3(words []string, k int) []string {
	frequent := map[string]int{}
	for i := 0; i < len(words); i++ {
		frequent[words[i]]++
	}
	var heap []string //用数组模拟小顶堆，堆顶的就是第k大的
	var up func([]string)
	var down func([]string)
	up = func(heap []string) {
		i := len(heap) - 1
		for i > 0 {
			father := (i - 1) / 2
			if frequent[heap[i]] < frequent[heap[father]] || frequent[heap[i]] == frequent[heap[father]] && heap[i] < heap[father] {
				heap[i], heap[father] = heap[father], heap[i]
				i = father
			} else {
				break
			}
		}
	}

	down = func(heap []string) {
		i := 0
		for 2*i+1 < len(heap) { //左子节点存在才能下沉啊！
			son := 2*i + 1
			if son+1 < len(heap) && (frequent[heap[son+1]] > frequent[heap[son]] || frequent[heap[son+1]] > frequent[heap[son]] && heap[son+1] < heap[son]) {
				son++
			}
			if frequent[heap[i]] > frequent[heap[son]] || frequent[heap[i]] == frequent[heap[son]] && heap[i] > heap[son] {
				heap[i], heap[son] = heap[son], heap[i]
				i = son
			} else {
				break
			}
		}
	}

	for word, freq := range frequent {
		if len(heap) < k {
			heap = append(heap, word)
			up(heap)
		} else if freq > frequent[heap[0]] || (freq == frequent[heap[0]] && word < heap[0]) {
			heap[0] = word
			down(heap)
		}
	}

	return heap
}

func main() {
	words := []string{"i", "love", "leetcode", "i", "love", "coding"}
	fmt.Printf("%v\n", topKFrequent3(words, 3))
}
