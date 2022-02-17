package com.orange.algorithm;

public class BinarySearch {

    static int binarySearch(int[] arrays, int findNum, int left, int right) {
        if (left < 0 || right > arrays.length - 1) {
            return -1;
        }
        //折中点下标
        int center = (right - left) >> 1;
        System.out.println("折中点 "+ center);
        if (findNum == arrays[center]) {
            return center;
        }
        //拆分
        if (findNum > arrays[center]) {
            return binarySearch(arrays, findNum, center, right);
        }
        if (findNum < arrays[center]) {
            return binarySearch(arrays, findNum, left, center);
        }
        return -1;
    }

    static int[] sort(int[] arrays) {
        //排序 3, 5, 1, 4, 7, 2, 6, 9, 8
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j=i+1;j<arrays.length;j++){
                swap(arrays,i,j);
            }
        }
        return arrays;
    }


    static boolean swap(int[] arrays, int i, int j) {
        int temp;
        if (arrays[i] > arrays[j ]) {
            temp = arrays[j ];
            arrays[j] = arrays[i];
            arrays[i] = temp;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{3, 5, 1, 4, 7, 2, 6, 9, 8};
        mains(arrays, 3);
    }

    public static void mains(int[] arrays, int findNum) {
        arrays = sort(arrays);
        for (int a : arrays) {
            System.out.print(a + " ");
        }
        System.out.println();
        int result = binarySearch(arrays, findNum, 0, arrays.length - 1);
        System.out.println(result);
    }
}
