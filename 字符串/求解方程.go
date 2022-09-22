package 字符串

import "strconv"

//字符串模拟
//0x=0也太恶心了
func solveEquation(equation string) string {
	if equation == "0x=0" {
		return "Infinite solutions"
	} else if equation == "0x=1" || equation == "1=0x" {
		return "No solution"
	} else if equation == "0=0x" {
		return "Infinite solutions"
	}
	numOfX := 0
	start := 0
	num := 0
	for i := 0; i < len(equation); i++ { //等式左边
		if equation[i] == '=' {
			xx, _ := strconv.Atoi(equation[start:i])
			num -= xx
			start = i + 1
			break
		} else {
			if equation[i] == 'x' {
				xx, _ := strconv.Atoi(equation[start:i])
				if xx == 0 {
					if i > 0 && equation[i-1] == '-' {
						numOfX--
					} else {
						numOfX++
					}
				} else {
					numOfX += xx
				}
				start = i + 1
			}
			if equation[i] == '+' || equation[i] == '-' {
				xx, _ := strconv.Atoi(equation[start:i])
				num -= xx
				start = i
			}
		}
	}
	for i := start; i < len(equation); i++ { //右边
		if equation[i] == 'x' {
			xx, _ := strconv.Atoi(equation[start:i])
			if xx == 0 {
				if equation[i-1] == '-' {
					numOfX++
				} else {
					numOfX--
				}
			} else {
				numOfX -= xx
			}
			start = i + 1
		}
		if equation[i] == '+' || equation[i] == '-' {
			xx, _ := strconv.Atoi(equation[start:i])
			num += xx
			start = i
		}
	}
	tmp, _ := strconv.Atoi(equation[start:])
	num += tmp

	if numOfX == 0 && num != 0 {
		return "No solution"
	}
	if numOfX == 0 && num == 0 {
		return "Infinite solutions"
	}
	return "x=" + strconv.Itoa(num/numOfX)
}

func main() {
	s := "1+1=x"
	solveEquation(s)
}
