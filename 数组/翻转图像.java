package 数组;


public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (image[i][left] == image[i][right]) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                image[i][left] ^= 1;
            }
        }
        return image;
    }

//    public void changeOne(int[][] image, int row, int col) {
//        if (image[row][col] == 0) {
//            image[row][col] = 1;
//        } else {
//            image[row][col] = 0;
//        }
//    }
}
