package 哈希表

//s与t长度相同，每次给t中的一个字符换成任意字符，多少步骤可以换成字母异位词
func minSteps(s string, t string) int {
	freS := make([]int, 26)
	freT := make([]int, 26)
	for i := 0; i < len(s); i++ {
		freS[s[i]-'a']++
		freT[t[i]-'a']++
	}
	res := 0
	for i := 0; i < 26; i++ {
		res += abs(freT[i] - freS[i])
	}
	return res / 2
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
