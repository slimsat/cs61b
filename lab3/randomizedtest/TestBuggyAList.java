package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        L1.addLast(4);
        L2.addLast(4);
        L1.addLast(5);
        L2.addLast(5);
        L1.addLast(6);
        L2.addLast(6);
        assertEquals(L1.size(), L2.size());
        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {

            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");

            } else if (operationNumber == 1) {
                // size
                int size1 = L1.size();
                int size2 = L2.size();
                //System.out.println("L1.size: " + size1 );
                //System.out.println("L2.size: " + size2 );
                assertEquals(L1.size(), L2.size());

            }else if (operationNumber == 2) {

                // getLast
                if(L1.size() > 0 && L2.size() > 0){
                    int getlast1 = L1.getLast();
                    int getlast2 = L1.getLast();
                    //System.out.println("L1.getLast( " + getlast1 +")");
                    //System.out.println("L2.getLast( " + getlast2 +")");
                    assertEquals(L1.getLast(), L2.getLast());
                }
            } else if (operationNumber == 3) {
                //removeLast
                if(L1.size() > 1 && L2.size() > 1){
                    int removelast1 = L1.removeLast();
                    int removelast2 = L2.removeLast();
                    //System.out.println("L1.removeLast( " + removelast1 +")");
                    //System.out.println("L2.removeLast( " + removelast2 +")");
                    assertEquals(L1.removeLast(), L2.removeLast());
                }
            }


        }
    }
}
