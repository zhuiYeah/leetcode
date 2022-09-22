package 回溯

import (
	"sort"
)

//回溯部分一直存在问题 这段代码通过测试用例153/162
func canPartitionKSubsets(nums []int, k int) bool {
	var target int
	for i := 0; i < len(nums); i++ {
		target += nums[i]
	}
	if target%k != 0 {
		return false
	}
	sort.Sort(sort.Reverse(sort.IntSlice(nums))) //剪枝思路，逆序遍历
	target /= k
	x := 0 //记录当前符合和为target 的 子集 的 个数
	var currentSum int
	var backtracking func([]int) bool
	backtracking = func(optionalNums []int) bool {
		if currentSum == target {
			x++
			currentSum = 0
		}
		if x == k-1 { //叶子节点，找到分割结果啦～ 这里是k减1而不是k 这是一种剪枝思想，数组中剩下的元素和必然为target
			return true
		}

		for i := 0; i < len(optionalNums); i++ {
			//处理节点
			if i > 0 && nums[i] == nums[i-1] { //树层去重
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
			if backtracking(trimmedNums) {
				return true
			}

			//回溯 ,之前取了optionalNums[i]，但是没找到正确的分割方案，现在回溯回来了

			currentSum -= optionalNums[i]
			if currentSum == 0 {
				x--
				currentSum = target
			}

		}
		//遍历完nums都没找到，那么就是没有分割方案了
		return false
	}

	return backtracking(nums)
}

//考虑到是恢复currentSum一直出现问题，于是决定不恢复currentSum（将currentSum作为每个函数的传递参数，而不作为全局参数）
//还是不对   115 / 162    [2,2,2,2,3,4,5] 4
func canPartitionKSubsets0(nums []int, k int) bool {
	var target int
	for i := 0; i < len(nums); i++ {
		target += nums[i]
	}
	if target%k != 0 {
		return false
	}
	sort.Sort(sort.Reverse(sort.IntSlice(nums))) //剪枝思路，逆序遍历
	target /= k
	x := 0 //记录当前符合和为target 的 子集 的 个数
	var backtracking func([]int, int) bool
	backtracking = func(optionalNums []int, currentSum int) bool {
		if currentSum == target {
			x++
			currentSum = 0
		}
		if x == k-1 { //叶子节点，找到分割结果啦～ 这里是k减1而不是k 这是一种剪枝思想，数组中剩下的元素和必然为target
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

	return backtracking(nums, 0)
}

//利用桶 , 每个桶的容量为target，桶的个数为k，必须把桶填满
func canPartitionKSubsets1(nums []int, k int) bool {
	var target int
	for i := 0; i < len(nums); i++ {
		target += nums[i]
	}
	if target%k != 0 {
		return false
	}
	target /= k
	bucket := make([]int, k)
	for i := 0; i < len(bucket); i++ {
		bucket[i] = target
	}
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))

	var backtracking func(cur int) bool // cur 为当前位置
	backtracking = func(cur int) bool {
		if cur == len(nums) { //叶子节点 //cur走到len（nums）时，所有的数都放进桶里了，一定是ture
			return true
		}

		//将nums[i]放入桶中，如果有多个容量相同的桶，那么只选择其中一个（树层去重）
		HasABucketOfThisCapacityEverAppeared := map[int]bool{}
		for i := 0; i < k; i++ { //第i个桶
			//两种可能，这个数正好是桶当前的容量，或者将这个数放进桶后这个桶还能再放别的数
			if (bucket[i] == nums[cur] || bucket[i]-nums[cur] >= nums[len(nums)-1]) && !HasABucketOfThisCapacityEverAppeared[bucket[i]] { //bucket[i]容量不足以放时，放下一个桶咯
				bucket[i] -= nums[cur]
				HasABucketOfThisCapacityEverAppeared[bucket[i]] = true
				//fmt.Printf("%v\n", bucket)

				//当前到达叶子节点了吗
				if backtracking(cur + 1) { //下面我要把nums[cur+1]往桶里放
					return true
				}

				//回溯
				bucket[i] += nums[cur]
			}
		}

		//所有的桶都放不下nums[cur]了
		return false
	}

	return backtracking(0)
}

func main() {
	nums := []int{4, 3, 2, 3, 5, 2, 1}
	canPartition(nums)
}
