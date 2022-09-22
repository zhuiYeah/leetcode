package 数学;

//给出两个矩阵的左下角和右上角，判断两个矩阵是否重叠
public class 矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        boolean res;
//        if (rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]) {
//            res = false;
//        } else {
//            res = true;
//        }
//        return res;
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }
}
