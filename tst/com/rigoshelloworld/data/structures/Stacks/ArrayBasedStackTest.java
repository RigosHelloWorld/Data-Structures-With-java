package tst.com.rigoshelloworld.data.structures.Stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.rigoshelloworld.data.structures.Stacks.ArrayBasedStack;

public class ArrayBasedStackTest {
    private ArrayBasedStack<Object> stack;

    @Before
    public void initializeStack() {
        stack = new ArrayBasedStack<>();
    }

    @Test
    public void testEmptyStack() {
       assertTrue("Failed no items in stack ",stack.isEmpty());
    }

    @Test
    public void testEmptyStackSize() {
        assertEquals(0,stack.getSize());
    }

    @Test
    public void testNonEmptyStack() {
        Object data = new Object();
        stack.push(data);
        assertFalse("Failed items in stack " , stack.isEmpty());
    }

    @Test
    public void testNonEmptyStackSize() {
        Object val1 = new Object();
        stack.push(val1);
        assertEquals(1,stack.getSize());
    }

    @Test (expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        stack.peek();
    }

    @Test
    public void testPeekNonEmptyStack() {
        Object data = 1;
        stack.push(data);
        assertEquals(data,stack.peek());
    }

    @Test (expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test
    public void testPopNonEmptyStack() {
        Object data = 1;
        stack.push(data);
        assertEquals(data,stack.pop());
    }

    @Test
    public void testSearchEmptyStack() {
        Object data = 1;
        assertEquals(-1,stack.search(data));
    }

    @Test
    public void testSearchNonEmptyStack() {
        Object data1 = 1, data2 = 2, data3 = 3;

        stack.push(data1);
        stack.push(data2);
        stack.push(data3);

        assertEquals(1,stack.search(data3));
        assertEquals(2,stack.search(data2));
        assertEquals(3,stack.search(data1));

    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ArrayBasedStackTest.class);
        
        for(Failure fail : result.getFailures()) {
            System.out.println(fail.getTestHeader() + fail.toString());
            
        }
        System.out.println(result.getFailureCount());
    }



}
