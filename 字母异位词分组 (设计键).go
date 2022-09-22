package main

import "sort"

//不同质数的积唯一
func groupAnagrams(strs []string) [][]string {
	lettersToPrime := map[byte]int{ //字母和质数的映射
		'a': 2, 'b': 3, 'c': 5,
		'd': 7, 'e': 11, 'f': 13, 'g': 17, 'h': 19, 'i': 23, 'j': 29, 'k': 31, 'l': 37, 'm': 41, 'n': 43, 'o': 47,
		'p': 53, 'q': 59, 'r': 61, 's': 67, 't': 71, 'u': 73, 'v': 79, 'w': 83, 'x': 89, 'y': 97, 'z': 101,
	}
	seen := map[string]int{} //key：字符串strs【ℹ】，value：唯一表示该同构字符串族的质数积
	for i := 0; i < len(strs); i++ {
		b := []byte(strs[i])
		product := 1
		for j := 0; j < len(b); j++ {
			product *= lettersToPrime[b[j]]
		}
		seen[strs[i]] = product
	}

	hang := map[int]int{} //key:质数积，唯一的表示某一组同构字符   value：res的某一行
	i := 0
	for _, value := range seen {
		if _, ok := hang[value]; !ok {
			hang[value] = i
			i++
		}
	}

	res := make([][]string, len(hang)) //hang的键值对个数就是res的总长度
	for i := 0; i < len(strs); i++ {
		res[hang[seen[strs[i]]]] = append(res[hang[seen[strs[i]]]], strs[i])
	}
	return res
}

func main() {
	hang := map[int]int{}
	hang[322] = 0
	hang[342] = 1
	hang[3455] = 2
	println(len(hang))
	s := "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	s1 := "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"

	x := []string{s, s1}
	groupAnagrams(x)

}

//排序后相同的字符必定为同一组字符 map【string】【】string  key：同构字符类型  value：【】string 表示strs中的该族所有同构字符
func groupAnagrams0(strs []string) [][]string {
	mp := map[string][]string{} //key:排序后的字符串，value：排序前的字符串  排序后相同的字符串一定是同构的
	for i := 0; i < len(strs); i++ {
		b := []byte(strs[i])
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		mp[string(b)] = append(mp[string(b)], strs[i])

	}
	res := make([][]string, 0, len(mp)) //hashmap的长度是key的长度，这里的key数量就是异构体种类的数目
	for _, v := range mp {              //这里的v的数据类型是[]string ,
		res = append(res, v)
	}
	return res
}
