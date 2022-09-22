package 哈希表

//给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。那么多少步可以让s和t构成字母异位词
func minSteps0(s string, t string) int {
	freS := make([]int, 26)
	freT := make([]int, 26)
	for i := 0; i < len(s); i++ {
		freS[s[i]-'a']++
	}
	for i := 0; i < len(t); i++ {
		freT[t[i]-'a']++
	}
	res := 0
	for i := 0; i < 26; i++ {
		res += abs(freS[i] - freT[i])
	}
	return res
}
