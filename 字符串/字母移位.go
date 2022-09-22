package 字符串

//用了点后缀和的东西
func shiftingLetters(s string, shifts []int) string {
	for i := len(shifts) - 2; i >= 0; i-- { //后缀和  起
		shifts[i] += shifts[i+1]
	}
	b := []byte(s)
	for i := 0; i < len(b); i++ {
		x := int(b[i]) //x记录当前b[i]的值
		x += shifts[i] //x 是绝对位置，现在x可能比'z'要大非常多
		//现在想要求出x相对于97即'a'的偏移量

		//这里是一个数学游戏
		Offset := (x - 'a') % 26 //offset是相对于'a' 97的偏移量
		b[i] = 'a' + byte(Offset)
	}
	return string(b)
}
