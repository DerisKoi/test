package com.atguigu;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //编写ArrayQueue 的类
        ArrayQueue queue =new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): exit队列");
            System.out.println("a(add): add队列");
            System.out.println("g(get): get队列");
            System.out.println("h(head): head队列");
            key = scanner.next().charAt(0);
            switch (key){

                case 's':
                    queue.showQueue();
                    break;

                case 'a':
                    System.out.println("get a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("queue head is %d\n", res);

                    } catch (Exception e){
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;

            }
        }
        System.out.println("exit program");
    }
}


class ArrayQueue{
    private int maxSize; // 表示数组的最大容量
    private int front;  // 队列头
    private int rear;  // 队列尾部
    private int[] arr;  // 队列数组

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列头部， 分析出front是指向队列头的前一个位置 0 的前一个位置
        rear = -1;  // 指向队列尾部  队列尾部的具体位置 及包含队列尾部的位置  （也就是队列最后一个位置)
    }
    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize-1;
    }
    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if(isFull()){
            System.out.println("its full, cant add");
            return;
        }
        rear++;   //让rear 后移
        arr[rear] = n;
    }
    // 获取队列的数据  出队列
    public int getQueue() {
        // 判断队列是否空
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
           // System.out.print("good");
        }
        front++;  // front 后移
        return arr[front];
    }
    public void showQueue(){
        // 遍历
        if(isEmpty()){
            System.out.println("队列空的");
        }
        for (int i =0; i<arr.length; i++){
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }
    }
    public int headQueue(){
        if(isEmpty()){
            System.out.println("enmpy");
            throw new RuntimeException("empty");

        }
        return arr[front+1];
    }
}
