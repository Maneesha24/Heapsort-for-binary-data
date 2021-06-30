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

        int startTime = (int)System.currentTimeMillis();

        customHeap.sortHeap();

        customHeap.flushHeap();

        int endTime = (int)System.currentTimeMillis();

        timeTaken = endTime - startTime;

        utils.outputStatsFile(arg[2], arg[0], timeTaken);

        customHeap.printOutput();
    }

}
