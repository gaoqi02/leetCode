package com.leet.code.队列;

/**
 * @author gaoqi
 * @date 2020/8/17.
 */
public class 大根堆 {

    //将元素array[k]自下往上逐步调整树形结构
    private static void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }

    //删除堆顶元素操作
    public static int[] deleteMax(int[] array) {
        //将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
        array[0] = array[array.length - 1];
        array[array.length - 1] = -99999;
        //对此时的根节点进行向下调整
        adjustDownToUp(array, 0, array.length);
        return array;
    }

    //插入操作:向大根堆array中插入数据data
    public static int[] insertData(int[] array, int data) {
        array[array.length - 1] = data; //将新节点放在堆的末端
        int k = array.length - 1;  //需要调整的节点
        int parent = (k - 1) / 2;    //双亲节点
        while (parent >= 0 && data > array[parent]) {
            array[k] = array[parent];  //双亲节点下调
            k = parent;
            if (parent != 0) {
                parent = (parent - 1) / 2;  //继续向上比较
            } else {  //根节点已调整完毕，跳出循环
                break;
            }
        }
        array[k] = data;  //将插入的结点放到正确的位置
        return array;
    }

    public static void main(String args[]){
        int[] array = {87,45,78,32,17,65,53,9,122};
        System.out.print("构建大根堆：");
//        (buildMaxHeap(array));
        System.out.print("\n"+"删除堆顶元素：");
        deleteMax(array);
        System.out.print("\n"+"插入元素63:");
        insertData(array, 63);
        System.out.print("\n"+"大根堆排序：");
//        (heapSort(array));
    }
}
