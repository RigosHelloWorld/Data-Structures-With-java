package com.rigoshelloworld.data.structures.Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBasedStack<T> implements IStack<T> {

    private T[] array;
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;

    public ArrayBasedStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public ArrayBasedStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(T data) {
        if(size >= array.length){
            grow();
        }
        array[size++] = data;
       
    }

    private void grow() {
        int newSize = size *2;
        array = Arrays.copyOf(array, newSize);
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public T peek() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        T data = array[size -1];
        return data;
    }

    @Override
    public T pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        //[1,2,3]
        T data = array[size-1];
        array[--size] = null;
        return data;
    }

    @Override
    public int search(T data) {
        
        for(int i = size -1, distanceFromTop =1; i >= 0 ; i--, distanceFromTop++) {
            if(array[i].equals(data)){
                return distanceFromTop;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return size == 0 ? 0 : size ;
    }


    
    public static void main(String[] args) {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>();
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());


        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.search(30));
        System.out.println(stack.search(20));
        System.out.println(stack.search(10));
        System.out.println();
        System.out.println();


        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
        System.out.println(stack.search(10));
    }
    
}
