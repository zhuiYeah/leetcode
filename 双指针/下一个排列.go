package 双指针

import (
	"sort"
)

//把后面的最小更大元素移动到前面，也算是双指针把

func nextPermutation(nums []int) {
	var x int
	for i := len(nums) - 1; i > 0; i-- {
		if nums[i] > nums[i-1] { //后一个数比前一个数大？应该把大的数放到前面
			smallNumbersInFront := nums[i-1]
			bigNumbersAtTheBack := nums[i]
			indexOfBigNum := i
			for j := i + 1; j < len(nums); i++ {
				if nums[j] > smallNumbersInFront && nums[j] < bigNumbersAtTheBack {
					bigNumbersAtTheBack = nums[j]
					indexOfBigNum = j
				}
			}
			nums[i-1], nums[indexOfBigNum] = nums[indexOfBigNum], nums[i-1]
			x = i //现在要对nums[i]~nums的最后进行重新排序
			break
		}
	}
	sort.Ints(nums[x:])
}
