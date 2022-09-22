package 字符串

func reformat(s string) string {
	var byteNum []byte
	var byteStr []byte
	for i := 0; i < len(s); i++ {
		if s[i] >= '0' && s[i] <= '9' {
			byteNum = append(byteNum, s[i])
		} else {
			byteStr = append(byteStr, s[i])
		}
	}
	if abs(len(byteNum)-len(byteStr)) > 1 {
		return ""
	}
	var res []byte
	i, j := 0, 0 //i指向数字，j指向字符
	//选择结果的第一个位置是字符还是数字
	if len(byteNum) > len(byteStr) {
		res = append(res, byteNum[i])
		i++
	} else {
		res = append(res, byteStr[j])
		j++
	}
	//开始移动双指针来填充结果
	for i < len(byteNum) && j < len(byteStr) {
		if res[len(res)-1] >= '0' && res[len(res)-1] <= '9' {
			res = append(res, byteStr[j])
			j++
		} else {
			res = append(res, byteNum[i])
			i++
		}
	}
	for i < len(byteNum) {
		res = append(res, byteNum[i])
		i++
	}
	for j < len(byteStr) {
		res = append(res, byteStr[j])
		j++
	}
	return string(res)
}
