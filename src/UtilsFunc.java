import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UtilsFunc {

    public static int hits = 0;
    public static int misses = 0;
    public static int reads = 0;
    public static int writes = 0;

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
     * @param outputFileName
     *            is the name of the file to be created
     */
    public void outputStatsFile(String outputFilename, String inputFileName, int timeTaken)
        throws IOException {

        BufferedWriter outputFile = new BufferedWriter(new FileWriter(
            outputFilename));
        outputFile.write("------  STATS ------\n");
        outputFile.write("File name: " + inputFileName + "\n");
        outputFile.write("Cache Hits: " + getHitsValue() + "\n");
        outputFile.write("Cache Misses: " + misses + "\n");
        outputFile.write("Disk Reads: " + reads + "\n");
        outputFile.write("Disk Writes: " + writes + "\n");
        outputFile.write("Time to Sort: " + timeTaken + "\n");
        outputFile.close();
    }

}
