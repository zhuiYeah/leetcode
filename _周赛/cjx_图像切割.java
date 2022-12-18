package _周赛;

public class cjx_图像切割 {
    public double[][] Pixel_Merge(int m, int n, double[][] graph) {
        // ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int row = graph.length, col = graph[0].length;

        // 记录某一区块的总和
        double[][] res = new double[row % m == 0 ? row / m : row / m + 1][col % n == 0 ? col / n : col / n + 1];
        // 记录某一区块的总计数
        int[][] cnt = new int[row % m == 0 ? row / m : row / m + 1][col % n == 0 ? col / n : col / n + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ni = i / m, nj = j / n;
                res[ni][nj] += graph[i][j];
                cnt[ni][nj]++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j] /= cnt[i][j];
        }

        return res;
    }
}

////import numpy as np
////
////
////
//        def  pixel_merge(image,m,n):
//        #totm,totn代表原始图像的总行列数
//        totm = image.shape[0]
//        totn = image.shape[1]
//        #newm、newn代表新图像的总行列数
//        newm =   int(totm/m)  if totm%m==0  else int(totm/m+1)
//        newn =  int(totn/n) if totn%n==0  else int(totn/n+1)
//        newimage = np.zeros((newm,newn))
//        cnt = np.zeros((newm,newn))
//
//        for i in range (0,totm) :
//        for j in range(0,totn) :
//        tari = int(i/m)
//        tarj = int(j/n)
//        newimage[tari,tarj]+=image[i,j]
//        cnt[tari,tarj]+=1
//
//        for i in range (0,newm):
//        for j in range (0,newn):
//        newimage[i,j]/=cnt[i,j]
//        return newimage
