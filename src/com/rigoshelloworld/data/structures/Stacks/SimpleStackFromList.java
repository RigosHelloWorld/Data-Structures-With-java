package com.rigoshelloworld.data.structures.Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
 * Empty,               DONE
 * peek,                DONE     returns but does not remove the last element in the list 
 * pop,                 DONE     returns and removes the last element in the list                 
 * push,                DONE
 * search,              DONE
 * size                 DONE
 */
public class SimpleStackFromList<T> implements IStack<T>{
    List<T> list;

    public SimpleStackFromList() {
        list = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T peek() {
        if (!list.isEmpty())
            return list.get(list.size() - 1);

        throw new EmptyStackException();

    }

    @Override
    public T pop() {
        if (!list.isEmpty()) {
            T element = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return element;
        }
        throw new EmptyStackException();
    }

    @Override
    public void push(T data) {
        list.add(data);
    }

    @Override
    public int search(T data) {
        if(!list.isEmpty()) {
            int pos = 1;
            
            for(int i = list.size() -1; i >= 0; i--) {
                T element = list.get(i);
                if(element.equals(data))
                    return pos;
                else
                    pos++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SimpleStackFromList<Integer> stack = new SimpleStackFromList<>();
    
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
    }

}

