import java.util.Random;

class Workstation implements Runnable {
    private final Board board;
    private final int numSlots;
    private final Random rand;

    public Workstation(Board board, int numSlots) {
        this.board = board;
        this.numSlots = numSlots;
        this.rand = new Random();
    }

    @Override
    public void run() {
        int position = numSlots / 2;
        for (int i = 0; i < numSlots; i++) {
            position += rand.nextInt(2) * 2 - 1;
            position = Math.max(0, Math.min(position, numSlots - 1));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        board.incrementSlot(position);
    }
}