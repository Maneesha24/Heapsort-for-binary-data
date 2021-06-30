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

//    private static LRUBufferPool bufferPool = null;
//    private static int poolSize = 0;

//    private static int hits = 0;
//    private static int misses = 0;
//    private static int reads = 0;
//    private static int writes = 0;
    private static int timeTaken = 0;

    /**
     * This is the entry point of the application
     * 
     * @param arg
     *            Command line arguments
     */
    public static void main(String[] arg) throws IOException {
        
//        bufferPool = new LRUBufferPool(new File(arg[0]), Integer.parseInt(
//            arg[1]));
//        poolSize = getNumOfRecords();

        UtilsFunc utils = new UtilsFunc();
        
        CustomHeap customHeap = new CustomHeap(arg[0], Integer.parseInt(
            arg[1]), utils);
        
        
        int startTime = (int)System.currentTimeMillis();
        
        customHeap.sortHeap();
        
        customHeap.flushHeap();

        int endTime = (int)System.currentTimeMillis();

        timeTaken = endTime - startTime;

//        outputStatsFile(arg[2]);
                
        utils.outputStatsFile(arg[2], arg[0], timeTaken);

        customHeap.printOutput();
    }


//    /**
//     * This is the method that increments the value of misses by
//     * 1 and returns the value
//     * 
//     */
//    public static void incrementMisses() {
//        misses = misses + 1;
//    }
//
//
//    /**
//     * This is the method that returns the value of misses
//     * 
//     * @return the value of misses values
//     * 
//     */
//    public static int getMissesValue() {
//        return misses;
//    }
//
//
//    /**
//     * This is the method that returns the value of hits
//     * 
//     * @return the value of hits values
//     * 
//     */
//    public static int getHitsValue() {
//        return hits;
//    }
//
//
//    /**
//     * This is the method that returns the value of reads
//     * 
//     * @return the value of hits values
//     * 
//     */
//    public static int getReadsValue() {
//        return reads;
//    }
//
//
//    /**
//     * This is the method that increments the value of reads by
//     * 1 and returns the value
//     * 
//     */
//    public static void incrementReads() {
//        reads = reads + 1;
//    }
//
//
//    /**
//     * This is the method that increments the value of writes by
//     * 1 and returns the value
//     * 
//     */
//    public static void incrementWrites() {
//        writes = writes + 1;
//    }
//
//
//    /**
//     * This is the method that increments the value of hits by
//     * 1 and returns the value
//     * 
//     */
//    public static void incrementHits() {
//        hits = hits + 1;
//    }

}
