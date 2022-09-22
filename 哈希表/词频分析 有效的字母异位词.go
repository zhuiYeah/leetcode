package 哈希表

//判断两个字母是否为字母异位置词，除了用hashmap，本题还可以用长为26的数组进行词频分析
func isAnagram0(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	characterAppears := map[byte]int{}
	for i := 0; i < len(s); i++ {
		characterAppears[s[i]]++
	}
	for i := 0; i < len(t); i++ {
		characterAppears[t[i]]--
	}
	for _, v := range characterAppears {
		if v != 0 {
			return false
		}
	}
	return true
}

//词频分析
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	fres := [26]int{}
	fret := [26]int{}
	for i := 0; i < len(s); i++ {
		fres[s[i]-'a']++
		fret[t[i]-'a']++
	}
	if compare(fres, fret) {
		return true
	} else {
		return false
	}
}

func compare(A, B [26]int) bool {
	for i := 0; i < len(A); i++ {
		if A[i] != B[i] {
			return false
		}
	}
	return true
}
