import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

    class login extends JFrame {
            //Controls.
        JLabel newtwttr=new JLabel("<HTML><FONT COLOR=GRAY>New to Twitter?</FONT></HTML>");
        JLabel bg;

        JLabel empty=new JLabel();

        JTextField txtUN=new JTextField();
        JPasswordField txtPW=new JPasswordField("Password");

        Icon signin=new ImageIcon("btns/LoginBtn.png");
        JButton btnLogin=new JButton(signin);
        Icon insign=new ImageIcon("btns/LoginBtnPressed.png");


        Icon signup=new ImageIcon("btns/twitterSignUpBtn.png");
        JButton btnRegister=new JButton(signup);
        Icon upsign=new ImageIcon("btns/twitterSignUpBtnPressed.png");

        login() {
            setTitle("Fake Twitter");
            setSize(800,640);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
            setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
            try {
                setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
            }
            catch(Exception e) {}
            initComp();
            setLocationRelativeTo(null);
            setVisible(true);
        }

        void initComp() {
            Container cn=getContentPane();
                //background layout
            bg=new JLabel(new ImageIcon("btns/loginBg.png"));
            bg.setLayout(new FlowLayout());
            cn.setBackground(Color.WHITE);

            empty.setBounds(80,5,50,15);
            empty.setCursor(new Cursor(Cursor.HAND_CURSOR));
            empty.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    new login();
                    dispose();
                }
            });
                //text field Username
            txtUN.setBounds(495,90,200,28);

                //txtUN field mouse adapter for clear "Username"
            txtUN.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    txtUN.setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    txtUN.setText("");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    txtUN.setText("Username");
                }

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
            });

            txtUN.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    txtUN.setText("Username");
                }
                @Override
                public void focusLost(FocusEvent e) {}
            });


                //text Password field
            txtPW.setBounds(495,120,140,24);

                //txtPW field mouse adapter for clear "Password"
            txtPW.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    txtPW.setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    txtPW.setText("");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    txtPW.setText("Password");
                }

                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });

            txtPW.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    txtPW.setText("Username");
                }
                @Override
                public void focusLost(FocusEvent e) {}
            });

                //Label new to twitter
            newtwttr.setBounds(495,145,150,30);

                //login button
            btnLogin.setBounds(645,120,53,20);
            btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnLogin.setBorderPainted(false);
            btnLogin.setContentAreaFilled(false);

            btnLogin.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnLogin.setIcon(insign);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    btnLogin.setIcon(insign);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    btnLogin.setIcon(signin);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btnLogin.setIcon(insign);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnLogin.setIcon(signin);
                }
            });

                //login button listener
            btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String un=txtUN.getText();
                    String pw=txtPW.getText();

                        //retrieve credentials from text file here
                    String username="", c_pw="", accnt_name="", bday="", loca="", school="";

                     try {
                            //read from txtfile Users
                        Scanner scn=new Scanner(new FileInputStream("Accounts/"+txtUN.getText()+".txt"));
                            username=scn.nextLine();
                            c_pw=scn.nextLine();
                                //read info from users
                            accnt_name=scn.nextLine();
                            bday=scn.nextLine();
                            loca=scn.nextLine();
                            school=scn.nextLine();
                    }

                    catch(Exception ex) {}

                    if(pw.equals(c_pw)) {
                        JOptionPane.showMessageDialog(null, "Login Successful","",JOptionPane.PLAIN_MESSAGE);

                        Profile prof=new Profile();
                        //prof.dispose();

                        //Wall wll=new Wall();
                        //wll.dispose();

                        //FriendsWall fw=new FriendsWall();
                        //fw.dispose();

                        prof.AccountName=un;
                        //wll.AccountNames=un;
                        //fw.AccountNamess=un;

                        prof.setTitle("Twitter Profile - "+prof.AccountName);
                        //wll.setTitle("Twitter Home - "+wll.AccountNames);
                        //fw.setTitle("Twitter - "+fw.AccountNamess);

                        prof.AccountName(prof.AccountName);
                        //wll.AccountNames(wll.AccountNames);
                        //fw.AccountNamess(fw.AccountNamess);

                            //ProfileInfos to Profile
                        prof.setProfileInfos(accnt_name, un, bday, loca, school);
                        dispose();
                        //wll.setProfileInfos2(accnt_name, un);
                        //dispose();
                        //fw.setFriendInfo(accnt_name, un);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Login Failed!","",JOptionPane.WARNING_MESSAGE);
                }
            });

                //register button
            btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnRegister.setBounds(600,150,100,23);

            btnRegister.setBorderPainted(false);
            btnRegister.setContentAreaFilled(false);

            btnRegister.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnRegister.setIcon(upsign);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    btnRegister.setIcon(upsign);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    btnRegister.setIcon(signup);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btnRegister.setIcon(upsign);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnRegister.setIcon(signup);
                }
            });

            btnRegister.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Registration reg=new Registration();
                    reg.setVisible(true);
                    dispose();
                }
            });

                //add all controls
            cn.add(empty);
            cn.add(txtUN);
            cn.add(txtPW);
            cn.add(newtwttr);
            cn.add(btnLogin);
            cn.add(btnRegister);
            cn.add(bg);

        }
    }