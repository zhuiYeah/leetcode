package 双指针

func isPalindrome(s string) bool {
	i := 0
	j := len(s) - 1
	for {
		if i >= j {
			break
		}
		if !check(s[i]) {
			i++
			continue
		}
		if !check(s[j]) {
			j--
			continue
		}
		if !checkcheck(s[i], s[j]) {
			return false
		}
		i++
		j--
	}
	return true
}

func check(x byte) bool {
	if x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x >= '0' && x <= '9' {
		return true
	} else {
		return false
	}
}

func checkcheck(A, B byte) bool {
	if A == B || A == B+32 || A == B-32 {
		return true
	}
	return false
}
