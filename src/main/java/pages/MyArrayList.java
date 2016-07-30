package pages;

import java.util.Arrays;

/**
 * Created by admin on 7/25/16.
 */
public class MyArrayList {

    private int actualSize = 0;
    private int capacity = 10;
    private int[] arr;

    public MyArrayList(){
        arr = new int[capacity];
    }

    private void resize(){
        if(actualSize > 6 && arr.length - actualSize < 2){
            capacity *= 2;
            int[] tempArr = new int[capacity];
            for (int i = 0; i < actualSize; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
    }

    public int get(int index){
        if (index >= actualSize || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    public void add(int i){
        arr[actualSize] = i;
        actualSize++;
        resize();
    }

    public void insert(int i, int index){
        int temp = arr[index];
        arr[index] = i;
        int temp2;
        for (int j = index; j < arr.length - 1; j++) {
            temp2 = arr[j+1];
            arr[j+1] = temp;
            temp = temp2;
        }
        resize();
    }

    public void insert(int i){
        int index = 0;
        int temp = arr[index];
        arr[index] = i;
        int temp2;
        for (int j = index; j < arr.length - 1; j++) {
            temp2 = arr[j+1];
            arr[j+1] = temp;
            temp = temp2;
        }
        resize();
    }

    public int size(){
        return actualSize;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals method called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList that = (MyArrayList) o;

        if (actualSize != that.actualSize) return false;
        if (capacity != that.capacity) return false;
        return Arrays.equals(arr, that.arr);

    }

    @Override
    public int hashCode() {
        int result = actualSize;
        result = 31 * result + capacity;
        result = 31 * result + Arrays.hashCode(arr);
        System.out.println("HashCode method called " + result);
        return result;
    }
}
