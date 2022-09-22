package 字符串

//找出words中所有能作为其他单词子字符串的单词
func stringMatching(words []string) []string {
	var res []string
	var next [][]int //next[i]表示第i个单词的前缀表
	for i := 0; i < len(words); i++ {
		next = append(next, getNext(words[i]))
	} //已得到所有单词前缀表
	for i := 0; i < len(words); i++ { //words[i]能否作为其他任意一个字符串的子串
		for j := 0; j < len(words); j++ {
			if j == i {
				continue
			}
			if match(words[i], words[j], next[i]) {
				res = append(res, words[i])
				break
			}
		}
	}

	return res
}

func match(s, t string, next []int) bool { //s是模式串，t是文本串 ，判断s是否是t的子串
	if len(s) > len(t) {
		return false
	}
	j := 0                        //j目前指向模式串的首地址
	for i := 0; i < len(t); i++ { //i表示文本串的当前位置
		for j > 0 && t[i] != s[j] { //字符不匹配的情况
			j = next[j-1]
		}
		if s[j] == t[i] { //字符匹配的情况
			j++
		}
		if j == len(s) {
			return true
		}
	}
	return false
}

func getNext(s string) []int { //得到一个字符串的前缀表
	next := make([]int, len(s))
	next[0] = 0
	j, i := 0, 1 //j表示前缀的最后一位，i表示后缀的最后一位
	for ; i < len(s); i++ {
		for j > 0 && s[j] != s[i] { //字符不匹配的情况
			j = next[j-1]
		}
		if s[i] == s[j] { //字符匹配的情况
			j++
		}
		next[i] = j
	}
	return next
}
