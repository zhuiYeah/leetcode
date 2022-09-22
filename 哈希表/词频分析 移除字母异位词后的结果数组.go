package 哈希表

func removeAnagrams(words []string) []string {
	for i := 1; i < len(words); i++ {
		if isAnagram(words[i], words[i-1]) {
			words = append(words[:i], words[i+1:]...)
			i--
		}
	}
	return words
}
