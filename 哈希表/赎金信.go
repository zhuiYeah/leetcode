package 哈希表

func canConstruct(ransomNote string, magazine string) bool {
	m := map[byte]int{} //key:杂志中的字符串  value:这个字符串在杂志中出现的次数
	for i := 0; i < len(magazine); i++ {
		m[magazine[i]]++
	}
	for i := 0; i < len(ransomNote); i++ {
		if m[ransomNote[i]] == 0 {
			return false
		} else {
			m[ransomNote[i]]--
		}
	}
	return true
}

//被自己一个月前写的代码教做人😭😭😭
func canConstruct0(ransomNote string, magazine string) bool {
	m := map[uint8]int{} //int表示ransomNote中出现某字符的次数
	for i := 0; i < len(ransomNote); i++ {
		m[ransomNote[i]]++
	}
	for i := 0; i < len(magazine) && len(m) != 0; i++ {
		if m[magazine[i]] != 0 { //匹配到哈希表中存在的元素，删掉该元素，代表匹配掉一个字符
			if m[magazine[i]] == 1 {
				delete(m, magazine[i]) //删除哈希表中的一个键值对
			} else {
				m[magazine[i]]-- //注意到--和delete的区别
			}
		}
	}

	if len(m) == 0 {
		return true
	} else {
		return false
	}

}
