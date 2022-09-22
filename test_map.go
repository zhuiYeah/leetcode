package main

import "fmt"

func main() {
	scene := make(map[string]int)
	// 准备map数据
	scene["route"] = 66
	scene["brazil"] = 4
	scene["china"] = 960
	scene["brazil"] = 99999
	fmt.Printf("%v\n", scene)
	delete(scene, "brazil")
	for k, v := range scene {
		fmt.Println(k, v)
	}

	v, ok := scene["china"] //hash表查找是查找key：china是否存在，但是返回的v是其value值，ok是查找是否找到
	println(v)
	println(ok)
}

func twoSum(nums []int, target int) []int {
	m := map[int]int{} //hash表存储 key：nums【i】即要查找的数   value：i即索引
	for i := 0; i < len(nums); i++ {
		if indexOfNumberFinded, ok := m[target-nums[i]]; ok { //hash表查找是查找m【key】是否存在，与value无关，这里value储存索引
			return []int{indexOfNumberFinded + 1, i + 1}
		}

		m[nums[i]] = i //找不到的话讲key：nums【i】；value：i储存进表
	}
	return nil
}
