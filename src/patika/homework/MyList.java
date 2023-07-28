package patika.homework;

import java.util.Arrays;

public class MyList<T> {
    private T [] arr;
    private int size;
    private int capacity;
    public MyList()
    {
        this(10);
    }
    public MyList(int capacity)
    {
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }
    private void setLength()
    {
        arr = Arrays.copyOf(arr, arr.length * 2);
        capacity = arr.length;
    }
    public int size()
    {
        return size;
    }
    public int capacity()
    {
        return capacity;
    }
    public void add(T data)
    {
        if (size == capacity)
            setLength();

        arr[size] = data;
        ++size;
    }
    public T getIndex(int index)
    {
        if (index > capacity || index > size)
            return null;

        return arr[index];
    }
    public T removeIndex(int index)
    {
        var temp = getIndex(index);

        for (var i = index + 1; i < size; ++i)
            arr[i - 1] = arr[i];
        arr[--size] = null;

        return temp;
    }
    public T setIndex(int index, T data)
    {
        if (data == null)
            throw new IllegalArgumentException();

        var temp = getIndex(index);
        arr[index] = data;
        return temp;
    }
    public String toString()
    {
        var sb = new StringBuilder();
        sb.append('[');

        for (T t: arr) {
            if (t == null)
                break;
            sb.append(t).append(',');
        }

        return sb.deleteCharAt(sb.length() - 1).append(']').toString();
    }
}
