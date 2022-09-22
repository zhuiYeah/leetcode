package 回溯

import "fmt"

func letterCombinations(digits string) []string {
	letter := map[string]string{
		"2": "abc",
		"3": "def", "4": "ghi",
		"5": "jkl", "6": "mno",
		"7": "pqrs",
		"8": "tuv",
		"9": "wxyz",
	}
	var res []string
	if len(digits) == 0 {
		return res
	}
	var backtracking func(index int, path string)
	backtracking = func(index int, path string) {

		if len(path) == len(digits) { //到达叶子结点
			res = append(res, path)
			return
		}

		//本题不存在剪枝

		for i := 0; i < len(letter[string(digits[index])]); i++ {
			x := letter[string(digits[index])]
			//对当前节点 "abc"中"a"的处理
			path += string(x[i])

			//是否达到叶子节点？是否需要回溯？  是：进行下一步回溯  否：进入递归深度搜索，扩充path的长度
			backtracking(index+1, path)

			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0, "")
	return res
}

func main() {
	letter := map[string]string{
		"2": "abc",
		"3": "def", "4": "ghi",
		"5": "jkl", "6": "mno",
		"7": "pqrs",
		"8": "tuv",
		"9": "wxyz",
	}
	fmt.Printf("%v\n", letter["9"])
	x := letter["9"]
	x = x[:len(x)-1]
	fmt.Printf("%v\n", x)

	letterCombinations("23")
}
