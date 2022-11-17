package main

import (
	"fmt"
	"strconv"
)

func decodeString(s string) string {
	stack := []byte{}
	b := []byte(s)
	var toolABC []byte
	toolInt := []byte{}
	for i := 0; i < len(b); i++ {
		if (b[i] >= '0' && b[i] <= '9') || b[i] == '[' || (b[i] >= 'a' && b[i] <= 'z') {
			stack = append(stack, b[i])
		}
		if b[i] == ']' {
			for stack[len(stack)-1] != '[' {
				toolABC = append(toolABC, '0')
				copy(toolABC[1:], toolABC[:])
				toolABC[0] = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
			stack = stack[:len(stack)-1] //删掉'['
			for len(stack) != 0 && stack[len(stack)-1] >= '0' && stack[len(stack)-1] <= '9' {
				toolInt = append(toolInt, '0')
				copy(toolInt[1:], toolInt)
				toolInt[0] = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
			n, _ := strconv.Atoi(string(toolInt))
			for i := 0; i < n; i++ {
				for j := 0; j < len(toolABC); j++ {
					stack = append(stack, toolABC[j])
				}
			}
			toolInt = nil
			toolABC = nil
		}

	}
	return string(stack)
}

func main() {
	s := "3[a2[c]]"
	fmt.Printf("%v\n", decodeString(s))

}
