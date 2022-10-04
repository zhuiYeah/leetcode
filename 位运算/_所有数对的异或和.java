package 位运算;

//这题确实不会
//这里超时
//88场双周赛
public class _所有数对的异或和 {
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

//异或 相同为0，不同为1
//任何数字与0异或都为自己本身
//一个数字最终如果一共异或了偶数次，那么这个数字对结果的贡献就是0
//由于答案是一大堆数字的异或和，根据贡献法的思想，我们可以讨论每个数字在这一大堆数字中出现了多少次，对答案的贡献是多少

class dwecweq{
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        int m = nums1.length , n = nums2.length;
        //nums2中的每个数字都要参与异或m次，如果m是偶数，那么num2中的所有数字都做不出任何贡献
        if (m % 2 == 1) {
            for (int num : nums2)  res ^= num;
        }
        if (n % 2 == 1) {
            for (int num : nums1)  res ^= num;
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