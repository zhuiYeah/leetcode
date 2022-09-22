package 模拟

import "strconv"

// "-1/2+1/2+1/3"="1/3"
//写了很久，最大公约数，最小公倍数
func fractionAddition(expression string) string {
	var molecular []int
	var denominator []int
	start1 := 0 //某一个分子的开始位置
	start2 := 0 //某一个分母的开始位置
	for i := 0; i < len(expression); i++ {
		if expression[i] == '/' { //除号之前是分子
			num, _ := strconv.Atoi(expression[start1:i])
			molecular = append(molecular, num)
			start2 = i + 1 //除号之后是分母
		}
		if expression[i] == '+' || expression[i] == '-' { //运算符之前是分母
			num, _ := strconv.Atoi(expression[start2:i])
			denominator = append(denominator, num)
			start1 = i //运算符之后是分子
		}
		if i == len(expression)-1 { //最后一个分母，他后面没有除号，要单独讨论
			num, _ := strconv.Atoi(expression[start2:len(expression)])
			denominator = append(denominator, num)
		}
	}
	if len(denominator) != len(molecular) { //处理第一个字符是+ -的情况
		denominator = denominator[1:]
	}
	//已经从字符串中提取出分子分母数组了，接下来进行辗转相除计算分母数组的最小公倍数
	LCM := countLCM(denominator) //表示分母数组的最小公倍数
	sumOfMole := 0
	for i := 0; i < len(denominator); i++ {
		multiple := LCM / denominator[i]
		molecular[i] *= multiple
		sumOfMole += molecular[i]
	}
	if sumOfMole == 0 {
		return "0/1"
	}
	tmp := gcd(abs(sumOfMole), LCM) //分子分母的最大公约数
	sumOfMole /= tmp
	LCM /= tmp
	return strconv.Itoa(sumOfMole) + "/" + strconv.Itoa(LCM)
}

func countLCM(nums []int) int { //计算数组的最小公倍数
	LCM := nums[0]
	for i := 1; i < len(nums); i++ {
		GCDofTwoNum := gcd(LCM, nums[i])
		LCM = nums[i] * LCM / GCDofTwoNum
	}
	return LCM
}

func gcd(a, b int) int { //计算两个数的最大公约数
	for a%b != 0 {
		tmp := a % b
		a = b
		b = tmp
	}
	return b
}

func abs(x int) int {
	if x < 0 {
		return -x
	} else {
		return x
	}
}

