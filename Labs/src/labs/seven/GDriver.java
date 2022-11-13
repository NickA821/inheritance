package labs.seven;

/**
 * A simple driver that creates a Clock and advances and prints the state of
 * the Clock once per second.
 *
 * @author Dr. Kreahling
 * @version 2017
 */
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

// TODO stopwatch
public class GDriver extends JPanel {
    private static int num = 0;
    private final static Timer timer = new Timer(1000, null);
    private static JLabel label1;
    private static Clock clock;
    public GDriver() {
        super(new GridLayout(3,3));  //3 rows, 1 column
        JLabel label2;
        String meridies = TimeUtils.isMorning() ? "AM" : "PM";
        clock = new Clock(TimeUtils.getCurrentHour(),
                TimeUtils.getCurrentMinute(),
                TimeUtils.getCurrentSecond(),
                meridies);

        //Create the first label.
        label1 = new JLabel(clock.toString(), JLabel.CENTER);
        label2 = new JLabel();
        label1.setPreferredSize(new Dimension(100,25));
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        //Create tool tips, for the heck of it.
        label1.setToolTipText("Clock");

        //Add the labels.
        add(label2);
        add(label1);

    }


    public static void createAndShowGUI() {
        JFrame      frame    = new JFrame("Clock");
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.add(new GDriver());
        frame.pack();
        frame.setVisible(true);
    }

    public static void update() {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.tick();
                label1.setText(" " +clock.toString());
            }
        };
        timer.addActionListener(listener);
        timer.start();

    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
                update();
            }
        });
    }

}
