import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;


class Wall extends JFrame {
    //Controls.
    String AccountNames = "";

    JLabel bg;

    JButton search=new JButton("Search");

    //panel top bar
    JPanel pnlTopbar = new JPanel();

    //panel include Twitter Logo, Account name, DP
    Icon home=new ImageIcon("btns/homeBtn.png");
    JLabel twitterHomeLogo=new JLabel(home);
    Icon homePrssd=new ImageIcon("btns/homePress.png");


        //label tweets/following/followers
    JLabel Tweets=new JLabel("0");
    JLabel Following=new JLabel("0");
    JLabel Followers=new JLabel("0");

    JLabel lblAccountName = new JLabel("<HTML><FONT COLOR=WHITE>YOUR NAME</FONT></HTML>", SwingConstants.RIGHT);

    JLabel lblDP = new JLabel(new ImageIcon("btns/EmptyUser (2)_2.png"));

    //Update Status
    JTextField inp = new JTextField("What's happening?");

    Icon twts = new ImageIcon("btns/tweetBtn.png");
    JButton tweet = new JButton(twts);
    Icon twtsprsd=new ImageIcon("btns/tweetBtnPressed.png");

    JList lst1 = new JList();

    DefaultListModel<String> mdl = new DefaultListModel<String>();
    JScrollPane lst1_scroll = new JScrollPane(lst1);

    JLabel lblDPMain = new JLabel(new ImageIcon("btns/EmptyUser (2).png"));


    //Profile details
    JLabel lblFullName = new JLabel();
    JLabel lblUserName = new JLabel();

    ImageIcon imgs = new ImageIcon("btns/logout.png");
    JButton btnLogout = new JButton(imgs);
    Icon sgmi=new ImageIcon("btns/logoutPressed.png");

    Wall() {
        setSize(800, 650);
        setTitle("Twitter Home - ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
        setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
        try {
            setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
        }
        catch(Exception e) {}
        ImageIcon bgImage = new ImageIcon("btns/TwttrPanel.png");
        pnlTopbar.add(new JLabel(bgImage));
        add(pnlTopbar);
        init();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void AccountNames(String anames) {
        lblAccountName.setText(anames);
    }

    void init() {
        Container cn = getContentPane();

        bg = new JLabel(new ImageIcon("btns/topBar_2.png"));
        bg.setLayout(new FlowLayout());
        cn.setBackground(Color.BLACK);

        search.setBounds(115,8,100,24);
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SearchAcc();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Labels Tweets/Following/Followers
        Tweets.setBounds(65,160,10,10);
        Following.setBounds(125,160,10,10);
        Followers.setBounds(190,160,10,10);

        //Update Status
        lst1.setModel(mdl);
        lst1.setOpaque(false);

        lst1_scroll.setBounds(410, 150, 330, 200);


        inp.setBounds(410, 110, 220, 28);

        tweet.setBounds(660,110,70,25);

        tweet.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tweet.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tweet.setIcon(twtsprsd);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                tweet.setIcon(twtsprsd);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                tweet.setIcon(twts);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                tweet.setIcon(twtsprsd);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tweet.setIcon(twts);
            }
        });

        tweet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inp.getText();

                mdl.addElement(input);

