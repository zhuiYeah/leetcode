package 哈希表

//const base = 35
//
//type MyHashSet struct {
//	data []list.List
//}
//
//func Constructor2() MyHashSet {
//	return MyHashSet{make([]list.List, base)}
//}
//
//func hash(key int) int {
//	return key % base
//}
//
//func (this *MyHashSet) Add(key int) {
//	if this.Contains(key) == false {
//		hashValue := hash(key)
//		this.data[hashValue].PushBack(key)
//	}
//}
//
//func (this *MyHashSet) Remove(key int) {
//	hashValue := hash(key)
//	for i := this.data[hashValue].Front(); i != nil; i = i.Next() {
//		if i.Value.(int) == key {
//			this.data[hashValue].Remove(i) //移除链表
//		}
//	}
//}
//
//func (this *MyHashSet) Contains(key int) bool {
//	hashValue := hash(key)
//	for i := this.data[hashValue].Front(); i != nil; i = i.Next() { //理解哈希表的查找方法 ， hash匹配函数
//		if i.Value.(int) == key {
//			return true
//		}
//	}
//	return false
//}
