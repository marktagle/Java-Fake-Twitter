import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


    class Registration extends JFrame {
            //Controls.
        Icon submit=new ImageIcon("btns/signupBtn.png");
        JButton btnSubmit=new JButton(submit);
        Icon submitPrsd=new ImageIcon("btns/signupBtnPressed.png");

            //Labels
        JLabel bg;
        JLabel twttrLogo=new JLabel();

        JLabel USERNAME=new JLabel("Username @");
        JLabel PASSWORD=new JLabel("Password");
        JLabel NAME=new JLabel("Name");

        JLabel BIRTHDAY=new JLabel("Date of Birth");
        JLabel LOCATION=new JLabel("Address");
        JLabel SCHOOL=new JLabel("School");
        JLabel CELLPHONE=new JLabel("Cellphone # ");
        JLabel GENDER=new JLabel("Gender");

        JRadioButton Male=new JRadioButton("Male");
        JRadioButton Female=new JRadioButton("Female");

        JComboBox Month=new JComboBox();
        JComboBox Day=new JComboBox();
        JComboBox Year=new JComboBox();

            //Text fields
        JTextField txt1=new JTextField();
        JPasswordField txt2=new JPasswordField();
        JTextField txt3=new JTextField();
        JTextField txt4=new JTextField();
        JTextField txt5=new JTextField();
        JTextField txt6=new JTextField();

        Registration() {

            setTitle("Register");
            setSize(800,640);
            initcomps();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
            setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
            try {
                setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
            }
            catch(Exception e) {}
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        void initcomps() {
            Container cn=getContentPane();
            bg=new JLabel(new ImageIcon("btns/RegisterBg.png"));
            bg.setLayout(new FlowLayout());
            cn.setBackground(Color.WHITE);

            twttrLogo.setBounds(373,2,20,20);
            twttrLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            twttrLogo.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    new login();
                    dispose();
                }
            });

                //Username label
            USERNAME.setBounds(230,100,200,30);
                //Password label
            PASSWORD.setBounds(230,140,200,30);
                //Name label
            NAME.setBounds(230,180,200,30);

                //Birthday label
            BIRTHDAY.setBounds(230,220,200,30);
                //location label
            LOCATION.setBounds(230,260,200,30);
                //School label
            SCHOOL.setBounds(230,300,200,30);

            GENDER.setBounds(230,340,200,30);

            CELLPHONE.setBounds(230,380,200,30);


            //---------------text fields bounds

                //Username text field
            txt1.setBounds(350,100,200,30);

                //password text field
            txt2.setBounds(350,140,200,30);

                //Name text field
            txt3.setBounds(350,180,200,30);

                //Birthday Combobox
            Month.setBounds(350,220,100,30);
            Day.setBounds(480,220,80,30);
            Year.setBounds(600,220,100,30);

                //Location/Address text field
            txt4.setBounds(350,260,200,30);

                //School text field
            txt5.setBounds(350,300,200,30);

                //Gender Buttons
            Male.setBounds(350,340,60,30);
            Female.setBounds(450,340,70,30);

                //Cellphone # text field
            txt6.setBounds(350,380,200,30);


                //Submit button
            btnSubmit.setBounds(260,450,293,33);
            btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnSubmit.setBorderPainted(false);
            btnSubmit.setContentAreaFilled(false);
            btnSubmit.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnSubmit.setIcon(submitPrsd);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    btnSubmit.setIcon(submitPrsd);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    btnSubmit.setIcon(submit);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btnSubmit.setIcon(submitPrsd);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnSubmit.setIcon(submit);
                }
            });


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //File fl=new File("Acc/"+txt1.getText());
                //fl.mkdir();
                if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") ||
                        txt5.getText().equals("") || txt6.getText().equals("") || Month.getSelectedItem().equals("Month") ||
                        Day.getSelectedItem().equals("Day") || Year.getSelectedItem().equals("Year") || Male.getText().equals("") ||
                        Female.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Register Failed! Please Fill all the Information");
                } else {
                    try {
                        //File dir=new File("Acc/"+txt1.getText());
                        PrintStream in = new PrintStream(new FileOutputStream("Accounts/" + txt1.getText() + ".txt"));

                        //PrintStream in = new PrintStream(new FileOutputStream(fl+".txt"));
                        in.println(txt1.getText());
                        //Passwords stored in Acc folder
                        in.println(txt2.getText());

                        //Name stored in Acc folder
                        in.println(txt3.getText());

                        //Birthday stored in Acc folder
                        in.print(Month.getSelectedItem());
                        in.print(Day.getSelectedItem());
                        in.println(Year.getSelectedItem());

                        //Location stored in Acc folder
                        in.println(txt4.getText());

                        //School stored in Acc folder
                        in.println(txt5.getText());

                        //Gender stored in Acc folder
                        if (Male.isSelected()) {
                            in.println(Male.getText());
                        } else if (Female.isSelected()) {
                            in.println(Female.getText());
                        }

                        //Cellphone stored in Acc folder
                        in.println(txt6.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Register Failed!");
                    }

                    JOptionPane.showMessageDialog(null, "Register Successful!");
                    new login();
                    dispose();
                }
            }
            });

                //add all controls
            cn.add(twttrLogo);
            cn.add(USERNAME);
            cn.add(PASSWORD);
            cn.add(NAME);
            cn.add(BIRTHDAY);
            cn.add(LOCATION);
            cn.add(SCHOOL);
            cn.add(GENDER);
            cn.add(CELLPHONE);
            cn.add(txt1);
            cn.add(txt2);
            cn.add(txt3);

                //Birthday
            cn.add(Month);
            cn.add(Day);
            cn.add(Year);

            Month.addItem("Month ");
            Month.addItem("January ");
            Month.addItem("February ");
            Month.addItem("March ");
            Month.addItem("April ");
            Month.addItem("May ");
            Month.addItem("June ");
            Month.addItem("July ");
            Month.addItem("August ");
            Month.addItem("September ");
            Month.addItem("October ");
            Month.addItem("November ");
            Month.addItem("December ");

            Day.addItem("Day ");
            Year.addItem("Year");

                //Day/Year loop
            for(int i=1;i<=31; i++) {
                Day.addItem(i+" ");
            }
            for(int l=1900; l<=2016; l++) {
                Year.addItem(l);
            }

            Month.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(Month.getSelectedItem().equals("February")) {
                        Day.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(Year.getSelectedItem().equals("2012") || Year.getSelectedItem().equals("2016") || Year.getSelectedItem().equals("2008") ||
                                        Year.getSelectedItem().equals("2004")|| Year.getSelectedItem().equals("2000")|| Year.getSelectedItem().equals("1996")
                                        || Year.getSelectedItem().equals("1992")|| Year.getSelectedItem().equals("1988")|| Year.getSelectedItem().equals("1984")
                                        || Year.getSelectedItem().equals("1980")|| Year.getSelectedItem().equals("1976")|| Year.getSelectedItem().equals("1972")
                                        || Year.getSelectedItem().equals("1968")|| Year.getSelectedItem().equals("1964")|| Year.getSelectedItem().equals("1960")
                                        || Year.getSelectedItem().equals("1956")|| Year.getSelectedItem().equals("1952")|| Year.getSelectedItem().equals("1948")
                                        || Year.getSelectedItem().equals("1944")|| Year.getSelectedItem().equals("1940")|| Year.getSelectedItem().equals("1936")
                                        || Year.getSelectedItem().equals("1932")|| Year.getSelectedItem().equals("1928")|| Year.getSelectedItem().equals("1924")
                                        || Year.getSelectedItem().equals("1920")|| Year.getSelectedItem().equals("1916")|| Year.getSelectedItem().equals("1912")
                                        || Year.getSelectedItem().equals("1908")|| Year.getSelectedItem().equals("1904")|| Year.getSelectedItem().equals("1900"))
                                {
                                    DefaultListModel mods= (DefaultListModel) Day.getModel();
                                    mods.removeAllElements();
                                    Day.addItem("Day");
                                        for(int d=1; d<=29; d++) {
                                            mods.addElement(d);
                                        }
                                }
                                else {
                                    DefaultComboBoxModel modes=(DefaultComboBoxModel) Day.getModel();
                                    modes.removeAllElements();
                                    Day.addItem("Day");
                                    for(int d=1;d<=28;d++) {
                                        modes.addElement(d);
                                    }
                                }
                            }
                        });
                        DefaultComboBoxModel models=(DefaultComboBoxModel) Day.getModel();
                        models.removeAllElements();
                        Day.addItem("Day");
                        for(int d=1;d<=28;d++) {
                            models.addElement(d);
                        }
                    }
                    else if(Month.getSelectedItem().equals("April") || Month.getSelectedItem().equals("June") ||
                            Month.getSelectedItem().equals("September") || Month.getSelectedItem().equals("November")) {
                        DefaultComboBoxModel model=(DefaultComboBoxModel) Day.getModel();
                        model.removeAllElements();
                        Day.addItem("Day");
                        for(int d=1;d<=30;d++) {
                            model.addElement(d);
                        }
                    }
                    else {
                        DefaultComboBoxModel model=(DefaultComboBoxModel) Day.getModel();
                        model.removeAllElements();
                        Day.addItem("Day");
                        for(int d=1;d<=31;d++) {
                            model.addElement(d);
                        }
                    }
                }
            });

                //Location/School
            cn.add(txt4);
            cn.add(txt5);

                // Gender
            ButtonGroup btnGrp=new ButtonGroup();
                btnGrp.add(Male);
                btnGrp.add(Female);

            cn.add(Male);
            cn.add(Female);

                //Cellhpone/Button Submit/Background
            cn.add(txt6);
            cn.add(btnSubmit);
            cn.add(bg);

        }
    }

