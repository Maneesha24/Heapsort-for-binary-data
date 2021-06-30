import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This UtilsFunc class holds all the variable such as hits, misses, reads and
 * writes and records their values to be outputted to a stats file
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class UtilsFunc {

    /**
     * This variable holds the value of cache hits
     */
    private int hits = 0;
    /**
     * This variable holds the value of misses
     */
    private int misses = 0;
    /**
     * This variable holds the value of disk reads
     */
    private int reads = 0;
    /**
     * This variable holds the value of disk writes
     */
    private int writes = 0;

    /**
     * This is the method that increments the value of misses by
     * 1 and returns the value
     * 
     */
    public void incrementMisses() {
        misses = misses + 1;
    }


    /**
     * This is the method that returns the value of misses
     * 
     * @return the value of misses values
     * 
     */
    public int getMissesValue() {
        return misses;
    }


    /**
     * This is the method that returns the value of hits
     * 
     * @return the value of hits values
     * 
     */
    public int getHitsValue() {
        return hits;
    }


    /**
     * This is the method that returns the value of reads
     * 
     * @return the value of hits values
     * 
     */
    public int getReadsValue() {
        return reads;
    }


    /**
     * This is the method that returns the value of writes
     * 
     * @return the value of hits values
     * 
     */
    public int getWritesValue() {
        return writes;
    }


    /**
     * This is the method that increments the value of reads by
     * 1 and returns the value
     * 
     */
    public void incrementReads() {
        reads = reads + 1;
    }


    /**
     * This is the method that increments the value of writes by
     * 1 and returns the value
     * 
     */
    public void incrementWrites() {
        writes = writes + 1;
    }


    /**
     * This is the method that increments the value of hits by
     * 1 and returns the value
     * 
     */
    public void incrementHits() {
        hits = hits + 1;
    }


    /**
     * This method creates a file with filename equal to third argument and
     * prints the values of hits, misses, writes and time to sort.
     * 
     * @throws IOException
     * @param outputFilename
     *            is the name of the file to be created
     * @param inputFileName
     *            is the name of the input file
     * @param timeTaken
     *            is the difference between the start and the end time of
     *            sorting
     */
    public void outputStatsFile(
        String outputFilename,
        String inputFileName,
        int timeTaken)
        throws IOException {

        BufferedWriter outputFile = new BufferedWriter(new FileWriter(
            outputFilename));
        outputFile.write("------  STATS ------\n");
        outputFile.write("File name: " + inputFileName + "\n");
        outputFile.write("Cache Hits: " + getHitsValue() + "\n");
        outputFile.write("Cache Misses: " + getMissesValue() + "\n");
        outputFile.write("Disk Reads: " + getReadsValue() + "\n");
        outputFile.write("Disk Writes: " + getWritesValue() + "\n");
        outputFile.write("Time to Sort: " + timeTaken + "\n");
        outputFile.close();
    }

}
