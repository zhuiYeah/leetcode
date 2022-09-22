package 动态规划

import "strconv"

//0～25 都可以翻译成唯一字符，那么一个数字num一共有多少种翻译方法
func translateNum(num int) int {
	s := strconv.Itoa(num)
	dp := make([]int, len(s))
	dpHelp := make([]int, len(s))
	//dp[i]:当前字符串的下标为i，那么目前字符串左闭右闭[0:i]一共有dp[i]种翻译方法
	//dpHelp[i]:当前字符串的下标为i，那么当前在dp[i]种翻译方法中，有dpHelp[i]种翻译方法的最后一位翻译是直接取s[i]的 而没有与之前的字符串结合翻译
	//如果说s[i]和s[i-1]能进行组合翻译的话，dp[i]=dp[i-1]+dpHelp[i-1] ;
	//如果s[i]只能单独翻译，而不能与s[i-1]进行组合翻译，dp[i]=dp[i-1]
	//任何情况下，dpHelp[i]=dp[i-1]   当前[0:i]的单翻译方法总数，永远等于[0:i-1]的总翻译方法数 （永远单翻译就是在前一层的基础上增加s[i]）
	dp[0], dpHelp[0] = 1, 1
	for i := 1; i < len(s); i++ {
		dpHelp[i] = dp[i-1]
		if s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '0' && s[i] <= '5') {
			dp[i] = dp[i-1] + dpHelp[i-1]
		} else {
			dp[i] = dp[i-1]
		}
	}
	return dp[len(s)-1]
}

//空间优化 ，空间优化没卵用，本来两个dp数组只占据很小的空间O（1）
func translateNum0(num int) int {
	s := strconv.Itoa(num)
	dp := make([]int, 2) //当前处于s[i],一共有dp[0]种翻译方法，dp[1]种最后一字符非组合翻译方法
	dp[0], dp[1] = 1, 1
	for i := 1; i < len(s); i++ {
		tmp := dp[0]
		if s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '0' && s[i] <= '5') {
			dp[0] = dp[0] + dp[1]
		}
		dp[1] = tmp
	}
	return dp[0]
}
