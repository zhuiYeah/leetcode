package main

import "math/rand"

type RandomizedSet struct {
	nums    []int
	indices map[int]int // key：元素   value：元素在nums中的下标
}

func Constructor4() RandomizedSet {
	return RandomizedSet{[]int{}, map[int]int{}}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.indices[val]; ok {
		return false
	} else {
		this.indices[val] = len(this.nums)
		this.nums = append(this.nums, val)
		return true
	}
}

//把nums中的最后一个元素移动到要删除元素的下标处，再更新最后一个元素的indice，以及删除要被删除元素的键值对
func (this *RandomizedSet) Remove(val int) bool {
	if index, ok := this.indices[val]; ok {
		last := len(this.nums) - 1            //nums最后一个元素的索引
		this.nums[index] = this.nums[last]    //把最后一个元素的值写入要删除的元素索引位置
		this.indices[this.nums[last]] = index //最后一个元素的索引在hash表中也要更新为index
		this.nums = this.nums[:last]          //删掉最后一个元素
		delete(this.indices, val)             //删掉hashmap中要删除元素的键值对
		return true

	} else {
		return false
	}
}

func (this *RandomizedSet) GetRandom() int {
	return this.nums[rand.Intn(len(this.nums))] //随机种子
}
