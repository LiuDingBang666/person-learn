package active.method.sort;

import active.method.sort.radix.LinkQueue;
import active.method.sort.radix.SingleLinked;

/**
 * 排序算法类
 *
 * @author ldb
 * @ClassName InsertSort.java
 * @Data 2022-04-06 15:16
 */
@SuppressWarnings("all")
public class Sort {
    /***
     * 辅助数组
     */
    private static int[] temp = new int[100];

    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 3, 10, 50, 98, 80};
        int[] arr2 = {-1, 1, 8, 4, 3, 10, 50, 80, 98};
    /*    insertSort(arr);
        insertSortByBinarySearch(arr2);
        shellSort(arr2);
        bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);
        selectSort(arr);
        heapSort(arr2);*/
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
//        for (int i : arr2) {
//            System.out.print(i + " ");
//        }
    }

    /**
     * 二分查找
     *
     * @param nums 数组
     * @param num  查找的值
     * @return int
     * @author Ldb
     * @date 2022-04-06
     **/
    public static int binarySearch(int[] nums, int num) {
        int left = 0, right = nums.length, mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == num) {
                return mid;
            }
            if (nums[mid] > num) {
                right = mid - 1;
            }
            if (nums[mid] < num) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 直接插入排序(稳定) 顺序表和链表都可以
     * todo 设第一个值为已排序，拿后面的值和前面相比，如果比其小，则排好序的区间都往后移。最后将该值放入
     * 空间：O(1) 时间: 最好 O(n) 最坏 O(n2) 平均 O(n2)
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void insertSort(int[] arr) {
        int temp, j, i;
        for (j = 1; j < arr.length; j++) {
            if (arr[j] < arr[j - 1]) {
                temp = arr[j];
                for (i = j - 1; i >= 0 && arr[i] > temp; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[i + 1] = temp;
            }
        }
    }

    /**
     * 带二分查找的直接插入(比较关键字次数减少)
     * 0(n2)
     *
     * @param arr 数组
     * @return int
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void insertSortByBinarySearch(int[] arr) {
        int i, j, low, high, mid;
        for (i = 2; i <= arr.length - 1; i++) {
            arr[0] = arr[i];
            low = 1;
            high = i - 1;
            // 二分查找
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] > arr[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j >= high + 1; --j) {
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = arr[0];
        }
    }

    /**
     * 希尔排序(不稳定排序) 只适用于顺序表
     * todo 追求部分有序，部分有序使用直接插入排序。最终达到全部有序
     * todo 步长每次减少
     * 空间 o(1) 时间 最坏 o(n2) 最好 o(n1.3)
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void shellSort(int[] arr) {
        int d, i, j, n = arr.length - 1;
        for (d = n / 2; d >= 1; d = d / 2) {
            // 子表循环
            for (i = d + 1; i <= n; ++i) {
                if (arr[i] < arr[i - d]) {
                    arr[0] = arr[i];
                    for (j = i - d; j > 0 && arr[0] < arr[j]; j -= d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = arr[0];
                }
            }
        }
    }

    /**
     * 冒泡排序（稳定）-交换排序
     * 空间o(1) 时间 最好 o(n) 最坏 o(n2)
     * todo 每次排序都把相邻的值做比较，最后的值总是最大值
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void bubbleSort(int[] arr) {
        int i, j, temp;
        // 总排序次数
        for (i = 0; i < arr.length - 1; i++) {
            // 每次从哪里开始比较
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * todo 重要
     * 快速排序(不稳定)-交换排序  类似于二叉树
     * todo 以一个值为基准，定义left、right两个指针，为空的值先不扫描，右边找比基准小的，左边找比基准大的,left=right时扫描了所有文件,最后将基准值放入该值下标
     * 时间 o(n*递归层数) 最好 o(log2n) 最坏 o(n2) 空间 o(递归层数) 最好 o(log2n) 最坏 o(n)
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotpos = partition(arr, low, high);
            quickSort(arr, low, pivotpos - 1);
            quickSort(arr, pivotpos + 1, high);
        }
    }

    /**
     * 用第一个元素将待排序序列划分为左右两个部分
     *
     * @param arr  数组
     * @param low  左
     * @param high 右
     * @return int
     * @author Ldb
     * @date 2022-04-06
     **/
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;

    }

    /**
     * 简单选择排序（选择排序）- 不稳定
     * todo 每一次在待排序元素中选最小或最大元素加入有序子序列
     * 空间 o(1) 时间 o(n^2)
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void selectSort(int[] arr) {
        int i, j, temp, min;
        // 总排序次数
        for (i = 0; i < arr.length - 1; i++) {
            // 记录最小下标
            min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                // 当前层的最小值交换
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 堆排序(完全二叉树) - 选择排序(小元素下坠)
     * 时间 o(nlog2n) 空间 o(1) 不稳定排序
     * todo  大根堆(根节点大于左子树和右子树) i>2i>2i+1 小根堆(根节点小于左子树和右子树) i<2i<2i+1
     * <p>
     * todo 在根堆中选择最大或最小元素
     * todo 建立根堆方法: 将所有非终端节点都检查一遍，是否满足大根堆的要求，如果不满足则进行调整，
     * todo 下坠可能不符合根堆要求，需要继续调整
     * todo 每一趟将堆顶元素加入有序子序列，与待排序序列中最后一个元素交换
     * <p>
     * 插入：将新元素放入数组尾部，然后执行上升调整,最多上升3次，最少上升0次
     * 删除: 将该元素删除，用堆底的值代替该元素，再让该元素不断下坠,每层对比两次，如果只有一个孩子，只需进行一次对比
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-06
     **/
    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            headAdjust(arr, 1, i - 1);
        }
    }

    /**
     * 建造大根堆
     * 时间 o(n)
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-07
     **/
    public static void buildMaxHeap(int arr[]) {
        int length = arr.length - 1;
        // 调整非终端节点
        for (int i = length / 2; i > 0; i--) {
            headAdjust(arr, i, length);
        }
    }

    /**
     * 根堆调整
     * todo 非终端节点 n/2 i的左孩子 2i i的右孩子 2i+1 i的父节点 i/2
     *
     * @param arr    数组
     * @param i      当前要调整的元素
     * @param length 数组长度
     * @author Ldb
     * @date 2022-04-07
     **/
    public static void headAdjust(int[] arr, int k, int length) {
        // 暂存子树节点
        arr[0] = arr[k];
        // 子节点向下筛选
        for (int i = 2 * k; i <= length; i *= 2) {
            // 是否有有兄弟
            if (i < length && arr[i] < arr[i + 1]) {
                i++;
            }
            // 根大于左右子节点
            if (arr[0] >= arr[i]) {
                break;
            } else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = arr[0];
    }

    /**
     * 归并排序(倒立的二叉树) 稳定排序
     * todo 把两个或多个已经有序的序列合并成一个 一一对比放入到新数组中
     * todo 重复 二路归并
     * 时间 o(log2n) 空间 o(n)
     *
     * @param arr 数组
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-07
     **/
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    /**
     * 归并排序
     *
     * @param arr  数组
     * @param low  最小小标
     * @param mid  中间下标
     * @param high 最大下标
     * @author Ldb
     * @date 2022-04-07
     **/
    public static void merge(int[] arr, int low, int mid, int high) {
        int i, j, k;
        for (k = low; k <= high; k++) {
            temp[k] = arr[k];
        }
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
        // 如果没有合并完，则依次放入
        while (i <= mid) arr[k++] = temp[i++];
        while (j <= high) arr[k++] = temp[j++];
    }

    /**
     * 基数排序 （稳定）
     * todo 按个、十、百位分别放入队列中，每次放完后整合进一个链表
     * todo 队列和值
     * 一趟分配 O(n), 一趟收集 O(r) 时间: O(d(n+r)) 空间: O(r)
     * 适用条件:元素可以很方便拆分为多个元组，并且分组数量不多,r教小
     *
     * @param arr 数组
     * @author Ldb
     * @date 2022-04-07
     **/
    public static void radixSort(int[] arr) {
        LinkQueue<Integer>[] queues = new LinkQueue[10];
        SingleLinked<Integer> singleLinked = new SingleLinked<>();
        System.out.println("仅定义，未实现");
    }
}
