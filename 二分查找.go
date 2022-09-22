package main

import "sort"

func twoSum1(numbers []int, target int) []int {
	n := len(numbers)
	for i := 0; i < len(numbers); i++ {
		left := i + 1
		right := n - 1
		for left <= right { //二分查找
			mid := left + (right-left)/2
			if numbers[mid] == target-numbers[i] {
				return []int{i + 1, mid + 1}
			}
			if numbers[mid] > target-numbers[i] {
				right = mid - 1
			}
			if numbers[mid] < target-numbers[i] {
				left = mid + 1
			}
		}
	}
	return nil
}

func main() {
	//println(string(67))
	//var accounts [100][4]int
	//println(len(accounts))
	//println(len(accounts[1]))
	//
	nums := []int{0, 1, 0}
	//nums = append(nums[:0], nums[1:]...)
	//nums = append(nums, 0)
	//fmt.Printf("%v\n", nums)
	sort.Ints(nums)
}
