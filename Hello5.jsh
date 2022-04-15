import javax.swing.*;
class HelloFrame extends JFrame {
    HelloFrame() {
        setTitle("Hello Frame");
        setSize(200, 100);
        setLocation(50, 25);
        JLabel label = new JLabel("Hello.");
        add(label);
    }
}
HelloFrame f = new HelloFrame();
f.setVisible(true);