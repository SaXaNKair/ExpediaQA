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
        Assert.assertEquals(myArrayList.get(0), 1);
    }

    @Test
    public void testGet_9() throws Exception {
        Assert.assertEquals(myArrayList.get(9), 10);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testGet_NegativeSize() {
            myArrayList.get(myArrayList.size());
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testGet_NegativeMinusOne() {
        myArrayList.get(-1);
    }
    @Test
    public void testAdd_111() throws Exception {
        myArrayList.add(111);
        Assert.assertEquals(myArrayList.get(myArrayList.size() -1), 111);
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsert1() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

}