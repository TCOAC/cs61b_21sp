package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {

        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);

        broken.addLast(4);
        broken.addLast(5);
        broken.addLast(6);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizeTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                int size2 = broken.size();
                System.out.println("size: " + size + " size2: " + size2);
                assertEquals(size, size2);
            } else if (operationNumber == 2) {
                // getLast
                if (correct.size() > 0 && broken.size() > 0) {
                    int ret = correct.getLast();
                    int ret2 = broken.getLast();
                    System.out.println("getLast(" + ret + ")" + " getLast(" + ret2 + ")");
                    assertEquals(ret, ret2);
                }
            } else if (operationNumber == 3){
                // removeLast
                if (correct.size() > 0 && broken.size() > 0) {
                    int ret = correct.removeLast();
                    int ret2 = broken.removeLast();
                    System.out.println("removeLast(" + ret + ")" + " removeLast(" + ret2 + ")");
                    assertEquals(ret, ret2);
                }
            }
        }
    }

}
