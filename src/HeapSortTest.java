import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;

/**
 * The HeapSortTest class implements test cases for testing methods and
 * variables for heap sort
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class HeapSortTest {

    /**
     * tests the sample input file and returns true if it matches the standard
     * output printed with input value 2
     * 
     * @throws IOException
     */
    @Test
    public void testSampleFile2() throws IOException {

        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStreamCaptor));
        HeapSort.main(new String[] { "SampleInput.dat", "2",
            "SampleOutputStat.txt" });
        assertEquals("5 8404 8131 244 16634 2746 24619 6627 ",
            outputStreamCaptor.toString());

    }
}
