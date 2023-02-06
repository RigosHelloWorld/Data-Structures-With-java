package tst.com.rigoshelloworld.data.structures.Stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.rigoshelloworld.data.structures.Stacks.SimpleStackFromList;


public class SimpleStackTest {
    private SimpleStackFromList<Object> stack;
    
    @Before
    public void initalizeStack() {
        stack = new SimpleStackFromList<>();
    }

    @Test
    public void testEmptyStack() {
        assertTrue("Failed no items in stack ",stack.isEmpty());
    }

    @Test
    public void testEmptyStackSize(){
        assertEquals(0,stack.getSize());
    }

    @Test
    public void testNonEmptyStack() {
        Object val1 = 1;
        stack.push(val1);
        assertFalse("Failed items in stack ",stack.isEmpty());
    }

    @Test
    public void testNonEmptyStackSize() {
        Object val = 1;
        stack.push(val);
        assertEquals("Failed adding item to the stack ",1,stack.getSize());
    }

    @Test (expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        stack.peek();
    }

    @Test
    public void testPeekNonEmptyStack() {
        Object str = "helloWorld";
        stack.push(str);
        assertEquals(str, stack.peek());
    }
    
    @Test (expected = EmptyStackException.class)
    public void testPopOnEmptyStack() {
        stack.pop();
    }
    
    @Test
    public void testPopOnNonEmptyStack() {
        Object val1 = 1;
        stack.push(val1);
        assertEquals(val1, stack.pop());
    }

    @Test
    public void testSearchEmptyStack() {
        Object val1 = 1;
        assertEquals(-1, stack.search(val1));
    }

    @Test
    public void testSearchOnStackWithMultipleElements() {
        Object val1 = 1;
        Object val2 = 2;

        stack.push(val1);
        stack.push(val2);

        assertEquals("Test location from top of stack",1, stack.search(val2));
        assertEquals("Test location from top of stack",2, stack.search(val1));
    }

   
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SimpleStackTest.class);
        System.out.println(result.getFailures());
        System.out.println(result.getFailureCount());

        
    }
    
}
