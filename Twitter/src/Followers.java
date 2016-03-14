import javax.swing.*;
import java.awt.*;

public class Followers extends JFrame {

    Followers() {
        setTitle("Followers");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void init() {
        Container cn=getContentPane();
        cn.setLayout(null);
    }
}
