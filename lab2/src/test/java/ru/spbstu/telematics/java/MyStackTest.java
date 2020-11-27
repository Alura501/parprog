package ru.spbstu.telematics.java;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.*;

import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MyStackTest
    extends TestSuite
{
    private Stack<Integer> javaStack;
    private MyStack<Integer> myStack;

    private<T> Boolean CollectionsEqual(Collection<T> c1, Collection<T> c2 ){
        if (c1==null&&c2==null)
            return true;
        if (c1==null)
            return false;
        return c1.equals(c2);
    }

    @Before
    public void SetUp(){
        javaStack = new Stack<Integer>();
        myStack = new MyStack<Integer>();
        javaStack.push(1);
        javaStack.push(2);
        javaStack.push(4);
        javaStack.push(7);
        javaStack.push(8);

        myStack.push(1);
        myStack.push(2);
        myStack.push(4);
        myStack.push(7);
        myStack.push(8);

    }

    @Test
    public void TestPush(){
        javaStack.push(10);
        myStack.push(10);
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));
    }

    @Test
    public void TestRemove(){
        Assert.assertEquals(myStack.remove(7),  javaStack.remove((Object)7));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));

        Assert.assertEquals(myStack.remove(10),  javaStack.remove((Object)10));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));

        Assert.assertEquals(myStack.remove(null),  javaStack.remove(null));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));
    }

    @Test
    public void TestSearch(){
        Assert.assertEquals(myStack.search(1), javaStack.search(1));
        Assert.assertEquals(myStack.search(null), javaStack.search(null));
    }


    @Test
    public void TestToArray(){
        Assert.assertArrayEquals(javaStack.toArray(),myStack.toArray());
    }

    @Test
    public void TestPop(){
        Assert.assertEquals(javaStack.pop(),myStack.pop());
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));
    }

    @Test
    public void TestPeek(){
        Assert.assertEquals(javaStack.peek(),myStack.peek());
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));
    }


    @Test
    public void TestSize(){
        Assert.assertEquals(javaStack.size(),myStack.size());
    }

    @Test
    public void TestIsEmpty(){
        Assert.assertEquals(javaStack.empty(),myStack.empty());
        javaStack.clear();
        myStack.clear();
        Assert.assertEquals(javaStack.empty(),myStack.empty());
    }

    @Test
    public void TestAdd(){
        Assert.assertEquals(javaStack.add(7),myStack.add(7));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));

        Stack<Integer> st=new Stack<Integer>();
        st.push(5);
        st.push(7);
        st.push(9);

        Assert.assertEquals(javaStack.addAll(st),myStack.addAll(st));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));

    }

    @Test
    public void TestContains(){
        Assert.assertEquals(javaStack.contains(8),myStack.contains(8));

        Assert.assertEquals(javaStack.contains(null),myStack.contains(null));


        Stack<Integer> st=new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(7);
        Assert.assertEquals(javaStack.containsAll(st),myStack.containsAll(st));



    }

    @Test
    public void TestRetain(){

        Stack<Integer> st=new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(7);
        Assert.assertEquals(javaStack.retainAll(st),myStack.retainAll(st));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));

        st.clear();
        Assert.assertEquals(javaStack.retainAll(st),myStack.retainAll(st));
        Assert.assertTrue(CollectionsEqual(myStack, javaStack));


    }

    @Test
    public void TestIterator(){
        Iterator<Integer> myIterator= myStack.iterator();
        Iterator<Integer> javaIterator = javaStack.iterator();

        Assert.assertEquals( myIterator.hasNext(), javaIterator.hasNext());

        while (myIterator.hasNext() && javaIterator.hasNext())
            Assert.assertEquals(myIterator.next(), javaIterator.next());

        Assert.assertEquals(myIterator.hasNext(), javaIterator.hasNext());



    }
}
