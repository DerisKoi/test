package com.atguigu;

import sun.lwawt.macosx.CSystemTray;

public class SparseArray {
    public static void main(String[] args) {
        // 先创建 原始的二维数组 11 * 11 大小，0 表示没有旗子，1 表示黑子， 2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //
        System.out.println("原始的二维数组");
        for(int[] row: chessArr1){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 获取非零数据的个数
        int sum =0;
        for (int i =0; i< chessArr1.length; i++){
            for (int j =0; j< 11; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        int sparseArr[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] =11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 便利二维数组，讲非零的值存储到稀疏数组中
        int count =0;
        for (int i =0; i< 11; i++){
            for (int j =0; j< 11; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] =i;
                    sparseArr[count][1] =j;
                    sparseArr[count][2] =chessArr1[i][j];
                }
            }
        }
        //输出
        System.out.println();
        System.out.println("results:----");
        for (int i =0; i<sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //将稀疏数组返回为二维数组
        //1 \先读取稀疏数组的第一行，
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        for(int[] row: chessArr2){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
