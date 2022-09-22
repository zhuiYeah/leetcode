package 字符串

import (
	"math"
	"strconv"
	"strings"
)

func myAtoi(s string) int {
	s = strings.Trim(s, " ")
	b := []byte(s)
	b1 := []byte{}

	for i := 0; i < len(b); i++ {

		if (b[i] >= '0' && b[i] <= '9') || (b[i] == '-' && len(b1) == 0) || (b[i] == '+' && len(b1) == 0) {
			b1 = append(b1, b[i])
		} else {
			break
		}
	}
	s = string(b1)
	v, _ := strconv.Atoi(s)
	if v > math.MaxInt32 {
		v = math.MaxInt32
	} else if v < math.MinInt32 {
		v = math.MinInt32
	}
	return v
}
