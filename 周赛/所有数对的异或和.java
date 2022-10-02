package 周赛;

//这里超时
public class 所有数对的异或和 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                res ^= nums1[j] ^ nums2[j];
            }
        }
        return res;
    }
}



//  这里错误
//class Solution {
//    public:
//    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
//        int res1=0,res2=0;
//        for(int num:arr1){
//            res1^=num;
//        }
//        for(int num:arr2){
//            res2^=num;
//        }
//        return res1^res2;
//    }
//};