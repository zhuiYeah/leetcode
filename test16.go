package main

//func isPalindrome(s string) bool {
//	x := true
//	s = delete(s, " ")
//	s = delete(s, ",")
//	s = delete(s, ":")
//	s = delete(s, ".")
//	s = delete(s, "@")
//	s = delete(s, "#")
//	s = delete(s, "_")
//	s = delete(s, "\\")
//	s = delete(s, "[")
//	s = delete(s, "]")
//	s = delete(s, "{")
//	s = delete(s, "}")
//	s = delete(s, "'")
//	s = delete(s, "\"")
//	s = delete(s, "-")
//	s = delete(s, "?")
//	s = delete(s, ";")
//	s = delete(s, "!")
//	s = delete(s, "(")
//	s = delete(s, ")")
//	s = delete(s, "`")
//
//	s = strings.ToLower(s)
//	for i := 0; i < len(s)/2; i++ {
//		if s[i] != s[len(s)-1-i] {
//			x = false
//			break
//		}
//	}
//	return x
//}
//
//func delete(s string, sub string) string {
//	for strings.Index(s, sub) != -1 {
//		index := strings.Index(s, sub)
//		s = s[0:index] + s[index+1:]
//	}
//	return s
//}
//func main() {
//	s := "A man, a plan, a canal: Panama"
//	println(isPalindrome(s))
//
//}
