package 回溯

import (
	"fmt"
	"sort"
)

//数组nums能否分割为两个等和子集

//回溯法时间复杂度达到2^n,超时
func canPartition(nums []int) bool {
	var sum int
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if sum%2 == 1 {
		return false
	}
	target := sum / 2 //target就是回溯要找到的子集的和
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))
	var currentSum int
	var backtracking func(int) bool
	backtracking = func(startIndex int) bool {
		if currentSum == target { //叶子节点
			return true
		}
		if currentSum > target { //剪枝
			return false
		}

		//将nums[i]放入桶中，如果有多个容量相同的桶，那么只选择其中一个（树层去重）
		for i := startIndex; i < len(nums); i++ {
			//对当前节点处理
			if i > startIndex && nums[i] == nums[i-1] { //树层去重，path不选择同一层的重复元素
				continue
			}
			currentSum += nums[i]
			//现在到达叶子节点了吗？ 是否需要回溯呢？
			if backtracking(i + 1) { //	已经选完nums[i]了，为了不出现重复子集，下面从nums[i+1]开始查找
				return true
			}
			//回溯
			currentSum -= nums[i]
		}
		//全部的树枝全都找到了还没有找到结果
		return false
	}
	return backtracking(0)
}

func main() {
	nums := []int{4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8, 12, 12, 12, 12, 12, 12, 12, 12, 16, 16, 16, 16, 16, 16, 16, 16, 20, 20, 20, 20, 20, 20, 20, 20, 24, 24, 24, 24, 24, 24, 24, 24, 28, 28, 28, 28, 28, 28, 28, 28, 32, 32, 32, 32, 32, 32, 32, 32, 36, 36, 36, 36, 36, 36, 36, 36, 40, 40, 40, 40, 40, 40, 40, 40, 44, 44, 44, 44, 44, 44, 44, 44, 48, 48, 48, 48, 48, 48, 48, 48, 52, 52, 52, 52, 52, 52, 52, 52, 56, 56, 56, 56, 56, 56, 56, 56, 60, 60, 60, 60, 60, 60, 60, 60, 64, 64, 64, 64, 64, 64, 64, 64, 68, 68, 68, 68, 68, 68, 68, 68, 72, 72, 72, 72, 72, 72, 72, 72, 76, 76, 76, 76, 76, 76, 76, 76, 80, 80, 80, 80, 80, 80, 80, 80, 84, 84, 84, 84, 84, 84, 84, 84, 88, 88, 88, 88, 88, 88, 88, 88, 92, 92, 92, 92, 92, 92, 92, 92, 96, 96, 96, 96, 96, 96, 96, 96, 97, 99}
	fmt.Printf("%v\n", canPartition(nums))
}
