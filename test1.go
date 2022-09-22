package main

//func romanToInt(s string) int {
//	sum := 0
//	if strings.Contains(s, "IV") || strings.Contains(s, "IX") {
//		sum = sum - 2
//	}
//	if strings.Contains(s, "XL") || strings.Contains(s, "XC") {
//		sum -= 20
//	}
//	if strings.Contains(s, "CD") || strings.Contains(s, "CM") {
//		sum -= 200
//	}
//	for i := 0; i < len(s); i++ {
//
//		j := translate(s[i : i+1])
//
//		sum += j
//	}
//
//	return sum
//}
//
//func translate(s string) int {
//	n := 0
//	switch s {
//	case "I":
//		n = 1
//	case "V":
//		n = 5
//	case "X":
//		n = 10
//	case "L":
//		n = 50
//	case "C":
//		n = 100
//	case "D":
//		n = 500
//	case "M":
//		n = 1000
//	}
//
//	return n
//}
//
//func main() {
//	println(romanToInt("III"))
//	println(translate("III"))
//}
