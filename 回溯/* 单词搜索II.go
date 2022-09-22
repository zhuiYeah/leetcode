package 回溯

func findWords(board [][]byte, words []string) []string {
	var res []string
	tmp := make([][]byte, len(board))
	for i := 0; i < len(tmp); i++ {
		tmp[i] = make([]byte, len(board[0]))
	}
	for i := 0; i < len(words); i++ {
		copy(tmp, board)
		if exist(tmp, words[i]) {
			res = append(res, words[i])
		}
	}
	return res
}

