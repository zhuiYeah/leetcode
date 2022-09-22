package 字符串

//没啥意思
func replaceSpace(s string) string {
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			s = s[:i] + "%20" + s[i+1:]
			i += 2
		}
	}
	return s
}
