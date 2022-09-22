package 回溯

import (
	"sort"
)

//通过测试用例：
//186 / 195
func makesquare(matchsticks []int) bool {
	var target int
	for i := 0; i < len(matchsticks); i++ {
		target += matchsticks[i]
	}
	if target%4 != 0 {
		return false
	}
	sort.Sort(sort.Reverse(sort.IntSlice(matchsticks))) //剪枝思路，逆序遍历
	target /= 4
	x := 0 //记录当前符合和为target 的 子集 的 个数
	var backtracking func([]int, int) bool
	backtracking = func(optionalNums []int, currentSum int) bool {
		if currentSum == target {
			x++
			currentSum = 0
		}
		if x == 3 { //叶子节点，找到分割结果啦～ 这里是k减1而不是k 这是一种剪枝思想，数组中剩下的元素和必然为target
			return true
		}

		for i := 0; i < len(optionalNums); i++ {
			//处理节点
			if i > 0 && optionalNums[i] == optionalNums[i-1] { //树层去重
				continue
			}
			if currentSum+optionalNums[i] > target {
				continue
			} else {
				currentSum += optionalNums[i]
			}

			trimmedNums := []int{}
			for j := 0; j < len(optionalNums); j++ {
				if j != i {
					trimmedNums = append(trimmedNums, optionalNums[j])
				}
			}

			//找到一条分割方案了吗？ 如果找到的话一直向上return true，如果没找到的话，回溯
			if backtracking(trimmedNums, currentSum) {
				return true
			}

			//回溯 ,之前取了optionalNums[i]，但是没找到正确的分割方案，现在回溯回来了

			currentSum -= optionalNums[i]

		}
		//遍历完nums都没找到，那么就是没有分割方案了
		return false
	}

	return backtracking(matchsticks, 0)
}

//利用桶 , 每个桶的容量为target，桶的个数为4，必须把桶填满  回溯法的每一层就变成了4个桶 哈哈
func makesquare0(matchsticks []int) bool {
	var target int
	for i := 0; i < len(matchsticks); i++ {
		target += matchsticks[i]
	}
	if target%4 != 0 {
		return false
	}
	target /= 4
	bucket := make([]int, 4)
	for i := 0; i < len(bucket); i++ {
		bucket[i] = target
	}
	sort.Sort(sort.Reverse(sort.IntSlice(matchsticks)))

	var backtracking func(cur int) bool // cur 为当前位置
	backtracking = func(cur int) bool {
		if cur == len(matchsticks) { //叶子节点 //cur走到len（nums）时，所有的数都放进桶里了，一定是ture
			return true
		}

		//将nums[i]放入桶中，如果有多个容量相同的桶，那么只选择其中一个（树层去重）
		HasABucketOfThisCapacityEverAppeared := map[int]bool{}
		for i := 0; i < 4; i++ { //第i个桶
			//两种可能，这个数正好是桶当前的容量，或者将这个数放进桶后这个桶还能再放别的数
			if (bucket[i] == matchsticks[cur] || bucket[i]-matchsticks[cur] >= matchsticks[len(matchsticks)-1]) && !HasABucketOfThisCapacityEverAppeared[bucket[i]] { //bucket[i]容量不足以放时，咱直接看下一个桶咯
				bucket[i] -= matchsticks[cur]
				HasABucketOfThisCapacityEverAppeared[bucket[i]] = true
				//fmt.Printf("%v\n", bucket)

				//当前到达叶子节点了吗
				if backtracking(cur + 1) { //下面我要把nums[cur+1]往桶里放
					return true
				}

				//回溯
				bucket[i] += matchsticks[cur]
			}
		}

		//所有的桶都放不下nums[cur]了
		return false
	}

	return backtracking(0)
}