                try {
                    BufferedWriter tw = new BufferedWriter(new FileWriter("tweets/tweet.txt", true));

                    if (inp.equals("What's happening?"))
                        inp.setText("");
                    else
                        inp.setText("What's happening?");

                    //Input write on textfile
                    tw.write(input);
                    tw.newLine();
                    tw.flush();
                    tw.close();
                } catch (Exception ex) {}
            }
        });

            //Open textfile and display in JList
        try {
            File archieve = new File("tweets/tweet.txt");
            FileReader fr = new FileReader(archieve);
            BufferedReader br = new BufferedReader(fr);

            String inps = inp.getText();
            while ((inps = br.readLine()) != null)
                mdl.addElement(inps);
            }
            catch (Exception ex) {
        }

            //JtextField mouse adapter for clear "what's happening?"
        inp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {}
        });
        inp.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {}
        });
        inp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                inp.setText("");
            }
        });
        inp.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {}
        });

        //set bounds top bar panel
        pnlTopbar.setBounds(0, 0, getWidth() + 60, 45);

            //label logo
        twitterHomeLogo.setBounds(40, 9, 58, 28);
        twitterHomeLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        twitterHomeLogo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                twitterHomeLogo.setIcon(homePrssd);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                twitterHomeLogo.setIcon(homePrssd);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                twitterHomeLogo.setIcon(home);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                twitterHomeLogo.setIcon(homePrssd);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                twitterHomeLogo.setIcon(home);
            }
        });

        /*
        twitterHomeLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Wall wl=new Wall();
                wl.setVisible(true);
                dispose();
            }
        });
        */

        lblDP.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblDP.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Profile prof=new Profile();
                prof.setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Profile prof=new Profile();
                prof.setVisible(true);
                dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

            //Account name label
        lblAccountName.setBounds(getWidth() - 370, 5, 150, 25);
        lblAccountName.setForeground(Color.BLACK);

            //logout--button Logout setBounds
        btnLogout.setBounds(getWidth() - 170, 5, 153, 25);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnLogout.setIcon(sgmi);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                btnLogout.setIcon(sgmi);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                btnLogout.setIcon(imgs);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogout.setIcon(sgmi);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogout.setIcon(imgs);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new login();
                dispose();
            }
        });

            //Change DP

                    /*public ImageIcon ResizeImage(String ImagePath) {
                        ImageIcon MyImage = new ImageIcon(ImagePath);
                        Image img = MyImage.getImage();
                        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon image = new ImageIcon(newImg);
                        return image;
                    } */

        lblDP.setBounds(getWidth() - 210, 5, 24, 24);
        lblDPMain.setBounds(50, 80, 60, 60);

                    //load dp photo
                BufferedImage img=null;
                try {
                    img=ImageIO.read(new File("btns/EmptyUser (2)_3.png"));
                }
                catch(Exception ex) {}

                    //Label DP
                lblDP.setBounds(getWidth()-210,5,24,24);

                Image simg=img.getScaledInstance(lblDP.getWidth(),lblDP.getHeight(),Image.SCALE_SMOOTH);

                    //display photo holder
                lblDP.setIcon(new ImageIcon(simg));
                lblDP.setBackground(Color.WHITE);
                lblDP.setOpaque(true);

                    //display photo main profile
                lblDPMain.setBounds(46,80,60,60);
                BufferedImage dpmain = null;
                    try {
                        dpmain=ImageIO.read(new File("btns/EmptyUser (2).png"));
                    }
                    catch(Exception ex) {}

                    Image dpm = dpmain.getScaledInstance(lblDPMain.getWidth(),lblDPMain.getHeight(),Image.SCALE_SMOOTH);
                        lblDPMain.setIcon(new ImageIcon(dpm));
                        lblDPMain.setBackground(Color.BLACK);
                        lblDPMain.setOpaque(true);

        //add profile details here.
        lblFullName.setBounds(113, 80, 250, 30);
        //lblFullName.setForeground(Color.BLACK);

        lblUserName.setBounds(113, 100, 250, 30);
        //lblUserName.setForeground(Color.BLACK);

        //add (inside of Panel Top Bar) - panel Top bar here.
        pnlTopbar.setOpaque(false);
        pnlTopbar.setBackground(Color.GRAY);
        pnlTopbar.setLayout(new FlowLayout());

        pnlTopbar.setLayout(null);
        pnlTopbar.add(lblAccountName);
        pnlTopbar.add(twitterHomeLogo);
        pnlTopbar.add(search);
        pnlTopbar.add(lblDP);
        pnlTopbar.add(btnLogout);

        //add Update status
        cn.add(inp);
        cn.add(tweet);
        cn.add(lst1_scroll);

        //add profile details here.
        cn.add(pnlTopbar);
        cn.add(lblDPMain);
        cn.add(lblFullName);
        cn.add(lblUserName);
        cn.add(Tweets);
        cn.add(Following);
        cn.add(Followers);
        cn.add(bg);

    }

    public void setProfileInfos2(String fn, String un) {
        lblFullName.setText(fn);
        lblUserName.setText("@" + un);
    }
}