import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class CustomHeap {

    private static LRUBufferPool bufferPool;
    private static int heapSize;

    public CustomHeap(String fileName, int num, UtilsFunc utils)
        throws IOException {
        bufferPool = new LRUBufferPool(new File(fileName), num, utils);
        heapSize = getNumOfRecords();
    }


    /**
     * The method is used to flush the data once the query is done
     * 
     * @throws IOException
     */
    public void flushHeap() throws IOException {
        bufferPool.flush();
    }


    /**
     * This method returns the value of the total number of records present by
     * multiplying the max size with 1024 bytes (4096 / 4)
     * 
     * @return the value of the total number of records present
     */
    public static int getNumOfRecords() {
        return bufferPool.getSize() * 1024;
    }


    /**
     * This method sorts the heap by using max heap algorithm
     * 
     * @throws IOException
     */
    public void sortHeap() throws IOException {
        for (int i = (heapSize / 2) - 1; i >= 0; i--) {
            shiftValues(i);
        }

        for (int i = 0; i < getNumOfRecords(); i++) {
            swapValues(0, heapSize - 1);
            heapSize--;
            shiftValues(0);
        }
    }


    /**
     * This method sorts the heap into its respective position
     * 
     * @param index
     *            the index of the node to shiftdown
     * @throws IOException
     */
    public static void shiftValues(int index) throws IOException {

        if ((index >= heapSize) || index < 0) {
            return;
        }

        while (!((index >= heapSize / 2) && (index < heapSize))) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if ((leftChild < (heapSize - 1)) && (getKeyValue(
                leftChild) < getKeyValue(rightChild))) {
                leftChild++;
            }

            if (getKeyValue(index) >= getKeyValue(leftChild)) {
                return;
            }

            swapValues(index, leftChild);

            index = leftChild;
        }
    }


    /**
     * The method returns the value of the key in the array
     * 
     * @param indexVal
     *            is the value of the index
     * @return the value of the key
     * @throws IOException
     */
    public static short getKeyValue(int indexVal) throws IOException {
        int block = indexVal / 1024;
        int offset = (indexVal * 4) % 4096;
        byte[] buffer = bufferPool.getBuffer(block).readBlock();
        return ByteBuffer.wrap(buffer).getShort(offset);
    }


    /**
     * gets the value of the array record
     * 
     * @param index
     *            index of record
     * @return value at index
     * @throws IOException
     */
    public static short getValue(int index) throws IOException {
        int blockVal = index / 1024;
        int offsetVal = (index * 4) % 4096;
        byte[] buffer = bufferPool.getBuffer(blockVal).readBlock();
        return ByteBuffer.wrap(buffer).getShort(offsetVal + 2);
    }


    /**
     * This method swaps two values in
     * 
     * @param firstValue
     *            first number to be swapped
     * @param secondValue
     *            second number to be swapped
     * @throws IOException
     */
    public static void swapValues(int firstValue, int secondValue)
        throws IOException {

        LRUBuffer firstBuffer = bufferPool.getBuffer(firstValue / 1024);
        LRUBuffer secondBuffer = bufferPool.getBuffer(secondValue / 1024);

        byte[] value1 = new byte[4];
        byte[] value2 = new byte[4];

        int offsetValue1 = (firstValue * 4) % 4096;
        int offsetValue2 = (secondValue * 4) % 4096;

        byte[] byteBuffer = firstBuffer.readBlock();
        System.arraycopy(byteBuffer, offsetValue1, value1, 0, 4);

        byteBuffer = secondBuffer.readBlock();
        System.arraycopy(byteBuffer, offsetValue2, value2, 0, 4);

        System.arraycopy(value1, 0, byteBuffer, offsetValue2, 4);

        secondBuffer.bufferWrite(byteBuffer);

        byteBuffer = firstBuffer.readBlock();

        System.arraycopy(value2, 0, byteBuffer, offsetValue1, 4);

        firstBuffer.bufferWrite(byteBuffer);
    }


    /**
     * This method prints the values of hits, misses, writes and time to sort.
     * 
     * @throws IOException
     */
    public void printOutput() throws IOException {
        int records = getNumOfRecords() / 1024;
        for (int i = 1; i <= records; i++) {
            System.out.print(getKeyValue((i - 1) * 1024) + " " + getValue((i
                - 1) * 1024) + " ");
        }
    }
}
