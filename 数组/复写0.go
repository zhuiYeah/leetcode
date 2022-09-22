package 数组

func duplicateZeros(arr []int) {
	n := len(arr)
	for i := 0; i < n; i++ {
		if arr[i] == 0 {
			copy(arr[i+1:], arr[i:])
			arr[i] = 0
			i++
		}
	}
}

