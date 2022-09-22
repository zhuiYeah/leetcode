package 字符串

import "strings"

func reverseWords(s string) string {
	strings.Trim(s, " ")
	s += " " //加一个空格是为了能取到最后一个单词
	res := ""
	start := 0 //指向一个单词的第一个字符
	for i := 1; i < len(s); i++ {
		if s[i] == ' ' && s[i-1] != ' ' { //此时i是一个字符串的终点位置（开区间不取i）
			res = " " + s[start:i] + res
		} else if s[i] != ' ' && s[i-1] == ' ' { //（此时i是一个字符串的开始位置，更新start指针）
			start = i
		}
	}
	return res[1:]
}
