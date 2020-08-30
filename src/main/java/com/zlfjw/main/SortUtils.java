package com.zlfjw.main;

public final class SortUtils {
    //将完全二叉树调整为大顶堆,i为父节点
    private static void heapify(int[] array, int length, int i) {
        //递归出口
        if (i >= length) {
            return;
        }
        //节点i的左孩子节点
        int c1 = 2 * i + 1;
        //节点i的右孩子节点
        int c2 = 2 * i + 2;
        //将父节点与孩子节点比较，并将节点最大的下标赋值给max
        int max = i;  //这里的赋值操作很关键
        if (c1 < length && array[c1] > array[max]) {
            max = c1;
        }
        if (c2 < length && array[c2] > array[max]) {
            max = c2;
        }
        //交换角标max和i的节点的值
        if (max != i) {
            swap(array, max, i);  //将左孩子或者右孩子结点的值和父节点的值进行交换
            //利用递归，继续对下一个父节点做比较调整，此时这里的max为左孩子节点或右孩子节点的下标
            heapify(array, length, max);
        }
    }

    private static void swap(int[] array, int max, int i) {
        int temp = array[max];
        array[max] = array[i];
        array[i] = temp;
    }

    /**
     * 堆排序
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(n)
     * 稳定性：不稳定
     *
     * @param array
     * @param length
     */
    public static void heapSort(int[] array, int length) {
        heapify(array, length, 0);    //此方法将数组调整为大顶堆
        for (int i = length - 1; i >= 0; i--) {
            swap(array, i, 0);  //将数组的第一位数字与最后一位数字交换，以砍去大顶堆的根节点(每循环一次数组长度就减一)
            heapify(array, i, 0);
        }
    }

//    public static void build_heap(int[] array,int length){
//        int last_node = length - 1;
//        for (int i = (last_node - 1) / 2 ;i >= 0;i--){
//            heapify(array,length,i);
//        }
//    }

    /**
     * 选择排序
     * n为0则为升序排序，n为1则为降序排序
     * 时间复杂度：O(n^2) 实际:(n^2 - n) / 2
     * 空间复杂度：O(n)
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void selectSort(int[] array, Integer n) {
        if (n == 0 || n == null) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        swap(array, i, j);
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        swap(array, i, j);
                    }
                }
            }
        }

    }

    /**
     * 冒泡排序
     * n为0时，升序，n为1时，降序
     * 时间复杂度：O(n2)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     * @param n
     */
    public static void bubboSort(int[] array, Integer n) {
        //外层循环控制趟数，比较n-1趟
        if (n == 0 || n == null) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        swap(array, j, j + 1);
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] < array[j + 1]) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }

    /**
     * 步长为n的插入排序
     * 时间复杂度：O(n2)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     * @param n
     */
    public static void insertSort(int[] array, int n) {
        if (n <= 0) return;
        int j;
        int i;
        for (i = n; i < array.length; i += n) {
            int temp = array[i];
            for (j = i; j > 0 && array[j - n] > temp; j -= n) {
                array[j] = array[j - n];
            }
            System.out.println(j);
            array[j] = temp;
        }
    }

    public static void insertSortBase(int[] array) {
        int i;
        int j;
        for (i = 1; i < array.length; i++) {
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度：O(n2)
     * 空间复杂度: O(n)
     * 稳定性：不稳定
     *
     * @param array
     */
    //TODO 可以将步长进行优化，例如使用Hibbard(Dk = 2^k - 1)增长序列,或者SedgeWick增量序列
    public static void shellSort(int[] array) {
        for (int d = array.length / 2; d < array.length; d /= 2) {
            insertSort(array, d);
            if (d == 1) {
                break;
            }
        }
    }

    /**
     * 快排,利用递归
     * 时间复杂度：O(nlog2n) 最坏情况是O(n2)
     * 空间复杂度：O(log2n)
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;  //递归出口
        int i = start;
        int j = end;
        int basic = array[i];
        while (i < j) {
            while (i < j && array[j] >= basic) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] <= basic) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        if (i == j) {
            array[i] = basic;
        }
        //此时i == j
        if (j - 1 > start) quickSort(array, start, j - 1);
        if (i + 1 < end) quickSort(array, i + 1, end);
    }

    /**
     * 归并排序
     * 时间复杂度：O(logn)
     * 空间复杂度：O(2n)
     * @param array
     * @param L
     * @param R
     * @return
     */
    public static int[] mergeSort(int[] array, int L, int R){
        if (L == R){  //递归出口
            return new int[] {array[L]};
        }
        int mid = (L+R)/2;
        int[] left = mergeSort(array, L, mid);
        int[] right = mergeSort(array, mid + 1, R);
        int[] newArray = new int[left.length + right.length];
        int i=0,j=0,m=0;
        while(i < left.length && j < right.length){
            newArray[m++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < left.length){
            newArray[m++] = left[i++];
        }
        while (j < right.length){
            newArray[m++] = right[j++];
        }
        return newArray;
    }


    /**
     * 基数排序
     * 时间复杂度：O(d*(r+n)) r表示关键字基数的个数，n表示关键字的个数，d表示最大数的位数，即关键字的最大长度
     * 一般r为10，
     * 空间复杂度：O(r*d + r)
     * @param number
     * @param d
     */
    public static void baseSort(int[] number, int d) {//d表示最大的数有多少位
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while(m <= d) {
            for(int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);  //依次取每个位上的数字，先取个位上的数
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++) {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }

}
