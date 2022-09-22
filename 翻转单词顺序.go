package main

import (
	"strings"
)

func reverseWords(s string) string {
	s = strings.Trim(s, " ")
	sToRune := []rune(s)
	sToRune = append(sToRune, ' ')
	sToRune = append(sToRune, ' ')

	s = string(sToRune)
	var v string
	count := 0
	for i := 1; i < len(sToRune)-1; i++ {
		if sToRune[i] == ' ' && sToRune[i-1] != ' ' {
			v = " " + s[count:i] + v
			count = i + 1
		}
		if sToRune[i] == ' ' && sToRune[i+1] != ' ' {
			count = i + 1
		}
	}

	return v[1:]
}

func main() {
	s := "   the    baby is cute! "
	println(reverseWords(s))
}
