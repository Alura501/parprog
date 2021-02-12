package ru.spbstu.telematics.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Stack<Integer> m_stack=new Stack<Integer>();
        Stack<Integer> m1= new Stack<Integer>();
        
        Integer i= m_stack.capacity();
        boolean f1 =false;
        m_stack.push(6);
        m_stack.push(7);
        m_stack.push(8);
        m_stack.push(9);
        m_stack.add(10);
        f1= m_stack.add(null);

        Iterator<Integer> it1 = m_stack.iterator();

        while(it1.hasNext())
        {
            System.out.println(it1.next());
        }



        MyStack<Integer> integerMyStack = new MyStack<Integer>();
        Integer MyI= integerMyStack.capacity();
        boolean f2 = integerMyStack.empty();
        integerMyStack.push(6);
        integerMyStack.push(7);
        integerMyStack.push(8);
        integerMyStack.push(9);
        integerMyStack.add(10);
        integerMyStack.remove(10);
        Iterator<Integer> it = integerMyStack.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
