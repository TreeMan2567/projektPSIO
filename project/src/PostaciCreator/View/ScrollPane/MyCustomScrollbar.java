/*
    Class outline taken from
    http://www.java2s.com/Tutorials/Java/Swing_How_to/JScrollPane/Create_custom_JScrollBar_for_JScrollPane.htm


 */

package PostaciCreator.View.ScrollPane;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MyCustomScrollbar extends BasicScrollBarUI {
    private final Dimension d = new Dimension();

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = Color.DARK_GRAY;
        } else if (isThumbRollover()) {
            color = Color.LIGHT_GRAY;
        } else {
            color = Color.GRAY;
        }
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.setPaint(Color.WHITE);
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
