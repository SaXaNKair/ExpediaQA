package pages;

import java.util.*;

/**
 * Created by admin on 5/23/16.
 */


public class Page {
    public String URL;
    public String PAGE_TITLE;

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        List arrayList = new ArrayList();

        long start;
        long end;
        int i;


        for (i = 0; i < 10; i++) {
            linkedList.add(i+1);
        }

        linkedList.add(0, 5);

        for (i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " | ");
        }

        System.out.println();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(40));
    }
}
