package main

import (
	"fmt"
	"strconv"
)

//func addBinary(a string, b string) string {
//	s := []string{}
//	a = Reverse(a)
//	b = Reverse(b)
//	s1 := []byte(a)
//	s2 := []byte(b)
//	n := 0
//	if len(s1) < len(s2) {
//		n = len(s1)
//	} else {
//		n = len(s2)
//	}
//	var x byte = 48
//	for i := 0; i < n; i++ {
//		if s1[i]+s2[i]+x == 48+49+48 {
//			s = append(s, "1")
//			x = 48
//		} else if s1[i]+s2[i]+x == 48+48+48 {
//			s = append(s, "0")
//			x = 48
//		} else if s1[i]+s2[i]+x == 49+49+48 {
//			s = append(s, "0")
//			x = 49
//		} else if s1[i]+s2[i]+x == 49+49+49 {
//			s = append(s, "1")
//			x = 49
//		}
//	}
//	if x == 48 {
//		s = append(s, string(s1[n:]))
//		s = append(s, string(s2[n:]))
//	}
//	for x == 49 {
//		if len(s1) < len(s2) {
//			s2 = append(s2, 0)
//			s2 = append(s2, 0)
//
//			if s2[n]+x == 49+48 {
//				s = append(s, "1")
//				s = append(s, string(s2[n+1:]))
//				x = 48
//			} else if s2[n]+x == 48+48 {
//				s = append(s, "0")
//				s = append(s, string(s2[n+1:]))
//				x = 48
//			} else if s2[n]+x == 49+49 {
//				s = append(s, "1")
//				n++
//			}
//		} else if len(s1) > len(s2) {
//			s1 = append(s1, 0)
//			s1 = append(s1, 0)
//
//			if s1[n]+x == 49+48 {
//				s = append(s, "1")
//				s = append(s, string(s1[n+1:]))
//				x = 48
//			} else if s1[n]+x == 48+48 {
//				s = append(s, "0")
//				s = append(s, string(s1[n+1:]))
//				x = 48
//			} else if s2[n]+x == 49+49 {
//				s = append(s, "1")
//				n++
//			}
//		} else if len(s1) == len(s2) {
//			s = append(s, "1")
//			break
//		}
//	}
//
//	c := strings.Join(s, "")
//	return Reverse(c)
//
//}
//
//func Reverse(s string) string {
//	s1 := []byte(s)
//	n := len(s1)
//	for i := 0; i < n/2; i++ {
//		k := s1[i]
//		s1[i] = s1[n-1-i]
//		s1[n-1-i] = k
//	}
//	fmt.Printf("%v\n", s1[n-1])
//	return string(s1)
//}
//
func main() {
	//s := "hello world"
	//println(Reverse(s))
	//a := "1010"
	//s1 := []byte(a)
	//fmt.Printf("%v\n", s1[4:])
	//	a := "11"
	//	b := "1"
	//	s := addBinary(a, b)
	//	println(s)
	//a := "1233445"
	b := int('0')
	fmt.Printf("%v\n", b)
}

func addBinary(a string, b string) string {
	ans := ""
	lenA, lenB := len(a), len(b)
	carry := 0
	n := max(lenB, lenA)
	for i := 0; i < n; i++ {
		if i < lenA {
			carry += int(a[lenA-i-1] - '0')
		}
		if i < lenB {
			carry += int(a[lenB-i-1] - '0')
		}
		ans = strconv.Itoa(carry%2) + ans
		carry /= 2
	}
	if carry == 1 {
		ans = "1" + ans
	}

	return ans
}
