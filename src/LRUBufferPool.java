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
    private CustomDoublyLinkedList<LRUBuffer> lruBuffer;
    private LRUBuffer[] pool;
    private int sizeValue;
    private UtilsFunc utilsFunc;

    /**
     * This method initializes the buffer pool with the arguments taken
     * 
     * @param file
     *            file to be sorted
     * @param num
     *            is the number of buffers
     * @param utils
     *            utilsfunction class
     * @throws IOException
     *             thrown if file doesnt exist
     */
    public LRUBufferPool(File file, int num, UtilsFunc utils)
        throws IOException {
        fileDisk = new RandomAccessFile(file, "rw");
        sizeValue = ((int)fileDisk.length() / 4096);
        pool = new LRUBuffer[sizeValue];
        lruBuffer = new CustomDoublyLinkedList<LRUBuffer>(num);
        utilsFunc = utils;
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
        if (pool[indexVal] == null) {
            pool[indexVal] = new LRUBuffer(this, fileDisk, (indexVal * 4096),
                4096, utilsFunc);
        }
        return pool[indexVal];
    }


    /**
     * checks to see if buffer was used
     * 
     * @param bufferValue
     *            buffer to be checked
     * @throws IOException
     */
    public void getUsed(LRUBuffer bufferValue) throws IOException {
        LRUBuffer removedValue = lruBuffer.shiftAddNode(bufferValue);
        if (removedValue != null && bufferValue.getBufferUsed()) {
            bufferValue.flushBuffer();
        }
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
            pool[i].flushBuffer();
        }
    }

}
