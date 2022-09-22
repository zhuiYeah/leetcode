package 栈和队列

func asteroidCollision(asteroids []int) []int {
	var stack []int
	if len(asteroids) == 0 {
		return stack
	}
	for i := 0; i < len(asteroids); i++ {
		if asteroids[i] < 0 { //往左走的行星是可能与栈中行星碰撞的
			for len(stack) > 0 && asteroids[i] < 0 && stack[len(stack)-1] > 0 { //必定碰撞
				if asteroids[i]+stack[len(stack)-1] < 0 { //迎面而来的小行星碰撞胜利
					stack = stack[:len(stack)-1]
				} else { //	栈中行星碰撞胜利 或是 俩个都炸了 留到for循环之外讨论
					break
				}
			}
			if len(stack) == 0 { //栈中行星的全部炸完了
				stack = append(stack, asteroids[i])
			} else if asteroids[i]+stack[len(stack)-1] == 0 { //最后，栈顶行星与小行星共同爆炸
				stack = stack[:len(stack)-1]
			} else if stack[len(stack)-1] < 0 { //迎面而来的小行星碰撞胜利
				stack = append(stack, asteroids[i])
			}
			//剩余 的情况 就是小行星爆炸，来，继续碰撞下一个小行星 ，不需要写continue了

		} else { //往右走的行星不可能与栈中行星碰撞
			stack = append(stack, asteroids[i])
		}
	}
	return stack
}
