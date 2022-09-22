package 排序

type minHeap struct { //堆中永远只储存所有数据中最大的前k个
	k int //容量
	//用数组模拟一个堆，树状数组
	heap []int //heap数组  heap【0】就是第k大 ，len（heap）被永远限定为k
}

func createMinHead(k int, nums []int) *minHeap {
	heap := &minHeap{k, []int{}}     //创建minHeap
	for i := 0; i < len(nums); i++ { //把nums的数字放进去初始化
		heap.add(nums[i])
	}
	return heap
}

func (this *minHeap) add(num int) { //给miniHeap绑定add方法
	if len(this.heap) < this.k { //heap数组的长度还没达到第k大的要求，heap数组的长度还不够
		this.heap = append(this.heap, num)
		this.up(len(this.heap) - 1) //数组末尾的数上浮到合适的位置
	} else if num > this.heap[0] { //heap数组长度达到k 且 num比堆顶数字要大
		this.heap[0] = num //堆顶的最小的赶紧爬
		this.down(0)       //堆顶新添加的元素下沉到合适的位置
	}
	//如果heap达到k 且 num比堆顶的最小元素还要小或等于，不执行任何操作，因为它影响不到 第k大
}

func (this *minHeap) up(i int) { //将heap【i】上浮至合适的位置
	for i > 0 { //上浮至索引0处就停止上浮
		parent := (i - 1) >> 1                //找到i的父节点在数组中的位置
		if this.heap[i] < this.heap[parent] { //如果父节点的值更大
			this.heap[i], this.heap[parent] = this.heap[parent], this.heap[i] //交换，实现"上浮"
			i = parent
		} else {
			break //i节点>=他的父节点时，完全满足最小堆的性质，停止上浮
		}
	}
}

func (this *minHeap) down(i int) { //将heap[i]下沉到堆中合适的位置
	for 2*i+1 < len(this.heap) { //左子节点的索引如果已经越界，则终止下沉
		child := 2*i + 1

		if child+1 < len(this.heap) && this.heap[child+1] < this.heap[child] { //如果右节点存在且值更小，则用右节点做比较,因为交换的过程中当然上浮更小的值
			child++
		}

		if this.heap[i] > this.heap[child] {
			this.heap[i], this.heap[child] = this.heap[child], this.heap[i]
			i = child
		} else { //子比自己大，满足最小堆的性质，停止下沉
			break
		}
	}
}

type KthLargest struct {
	heap *minHeap
}

func Constructor5(k int, nums []int) KthLargest {
	return KthLargest{createMinHead(k, nums)}
}

func (this *KthLargest) Add(val int) int {
	this.heap.add(val)
	return this.heap.heap[0]
}
