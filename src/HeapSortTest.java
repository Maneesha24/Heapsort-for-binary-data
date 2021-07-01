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
     * Create a instance of the HeapSort class
     */
    private HeapSort heap = new HeapSort();

    /**
     * tests the sample input file and returns true if it matches the standard
     * output printed with input buffers 10
     * 
     * @throws IOException
     */
    @Test
    public void testSampleFile10() throws IOException {

        // This class implements an output stream in which the data is written
        // into a byte array
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        // setOut reassigns the standard output stream
        System.setOut(new PrintStream(outputStreamCaptor));
        heap.main(new String[] { "SampleInput.dat", "10",
            "SampleOutputStat.txt" });
        // Passes the test if the expected result matches the printed result
        assertEquals("5 8404 8131 244 16634 2746 24619 6627 ",
            outputStreamCaptor.toString());

    }
    
    /**
     * tests the sample input file and returns true if it matches the standard
     * output printed with input buffers 1
     * 
     * @throws IOException
     */
    @Test
    public void testSampleFile1() throws IOException {

        // This class implements an output stream in which the data is written
        // into a byte array
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        // setOut reassigns the standard output stream
        System.setOut(new PrintStream(outputStreamCaptor));
        heap.main(new String[] { "SampleInput.dat", "1",
            "SampleOutputStat.txt" });
        // Passes the test if the expected result matches the printed result
        assertEquals("5 8404 8131 244 16634 2746 24619 6627 ",
            outputStreamCaptor.toString());

    }
}
