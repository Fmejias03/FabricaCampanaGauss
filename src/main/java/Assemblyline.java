class Assemblyline implements Runnable {
    private final Board board;

    public Assemblyline(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Component component = board.take();
                assembleMachine(component);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void assembleMachine(Component component) throws InterruptedException {
        System.out.println("Assembling " + component);
        Thread.sleep(250);
    }
}
