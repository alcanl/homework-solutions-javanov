// The class which represents a copy of ArrayList<E> class in JavaSE

package org.csystem.homework.solution.csd_arraylist_class;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class CsdArrayList<E> {
    private E [] arr;
    private int size;
    private int capacity;
    private void swipeListIndexToSize(int index)
    {
        for (var i = size; i > index; --i)
            arr[i] = arr[i - 1];
    }
    private void swipeListSizeToIndex(int index)
    {
        for (var i = index + 1; i < size; ++i)
            arr[i - 1] = arr[i];
        arr[--size] = null;
    }
    private boolean isInvalidIndex(int index)
    {
        return index < 0 || index > size;
    }
    private void setLength(int capacity)
    {
        arr = Arrays.copyOf(arr, capacity);
        this.capacity = arr.length;
    }
    public CsdArrayList()
    {
        this(10);
    }
    public CsdArrayList(int capacity)
    {
        arr = (E[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }
    public void add(E element)
    {
        add(size, element);
    }
    public void add(int index, E element)
    {
        if (size == capacity)
            setLength(capacity * 2);

        if (isInvalidIndex(index))
            throw new IndexOutOfBoundsException();

        swipeListIndexToSize(index);
        arr[index] = element;
        ++size;
    }
    public int capacity()
    {
        return capacity;
    }
    public void clear()
    {
        arr = (E[]) new Object[capacity];
        size = 0;
    }
    public E [] clone()
    {
        return Arrays.copyOf(arr, capacity);
    }
    public boolean contains(Object o)
    {
        return indexOf(o) >= 0;
    }
    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity <= this.capacity)
            return;
        else
            setLength(Math.max(minCapacity, this.capacity * 2));
    }
    public void forEach(Consumer<? super E> action)
    {
        Arrays.stream(arr).limit(size).forEach(action);
    }
    public int indexOf(Object o)
    {
        for (var i = 0; i < size; ++i)
            if (arr[i].equals(o))
                return i;

        return -1;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public E get(int index)
    {
        if (isInvalidIndex(index) || index == size)
            throw new IndexOutOfBoundsException();

        return arr[index];
    }
    public int lastIndexOf(Object o)
    {
        for (var i = size -1; i > 0; --i)
            if (arr[i].equals(o))
                return i;

        return -1;
    }
    public E remove(int index)
    {
        if (isInvalidIndex(index))
            throw new IndexOutOfBoundsException();

        var temp = get(index);
        swipeListSizeToIndex(index);
        return temp;
    }
    public boolean remove(Object o)
    {
        var temp = this.indexOf(o);
        if (temp == -1)
            return false;

        remove(temp);
        return true;
    }
    public void replaceAll(UnaryOperator<E> operator)
    {
        Arrays.stream(arr).limit(size).forEach(operator::apply);
    }
    public E set(int index, E element)
    {
        if (isInvalidIndex(index) || index == size)
            throw new IndexOutOfBoundsException();

        if (element == null)
            throw new IllegalArgumentException();

        var temp = get(index);
        arr[index] = element;
        return temp;
    }
    public int size()
    {
        return size;
    }
    public Object toArray()
    {
        return Arrays.copyOf(arr, size);
    }
    public void trimToSize()
    {
        arr = Arrays.copyOf(arr, size);
        capacity = size;
    }
    public String toString()
    {
        var sb = new StringBuilder();
        sb.append('[');

        for (E e: arr) {
            if (e == null)
                break;
            sb.append(e).append(',');
        }
        if (this.isEmpty())
            return sb.append(']').toString();

        return sb.deleteCharAt(sb.length() - 1).append(']').toString();
    }
}
