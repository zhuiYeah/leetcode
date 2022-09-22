package 数组

import "fmt"

type OrderedStream struct {
	stream []string
	ptr    int
}

func Constructor(n int) OrderedStream {
	stream := make([]string, n+1)
	ptr := 1
	return OrderedStream{stream, ptr}
}

func (this *OrderedStream) Insert(idKey int, value string) []string {
	var res []string
	this.stream[idKey] = value
	for this.ptr < len(this.stream) && this.stream[this.ptr] != "" {
		res = append(res, this.stream[this.ptr])
		this.ptr++
	}
	return res
}

func main() {
	fmt.Printf("fuck you")
}
