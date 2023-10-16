class Buffer {
    private final Component[] buffer;
    private int putPointer, takePointer, count;

    public Buffer(int capacity) {
        this.buffer = new Component[capacity];
    }

    public synchronized void put(Component component) throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }
        buffer[putPointer] = component;
        putPointer = (putPointer + 1) % buffer.length;
        ++count;
        notifyAll();
    }

    public synchronized Component take() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Component component = buffer[takePointer];
        takePointer = (takePointer + 1) % buffer.length;
        --count;
        notifyAll();
        return component;
    }
}
