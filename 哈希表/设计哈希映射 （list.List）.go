package 哈希表

import "container/list"

const base = 769

type entry struct {
	key, value int
}

type MyHashMap struct {
	data []list.List
}

func Constructor3() MyHashMap {
	return MyHashMap{make([]list.List, base)}

}

func hash(key int) int {
	return key % base
}

func (this *MyHashMap) Put(key int, value int) {
	h := hash(key) //先找到key应该存放的桶，  0<=h<=768
	for i := this.data[h].Front(); i != nil; i = i.Next() {
		if i.Value.(entry).key == key { //如果桶中已经存有key：value对了，则更新键值对
			i.Value = entry{key, value}
			return
		}
	}
	this.data[h].PushBack(entry{key, value}) //如果桶中不存在键值对，则pushBack键值对
}

func (this *MyHashMap) Get(key int) int {
	h := hash(key)
	for i := this.data[h].Front(); i != nil; i = i.Next() {
		if i.Value.(entry).key == key {
			return i.Value.(entry).value
		}
	}
	return -1
}

func (this *MyHashMap) Remove(key int) {
	h := hash(key)
	for i := this.data[h].Front(); i != nil; i = i.Next() {
		if i.Value.(entry).key == key {
			this.data[h].Remove(i)
			return
		}
	}

}
