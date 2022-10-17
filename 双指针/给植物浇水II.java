package 双指针;

//阿里
public class 给植物浇水II {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        if (n == 1) return 0;
        int count = 0, left = 0, right = n - 1, restA = capacityA, restB = capacityB;
        while (left <= right) {
            if (left == right){
                if (restA<plants[left]&& restB<plants[right]) count++;
                break;
            }
            if (restA < plants[left]) {
                restA = capacityA;
                count++;
            }
            if (restB < plants[right]) {
                restB = capacityB;
                count++;
            }
            restA -= plants[left];
            restB -= plants[right];
            left++;
            right--;

        }
        return count;
    }
}
