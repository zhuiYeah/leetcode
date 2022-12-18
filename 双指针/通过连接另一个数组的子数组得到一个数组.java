package 双指针;


//本次耗时: 00 : 36 : 01
public class 通过连接另一个数组的子数组得到一个数组 {
    public  boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length;
        int ptrG = 0;
        int ptrNums = 0;
        while (ptrG < n && ptrNums < nums.length) {
            int len = groups[ptrG].length;

            //从nums[ptrN]开始去匹配长度为len的groups[ptrG]
            while (ptrNums < nums.length) {
                var tmp = ptrNums+1;
                var ptrTmp = 0;
                while (ptrTmp < len && ptrNums < nums.length && groups[ptrG][ptrTmp] == nums[ptrNums]) {
                    ptrNums++;
                    ptrTmp++;
                }
                if (ptrTmp == len){
                    ptrG++;
                    break;
                }
                ptrNums = tmp;
            }

//            //跳出上面那个循环只有两种可能，一种是groups[ptrG]被全部匹配，另一种是ptrNums越界
//            //还有一种是 越界且全部匹配
//            if (ptrNums != nums.length) ptrG++;
        }

        return ptrG == n;
    }
}

class edeefe{
    public static void main(String[] args) {
        var  x = new 通过连接另一个数组的子数组得到一个数组();
        x.canChoose(new int [][]{{1,-1,1},{3,-2,0}},new int[]{1,-1,0,1,-1,-1,3,-2,0});
    }

}

