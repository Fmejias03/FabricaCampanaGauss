import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private int[] slots;
    private int maxCount;

    public Board(int numSlots) {
        slots = new int[numSlots];
        maxCount = 1;
    }

    public void incrementSlot(int slot) {
        slots[slot]++;
        maxCount = Math.max(maxCount, slots[slot]);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (slots == null) return;

        int width = getWidth();
        int height = getHeight();
        int slotWidth = width / slots.length;

        g.setColor(Color.RED);
        for (int i = 0; i < slots.length; i++) {
            int barHeight = (int) ((double) slots[i] / maxCount * height);
            g.fillRect(i * slotWidth, height - barHeight, slotWidth, barHeight);
        }
    }

    public Component take() {
        return null;
    }
}