import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The Buffer class implements a buffer
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class LRUBuffer {
    private LRUBufferPool pool;
    private RandomAccessFile file;
    private int offset;
    private int size;
    private byte[] data;
    private boolean bufferUsed = false;
    private boolean taken = false;
    private UtilsFunc utils;

    /**
     * This method is used to initialize the buffer with the arguments
     * 
     * @param bufferPool
     *            is the value of the buffer pool
     * @param file
     *            random access file
     * @param offset
     *            offset of buffer
     * @param size
     *            size of buffer
     */
    public LRUBuffer(
        LRUBufferPool bufferPool,
        RandomAccessFile fileName,
        int offsetValue,
        int sizeValue,
        UtilsFunc utilsValue) {

        pool = bufferPool;
        file = fileName;
        offset = offsetValue;
        size = sizeValue;
        utils = utilsValue;

    }


    /**
     * This methods reads the data from the block from the input file
     * 
     * @return the block data stored
     * @throws IOException
     */
    public byte[] readBlock() throws IOException {
        pool.getUsed(this);
        if (!taken) {
            utils.incrementMisses();

            data = new byte[size];
            utils.incrementReads();

            file.seek(offset);
            file.read(data);

            taken = true;
            bufferUsed = false;
        }
        else {
            utils.incrementHits();
        }
        return data;
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
        this.taken = true;
        this.bufferUsed = true;
    }


    /**
     * This method is used to flush the value once the query is done
     * 
     * @throws IOException
     */
    public void flushBuffer() throws IOException {

        if (bufferUsed) {
            utils.incrementWrites();
            file.seek(offset);
            file.write(data);
            bufferUsed = false;
        }

        data = null;
        taken = false;
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
