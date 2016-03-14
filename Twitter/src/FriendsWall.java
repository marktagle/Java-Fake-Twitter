import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class FriendsWall extends JFrame {

        //Controls.
    String AccountNamess = "";

    JLabel bg;

    JButton search=new JButton("Search");

        //follows labels - Tweets label
    JLabel Tweets=new JLabel("0");
    JLabel following=new JLabel();
    JLabel Following=new JLabel("0");

    JLabel followers=new JLabel();
    JLabel Followers=new JLabel("0");

        //panel top bar
    JPanel pnlTopbar = new JPanel();

        //panel include Twitter Logo, Account name, DP
    Icon home=new ImageIcon("btns/homeBtn.png");
    JLabel twitterHomeLogo=new JLabel(home);
    Icon homePrssd=new ImageIcon("btns/homePress.png");


    JLabel lblAccountName = new JLabel("<HTML><FONT COLOR=WHITE>YOUR NAME</FONT></HTML>", SwingConstants.RIGHT);

    JLabel lblDP = new JLabel(new ImageIcon("btns/EmptyUser (2)_3.png"));
    JLabel lblDPMain = new JLabel(new ImageIcon("btns/EmptyUser (2).png"));
    JLabel lblHeaderPhoto = new JLabel(new ImageIcon("btns/SearchBg/searchBg.png"));

        //Followers
    ImageIcon follow=new ImageIcon("btns/Follow.png");
    ImageIcon followEntered=new ImageIcon("btns/FollowPress.png");
    ImageIcon unfollow=new ImageIcon("btns/Unfollow.png");
    //JButton unfollows=new JButton(unfollow);
    JLabel fllwrs=new JLabel(follow);


        //Update Status
    JTextField inp = new JTextField("What's happening?");

    Icon twts = new ImageIcon("btns/tweetBtn.png");
    JButton tweet = new JButton(twts);
    Icon twtsprsd=new ImageIcon("btns/tweetBtnPressed.png");

    JList lst1 = new JList();

    DefaultListModel<String> mdl = new DefaultListModel<String>();
    JScrollPane lst1_scroll = new JScrollPane(lst1);


        //Profile details
    JLabel lblFullName = new JLabel("Full name");
    JLabel lblUserName = new JLabel("");
    JLabel lblBday = new JLabel();
    JLabel lblLoc = new JLabel();
    JLabel lblSchool=new JLabel();

    ImageIcon imgs = new ImageIcon("btns/logout.png");
    JButton btnLogout = new JButton(imgs);
    Icon sgmi=new ImageIcon("btns/logoutPressed.png");

    FriendsWall() {
        setSize(800, 650);
        setTitle("Twitter - ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
        setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
        try {
            setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
        }
        catch(Exception e) {}
        ImageIcon bgImage = new ImageIcon("btns/topBar.png");
        pnlTopbar.add(new JLabel(bgImage));
        add(pnlTopbar);
        init();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void AccountNamess(String anames) {
        lblAccountName.setText(anames);
    }

    void init() {
        Container cn = getContentPane();
        bg = new JLabel(new ImageIcon("btns/topBar.png"));
        bg.setLayout(new FlowLayout());
        cn.setBackground(Color.BLACK);

        //Search Button - Top bar
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
        Tweets.setBounds(280,225,50,20);
        following.setBounds(323,210,50,20);
        /*following.setCursor(new Cursor(Cursor.HAND_CURSOR));
        following.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Following();
            }
        });
        */
        Following.setBounds(345,225,50,20);

        followers.setBounds(396,210,56,20);
        /*
        followers.setCursor(new Cursor(Cursor.HAND_CURSOR));
        followers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Followers();
            }
        });
        */
        Followers.setBounds(418,225,50,20);


        //Update Status
        /*lst1.setModel(mdl);
        lst1.setOpaque(false);

        lst1_scroll.setBounds(300, 150, 330, 200);


        inp.setBounds(310, 110, 220, 28);

        tweet.setBounds(560,110,70,25);

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
        */

        //set bounds top bar panel
        pnlTopbar.setBounds(0, 0, getWidth() + 60, 45);


        //lblDPMain
        lblDPMain.setBounds(80,170,128,128);
        BufferedImage MainDP = null;
        try {
            MainDP=ImageIO.read(new File("btns/EmptyUser (2).png"));
        }
        catch(Exception ex) {}
        Image dpmain = MainDP.getScaledInstance(lblDPMain.getWidth(),lblDPMain.getHeight(),Image.SCALE_SMOOTH);
        lblDPMain.setIcon(new ImageIcon(dpmain));
        lblDPMain.setBackground(Color.BLACK);
        lblDPMain.setOpaque(true);


        //HeaderPhoto
        lblHeaderPhoto.setBounds(0,38,795,170);
        BufferedImage header = null;
        try {
            header=ImageIO.read(new File("btns/SearchBg/searchBg.png"));
        }
        catch(Exception ex) {}
        Image coverphoto = header.getScaledInstance(lblHeaderPhoto.getWidth(),lblHeaderPhoto.getHeight(),Image.SCALE_SMOOTH);
        lblHeaderPhoto.setIcon(new ImageIcon(coverphoto));
        lblHeaderPhoto.setBackground(Color.BLACK);
        lblHeaderPhoto.setOpaque(true);

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

        twitterHomeLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Wall wll=new Wall();
                wll.setVisible(true);
                dispose();
            }
        });


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
        //lblDPMain.setBounds(80,170,128,128);

        fllwrs.setBounds(620,210,70,28);
        fllwrs.setForeground(Color.BLACK);

        fllwrs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fllwrs.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == fllwrs) {
                    fllwrs.setIcon(unfollow);
                    //add(lblFullName);
                    //add(lblUserName);
                    //add(lblBday);
                    //add(lblLoc);
                    //add(lblSchool);

                    if (e.getClickCount() == 2) {
                        fllwrs.setIcon(follow);

                        //remove(lblFullName);
                        //remove(lblUserName);
                        //remove(lblBday);
                        //remove(lblLoc);
                        //remove(lblSchool);

                    }
                }
            }
        });


        fllwrs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fllwrs.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                //fllwrs.setIcon(followEntered);
            }
        });

        fllwrs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fllwrs.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                //fllwrs.setIcon(follow);
            }
        });

        fllwrs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fllwrs.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //fllwrs.setIcon(followEntered);
            }
        });

        fllwrs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fllwrs.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                //fllwrs.setIcon(follow);
            }
        });


        //load dp photo
                /*BufferedImage img=null;
                try {
                    img=ImageIO.read(new File("icon.jpg"));
                }
                catch(Exception ex) {} */

        //Label DP
                /*lblDP.setBounds(getWidth()-210,5,24,24);

                Image simg=img.getScaledInstance(lblDP.getWidth(),lblDP.getHeight(),Image.SCALE_SMOOTH);

                    //display photo holder
                lblDP.setIcon(new ImageIcon(simg));
                lblDP.setBackground(Color.WHITE);
                lblDP.setOpaque(true); */

        //display photo main profile
                /*lblDPMain.setBounds(50,100,128,128);
                BufferedImage dpmain = null;
                    try {
                        dpmain=ImageIO.read(new File("icon.jpg"));
                    }
                    catch(Exception ex) {}

                    Image dpm = dpmain.getScaledInstance(lblDPMain.getWidth(),lblDPMain.getHeight(),Image.SCALE_SMOOTH);
                        lblDPMain.setIcon(new ImageIcon(dpm));
                        lblDPMain.setBackground(Color.BLACK);
                        lblDPMain.setOpaque(true); */

        //add profile details here.
        lblFullName.setBounds(80,310,250,30);
        //lblFullName.setForeground(Color.BLACK);

        lblUserName.setBounds(80,330,250,30);
        //lblUserName.setForeground(Color.BLACK);
        lblBday.setBounds(98,362,250,30);

        lblLoc.setBounds(98,384,250,30);

        lblSchool.setBounds(98,404,250,30);

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

        //Following/Followers/Tweets
        cn.add(following);
        cn.add(Following);

        cn.add(followers);
        cn.add(Followers);
        cn.add(Tweets);

        //add profile details here.
        cn.add(pnlTopbar);
        cn.add(lblDPMain);
        cn.add(lblHeaderPhoto);
        cn.add(lblFullName);
        cn.add(lblUserName);
        cn.add(lblBday);
        cn.add(lblLoc);
        cn.add(lblSchool);

        cn.add(fllwrs);
        cn.add(bg);

    }
    public void setFriendInfo(String fn, String un, String bday, String loc, String sch) {
        lblFullName.setText("" + fn);
        lblUserName.setText("@" + un);
        lblBday.setText(bday);
        lblLoc.setText(loc);
        lblSchool.setText("School at "+sch);
    }
}