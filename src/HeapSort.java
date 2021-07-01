import java.io.IOException;

/**
 * A memory manager package for variable length
 * records, and a spatial data structure to support
 * geographical queries.
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class HeapSort {

    private static int timeTaken = 0;

    /**
     * This is the entry point of the application
     * 
     * @param arg
     *            Command line arguments
     */
    public static void main(String[] arg) throws IOException {

        UtilsFunc utils = new UtilsFunc();

        CustomHeap customHeap = new CustomHeap(arg[0], Integer.parseInt(arg[1]),
            utils);

        // StartTime variable holds the value when the sorting starts
        int startTime = (int)System.currentTimeMillis();

        // This method is responsible for sorting our heap
        customHeap.sortHeap();

        // This method flushes once done
        customHeap.flushHeap();

        // endTime variable holds the value when the sorting lasts
        int endTime = (int)System.currentTimeMillis();

        // TimeTaken variable calculates the execution time
        timeTaken = endTime - startTime;

        // This method creates a stats file with arg[2] provided and writes
        // statistics to the file
        utils.outputStatsFile(arg[2], arg[0], timeTaken);

        // This method prints the output
        customHeap.printOutput();
    }

}
