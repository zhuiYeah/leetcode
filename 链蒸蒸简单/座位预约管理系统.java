package 链蒸蒸简单;

import java.util.PriorityQueue;

public class 座位预约管理系统 {

}

class SeatManager {
    PriorityQueue<Integer> seat;

    public SeatManager(int n) {
        seat = new PriorityQueue<Integer>();
        for (int i = 1; i <= n; i++) {
            seat.add(i);
        }
    }

    public int reserve() {
        return seat.poll();
    }

    public void unreserve(int seatNumber) {
        seat.add(seatNumber);
    }
}
