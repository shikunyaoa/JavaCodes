package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Insert_sort
 * @Author: kunyao
 * @Description: 快速排序 - 设定数组中的某个元素为中心点，将大于它的左边的元素和小于它的右边的元素交换位置
 * @Date: 2020/7/29 14:53
 * @Version: 1.0
 */
public class Quick_sort {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
       if(hi <= lo){
           return;
       }
       int j = partition(a, lo, hi);
       sort(a, lo, j - 1);
       sort(a, j + 1, hi);
    }

    /**
     * 三向切分的快速排序
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort2(Comparable[] a, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0){
                //a[i]小于v,将a[lt]和a[i]交换，将lt和i加一
                exch(a, lt++, i++);
            }else if(cmp > 0){
                //a[i]大于v，将a[gt]和a[i]交换，将gt减一
                exch(a, i, gt--);
            }else{
                //a[i]等于v,将i加一
                i++;
            }
        }
        sort2(a, lo, lt - 1);
        sort2(a, gt + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        //将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i= lo, j = hi + 1; //左右扫描指针
        Comparable v = a[lo];
        while(true){
            //扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i], v)){
                if(i == hi) {
                    break;
                }
            }

            while(less(v, a[--j])){
                if(j == lo){
                    break;
                }
            }

            if(i >= j){
                break;
            }

            exch(a, i, j);
        }
        exch(a, lo, j); //将v = a[j]放入正确的位置
        return j;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length ; i++) {
            if(less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
