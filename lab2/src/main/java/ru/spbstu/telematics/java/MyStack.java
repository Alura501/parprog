package ru.spbstu.telematics.java;


import org.apache.commons.math3.geometry.Vector;

import java.util.Iterator;
import java.util.*;

public class MyStack<T> implements Collection<T>
{

    private  T[]stack;
    private  int _Maxsize;
    private int size;

    public MyStack(int s){
    _Maxsize =s;
    stack = (T[])new Object[_Maxsize];
    size=0;
    }

    public MyStack(){
        _Maxsize =10;
        stack = (T[])new Object[_Maxsize];
        size=0;
    }

    public Object push(T element) {
        if (size < _Maxsize) {
            stack[size++] = element;
        } else {
            _Maxsize += size;
            T[] tmp = (T[]) new Object[size];
            for (int i = 0; i < stack.length; i++) {
                tmp[i] = stack[i];
            }
            stack = tmp;
            this.push(element);
        }
        return element;
    }

    //@Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass().getName().equals(this.getClass().getName()))
        {
            MyStack<T> comp = (MyStack<T>)obj;

            if (comp.size() != this.size())
                return false;

            for (int i = 0; i < size; i++)
                if (!comp.get(i).equals(this.get(i)))
                    return false;

            return true;
        }

        if (obj.getClass().getName().equals(Stack.class.getName()))
        {
            Stack<T> comp = (Stack<T>)obj;

            if (comp.size() != this.size())
                return false;

            for (int i = 0; i < size; i++)
                if (!comp.get(i).equals(this.get(i)))
                    return false;

            return true;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


    @Override
    public boolean contains(Object o) {
        if (o==null) return false;
        for (int i=0; i<size; i++){
            if (stack[i].equals((T)o)) return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    public class MyIterator<T> implements Iterator<T>
    {
        private int index;

        MyIterator()
        {
            index = -1;
        }



        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }


        @Override
        public boolean hasNext()
        {
            return index + 1 < size;
        }

        @Override
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException();

            index++;
            return (T) stack[index];
        }

    }

    @Override
    public Object[] toArray() {
        Object [] arr = new Object[size];
        for(int i =0; i<size; i++){
            arr[i]=stack[i];
        };
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        T1[] arr;
        if (size<=a.length){
            arr =a;
        }
        else {
            arr =(T1[]) new Object[size];
        }
        int i=0;
        for(Object item: stack){
            arr[i++]=(T1)item;
        }
        return arr;
    }

    @Override
    public boolean add(T t) {
        if (t==null)
            return true;
        return this.push(t)==t;

    }

    @Override
    public boolean remove(Object o) {
        int n=0;
        for(int i=0; i<size; i++){
            if (stack[i].equals(o)){
                n=i;
                break;
            }
        }
        if (n!=0){
        for (int i=n; i<size-1; i++){
            stack[i]=stack[i+1];
        }
        stack[size--]=null;
        return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c==null)
            return true;
        int i=0;
        for(Object item :c){
            if (this.contains(item)){
                i++;
            }
        }
        return i==c.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T item:c){
            this.add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c==null)
            return false;
        int i=0;
        for(Object item :c){
            if (this.remove(item)){
                i++;
            }
        }
        return i!=0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        T [] arr =(T[])new Object[_Maxsize];
        int i=0;
        for (Object item: c){
            if (this.contains(item)){
                arr[i++]=(T)item;
            }
        }
        stack=arr;
        size =i;

        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(stack, null);
        size=0;
    }

    //@Override
    public int capacity(){return _Maxsize;}


    public T peek(){return stack[size-1];}

    //@Override
    public boolean empty(){return size==0;}


    public T pop(){
    T tmp = stack[size-1];
        stack[size-1] =null;
        size --;
        return tmp;
    }

    public int search(T object){
    int n=-1;
        for (int i = 0; i < size; i++) {
            if (stack[i].equals(object))
                {
                    n=i;
                    break;
                }
        }
        return (n==-1)?-1:size-n;
    }



    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(stack[i]);
        }
    }

    public T get(int i){
        if (i<0||i>=size)
            new IndexOutOfBoundsException();
        return stack[i];

    }

}
