package 哈希表

func isHappy(n int) bool {
	seen := map[int]bool{}
	for n != 1 && !seen[n] {
		seen[n] = true
		n = dwsfcewvew(n)
	}
	return n == 1
}

func dwsfcewvew(n int) int {
	sum := 0
	for n > 0 {
		sum += (n % 10) * (n % 10)
		n /= 10
	}
	return sum
}
