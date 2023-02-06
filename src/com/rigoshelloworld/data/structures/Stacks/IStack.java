package com.rigoshelloworld.data.structures.Stacks;
public interface IStack<T> {
/*
 * Empty,               DONE
 * peek,                DONE     returns but does not remove the last element in the list 
 * pop,                 DONE     returns and removes the last element in the list                 
 * push,                DONE
 * search,              DONE
 * size                 DONE
 */

    public boolean  isEmpty();
    public T        peek();
    public T        pop();
    public void     push(T data);
    public int      search(T data);
    public int      getSize();    
}
