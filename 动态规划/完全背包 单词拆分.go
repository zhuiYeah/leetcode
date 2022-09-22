package 动态规划

//用单词表填满一个字符串

//完全背包问题 ， 背包容量为len(s)，背包能否被wordDict[]填满
//先物品再背包出现问题
//func wordBreak(s string, wordDict []string) bool {
//	dp := make([]bool, len(s)+1) // dp[j]:字符串s[0:j]，能否被wordDict里面的单词（0～i）填满 //这里我决定先遍历物品，再遍历背包容量
//
//	//当前遍历到单词i，
//	//如果dp[j]已经是true（从0～i-1个单词中任选能够填满背包），则dp[j]不变
//	//如果dp[j]是false（从0～i-1个单词中任选不能够填满背包），
//	//则如果dp[j-单词i的长度]==true && s[j-单词i的长度 ：j]==wordDict[i] ,那么dp[j]为true
//
//	dp[0] = true                         // 空背包当然能被填满
//	for i := 0; i < len(wordDict); i++ { //遍历物品
//		for j := len(wordDict[i]); j <= len(s); j++ { //遍历背包,从背包能放下当前物品的容量开始
//			if dp[j] == false && dp[j-len(wordDict[i])] && s[j-len(wordDict[i]):j] == wordDict[i] {
//				dp[j] = true
//			}
//		}
//	}
//
//	return dp[len(s)]
//}

//先遍历背包 ， 再遍历物品
func wordBreak0(s string, wordDict []string) bool {
	dp := make([]bool, len(s)+1) // dp[i] : 前i个字符能否被单词表中的单词填满

	//如果dp[i-单词j的长度]==true && s[i-单词j的长度 ：j]==wordDict[j] ,那么dp[j]为true

	dp[0] = true                   // 空背包当然能被填满
	for i := 1; i <= len(s); i++ { //先遍历背包
		//当前背包容量为i
		for j := 0; j < len(wordDict); j++ { //再遍历物品
			//对于单词j来说，如果容量i-wordDict[j]的背包能被填满 并且 从那个容量到i的字符串能和单词j完全匹配 ，那么i背包可被填满
			if i >= len(wordDict[j]) { //背包装得下物品j时
				if dp[i-len(wordDict[j])] && s[i-len(wordDict[j]):i] == wordDict[j] {
					dp[i] = true
					break
				}
			}
		}
	}
	return dp[len(s)]
}
