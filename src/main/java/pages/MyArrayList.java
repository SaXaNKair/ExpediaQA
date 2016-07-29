package pages;

import java.util.Arrays;

/**
 * Created by admin on 7/25/16.
 */
public class MyArrayList {

    private int actualSize = 0;
    private int initialSize = 10;
    private int[] arr;

    public MyArrayList(){
        arr = new int[initialSize];
    }

    private void resize(){
        if(actualSize > 6 && arr.length - actualSize < 2){
            initialSize *= 2;
            int[] tempArr = new int[initialSize];
            for (int i = 0; i < actualSize; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
    }

    public int get(int index){
        if (index > initialSize || index < 0)
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
        return initialSize;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals method called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList that = (MyArrayList) o;

        if (actualSize != that.actualSize) return false;
        if (initialSize != that.initialSize) return false;
        return Arrays.equals(arr, that.arr);

    }

    @Override
    public int hashCode() {
        int result = actualSize;
        result = 31 * result + initialSize;
        result = 31 * result + Arrays.hashCode(arr);
        System.out.println("HashCode method called " + result);
        return result;
    }
}
