import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactoryPrincipal {
    public static void main(String[] args) {
        int numBalls = 100000;
        int numSlots = 30;

        Board board = new Board(numSlots);

        JFrame frame = new JFrame("Fabrica Campana Gauss Galton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(board);
        frame.setVisible(true);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < numBalls; i++) {
            executorService.execute(new Workstation(board, numSlots));
            if (i % 1000 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        executorService.shutdown();
    }
}