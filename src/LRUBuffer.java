import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The LRUBuffer class implements a buffer
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class LRUBuffer {
    private LRUBufferPool pool;
    private RandomAccessFile file;
    private Boolean bufferUsed = false;
    private int length;
    private int offset;
    private boolean taken = false;
    private UtilsFunc utils;
    private byte[] data;

    /**
     * This method is used to initialize the buffer with the arguments
     * 
     * @param bufferPool
     *            is the value of the buffer pool
     * @param fileDisk
     *            random access file
     * @param offsetValue
     *            offset of buffer
     * @param sizeValue
     *            size of buffer
     * @param utilsValue
     *            holds the util function
     */
    public LRUBuffer(
        LRUBufferPool bufferPool,
        RandomAccessFile fileDisk,
        int offsetValue,
        int sizeValue,
        UtilsFunc utilsValue) {

        pool = bufferPool;
        length = sizeValue;
        file = fileDisk;
        offset = offsetValue;
        utils = utilsValue;

    }


    /**
     * This method writes the data to the storage array
     * 
     * @param byteValue
     *            is the value to be pushed to the array
     * @throws IOException
     */
    public void bufferWrite(byte[] byteValue) throws IOException {
        pool.getUsed(this);
        this.data = byteValue;
        // Sets the value of taken and if the buffer is filled/user to true
        this.taken = true;
        this.bufferUsed = true;
    }


    /**
     * This method is used to flush the value once the query is done
     * 
     * @throws IOException
     */
    public void flushBuffer() throws IOException {
        // Increment the number of disk writes
        utils.incrementWrites();
        // Seek sets the current file position in the stream to be the
        // offset value
        file.seek(offset);
        // writes bytes from the specified byte array starting at offset
        // off to this file
        file.write(data);
        // Reset the bufferUsed variable once written
        bufferUsed = false;
        // Once flushed, assign the data to be null and buffer position filled
        // taken variable to be null
        data = null;
        taken = false;
    }


    /**
     * This methods reads the data from the block from the input file
     * 
     * @return the block data stored
     * @throws IOException
     */
    public byte[] readBlock() throws IOException {
        pool.getUsed(this);
        // Check if the buffer position is filled
        if (!taken) {
            // Increment the number of misses
            utils.incrementMisses();

            data = new byte[length];
            // Increment the number of disk reads
            utils.incrementReads();

            // Seek sets the current file position in the stream to be the
            // offset value
            file.seek(offset);
            file.read(data);

            taken = true;
            bufferUsed = false;
        }
        else {
            // Increment the number of cache hits
            utils.incrementHits();
        }
        return data;
    }


    /**
     * This method returns the value of the buffer used variable
     * 
     * @return the value of the buffer used.
     */
    public Boolean getBufferUsed() {
        return bufferUsed;
    }
}
