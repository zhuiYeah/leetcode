package 回溯

func letterCasePermutation(s string) []string {
	var res []string

	var backtracking func(sPtr int, path []byte)
	backtracking = func(sPtr int, path []byte) {
		if sPtr < len(s) && s[sPtr] >= '0' && s[sPtr] <= '9' {
			sPtr = findAaZz(s, sPtr)
		}
		if sPtr == len(s) {
			res = append(res, string(path))
			return
		}
		for i := 0; i < 2; i++ { //只有两种选择，选择大写或选择小写
			if path[sPtr] >= 'a' && path[sPtr] <= 'z' {
				if i == 1 { //我是小写，但是需要往下传递大写，于是小写转大写
					path[sPtr] -= 32
				}
			} else {
				if i == 0 { //我是大写，但是需要往下传递小写，于是大写转小写
					path[sPtr] += 32
				}
			}
			//
			backtracking(sPtr+1, path)
			//本题的特点在于不需要手动回溯，唯一需要手动回溯的sPtr指针被我当作参数来传递了，
			//path不需要回溯，不需要将path回归修改大小写之前的模样，因为我通过算法实现了当i为0时，必定向下传小写，当i为1时，必定向下传大写
			//之前对path的改动无关紧要
		}
	}
	backtracking(0, []byte(s))
	return res
}

func findAaZz(s string, sPtr int) int {
	for sPtr < len(s) && s[sPtr] >= '0' && s[sPtr] <= '9' {
		sPtr++
	}
	return sPtr
}
