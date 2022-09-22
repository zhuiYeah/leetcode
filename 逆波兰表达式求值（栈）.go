package main

import "strconv"

func evalRPN(tokens []string) int {
	stack := []int{}
	for i := 0; i < len(tokens); i++ {
		if tokens[i] == "/" || tokens[i] == "*" || tokens[i] == "+" || tokens[i] == "-" {
			num2 := stack[len(stack)-1]                                 //栈顶元素
			num1 := stack[len(stack)-2]                                 //栈第二个元素
			stack = append(stack[:len(stack)-2], stack[len(stack):]...) //栈弹出两个元素
			switch tokens[i] {
			case "/":
				stack = append(stack, num1/num2)
			case "*":
				stack = append(stack, num1*num2)
			case "+":
				stack = append(stack, num1+num2)
			case "-":
				stack = append(stack, num1-num2)
			}
		} else {
			n, _ := strconv.Atoi(tokens[i])
			stack = append(stack, n)
		}
	}
	return stack[0]
}

func main() {

}
