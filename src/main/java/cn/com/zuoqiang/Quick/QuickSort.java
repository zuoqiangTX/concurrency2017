package cn.com.zuoqiang.Quick;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("快速排序");
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        int start = 0;
        int end = a.length - 1;
        sort(a, start, end);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + "-");
        }
    }

    public static void sort(int[] a, int start, int end) {
        if (start < end) {
            int low = start, high = end, x = a[start];  //low低位下标，high高位下标，x基准数字，挖个坑a[low]
            while (low < high) {
                while (low < high && a[high] >= x) {
                    high--; //从后向前移动
                }
                if (low < high) {
                    a[low++] = a[high];   //将基准数位置替换为比他小的   a[high]又空出来了
                }
                while (low < high && a[low] < x) {
                    low++;               //
                }
                if (low < high) {
                    a[high--] = a[low];   //将基准数位置替换为比他大的   //将a[high]填满
                }
            }
            a[low] = x;
            sort(a, start, low - 1);
            sort(a, low + 1, end);
        }
    }
}
