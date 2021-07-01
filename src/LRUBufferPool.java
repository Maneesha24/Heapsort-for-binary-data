import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The BufferPool class implements a BufferPool which holds the pool of buffers
 * 
 * @author maneesha24@vt.edu
 * @version 1.0
 */
public class LRUBufferPool {

    private RandomAccessFile fileDisk;
    private LRUBuffer[] pool;
    private int sizeValue;
    private CustomDoublyLinkedList<LRUBuffer> lruBuffer;
    private UtilsFunc utilsFunc;

    /**
     * This method initializes the buffer pool with the arguments taken
     * 
     * @param fileName
     *            file to be sorted
     * @param num
     *            is the number of buffers
     * @param utils
     *            utilsfunction class
     * @throws IOException
     *             thrown if file doesnt exist
     */
    public LRUBufferPool(File fileName, int num, UtilsFunc utils)
        throws IOException {
        fileDisk = new RandomAccessFile(fileName, "rw");
        sizeValue = ((int)fileDisk.length() / 4096);
        pool = new LRUBuffer[sizeValue];
        lruBuffer = new CustomDoublyLinkedList<LRUBuffer>(num);
        utilsFunc = utils;
    }


    /**
     * checks to see if buffer was used
     * 
     * @param bufferValue
     *            buffer to be checked
     * @throws IOException
     */
    public void getUsed(LRUBuffer bufferValue) throws IOException {
        // Returns the value if the value is either shifted or if its added
        LRUBuffer removedValue = lruBuffer.shiftAddNode(bufferValue);
        // Flush the buffer if the value is removed and if the buffer is used
        if (removedValue != null && bufferValue.getBufferUsed()) {
            bufferValue.flushBuffer();
        }
    }


    /**
     * This method is used to retrieve the buffer at a given index point
     * 
     * @param indexVal
     *            index of buffer
     * 
     * @return the value of the buffer at the index taken as the argument in the
     *         pool
     */
    public LRUBuffer getBuffer(int indexVal) {
        // If the value is null, create a new buffer value
        if (pool[indexVal] == null) {
            pool[indexVal] = new LRUBuffer(this, fileDisk, (indexVal * 4096),
                4096, utilsFunc);
        }
        // Return the value of buffer at the index in the pool
        return pool[indexVal];
    }


    /**
     * gets the max size of pool
     * 
     * @return maximum buffers
     */
    public int getSize() {
        return sizeValue;
    }


    /**
     * The method is used to flush the data once the query is done
     * 
     * @throws IOException
     */
    public void flush() throws IOException {
        for (int i = 0; i < sizeValue; i++) {
            // This flushes all the buffers in the pool
            pool[i].flushBuffer();
        }
    }

}
