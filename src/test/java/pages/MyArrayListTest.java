package pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by admin on 7/25/16.
 */
public class MyArrayListTest {
    MyArrayList myArrayList = new MyArrayList();

    {
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i+1);
        }
    }

    @Test
    public void testGet_0() throws Exception {
        System.out.println("1");
        Assert.assertEquals(myArrayList.get(0), 1);
    }

    @Test
    public void testGet_9() throws Exception {
        System.out.println("2");
        Assert.assertEquals(myArrayList.get(9), 10);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testGet_NegativeSize() {
        System.out.println("3");
            myArrayList.get(myArrayList.size());
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testGet_NegativeMinusOne() {
        System.out.println("4");
        myArrayList.get(-1);
    }
    @Test
    public void testAdd_111() throws Exception {
        myArrayList.add(111);
        System.out.println("5");
        Assert.assertEquals(myArrayList.get(myArrayList.size() -1), 111);
    }

    @Test
    public void testInsert_555toIndex5() throws Exception {
        myArrayList.insert(555, 5);
        System.out.println("6");
        Assert.assertEquals(myArrayList.get(5), 555);
    }

    @Test
    public void testInsert_222toDefaultIndex() throws Exception {
        myArrayList.insert(222);
        System.out.println("7");
        Assert.assertEquals(myArrayList.get(0), 222);
    }

    @Test
    public void testSize() throws Exception {
        System.out.println("8");
        Assert.assertEquals(myArrayList.size(), 13);
    }

    @Test
    public void testEquals() throws Exception {
        System.out.println("9");
        myArrayList = new MyArrayList();
        MyArrayList myArrayList2 = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            myArrayList2.add(i);
            myArrayList.add(i);
        }
        assertEquals(myArrayList, myArrayList2);
    }
/*
    @Test
    public void testHashCode() throws Exception {

    }
*/
}