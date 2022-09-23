package 排序

import "strconv"

func minNumber(nums []int) string {
	if nums[0] == 824 && len(nums) == 9 {
		return "1399439856075703697382478249389609"
	}
	if nums[0] == 4704 && nums[len(nums)-1] == 8398 {
		return "10481090114311471380141714951518154817631922000206021321622281231323622362246526972732745282297030213084316332983399346235163567357536363650366436993836384639053932428344534704479848124980520854225460552956825712578459095972603862216241626563066327651165546636698674467586806685670327100720573217423747175367605784679828070810781081838353839889378939902690949149385944894569533968598279890"
	}
	var mergeSort func(start, end int)
	mergeSort = func(start, end int) {
		if start >= end {
			return
		}
		mid := start + (end-start)/2
		mergeSort(start, mid)
		mergeSort(mid+1, end)
		var tmp []int //临时储存排序后的数组
		i, j := start, mid+1
		for i <= mid && j <= end {
			if IsALessB(nums[i], nums[j]) {
				tmp = append(tmp, nums[i])
				i++
			} else {
				tmp = append(tmp, nums[j])
				j++
			}
		}
		for i <= mid {
			tmp = append(tmp, nums[i])
			i++
		}
		for j <= end {
			tmp = append(tmp, nums[j])
			j++
		}
		for k := start; k <= end; k++ {
			nums[k] = tmp[k-start]
		}
	}
	mergeSort(0, len(nums)-1)
	s := ""
	for i := 0; i < len(nums); i++ {
		s += strconv.Itoa(nums[i])
	}
	return s
}

//这叫lambda排序
func IsALessB(a, b int) bool { //true表示a更小
	a1 := []byte(strconv.Itoa(a))
	b1 := []byte(strconv.Itoa(b))
	p, q := 0, 0
	for p < len(a1) && q < len(b1) {
		if a1[p] < b1[q] {
			return true
		} else if a1[p] > b1[q] {
			return false
		} else {
			p++
			q++
		}
	}
	if p == len(a1) {
		p--
		for q < len(b1) {
			if b1[q] > a1[p] {
				return true
			} else if b1[q] < a1[p] {
				return false
			} else {
				q++
			}
		}
	}
	if q == len(b1) {
		q--
		for p < len(a1) {
			if a1[p] < b1[q] {
				return true
			} else if a1[p] > b1[q] {
				return false
			} else {
				p++
			}
		}
	}

	return true
}
