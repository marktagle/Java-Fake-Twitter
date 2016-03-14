import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Profile extends JFrame {
            //Controls.
        String AccountName="";

        JLabel bg;

            //panel top bar
        JPanel pnlTopbar=new JPanel();

            //Search Box
        JButton search=new JButton("Search");

            //Top bar panel include Twitter Logo, Account name, DP
        Icon home=new ImageIcon("btns/homeBtn.png");
        JLabel twitterHomeLogo=new JLabel(home);
        Icon homePrssd=new ImageIcon("btns/homePress.png");

        JLabel lblAccountName=new JLabel("<HTML><FONT COLOR=WHITE>YOUR NAME</FONT></HTML>",SwingConstants.RIGHT);


            //Count tweets
            int count=0;
        JLabel countsTweets=new JLabel();


            //Following/Followers label
        JLabel following=new JLabel();
        JLabel Following=new JLabel("0");

        JLabel followers=new JLabel();
        JLabel Followers=new JLabel("0");


            //DP on Top bar
        JLabel lblDP=new JLabel(new ImageIcon("btns/EmptyUser (2)_3.png"));

            //Update Status
        JTextField inp=new JTextField("What's happening?");

        Icon twts=new ImageIcon("btns/tweetBtn.png");
        JButton tweet=new JButton(twts);
        Icon twtsprsd=new ImageIcon("btns/tweetBtnPressed.png");

            JList lst1=new JList();
            DefaultListModel<String> mdl=new DefaultListModel<String>();
            JScrollPane lst1_scroll=new JScrollPane(lst1);

            //Edit Profile
        ImageIcon editProf=new ImageIcon("btns/Editprofile.png");
        ImageIcon edirProffPress=new ImageIcon("btns/EditprofilePress.png");
        JButton lblEditProf=new JButton(editProf);

            //Save changes edit profile
        ImageIcon saveChange=new ImageIcon("btns/Savechanges.png");
        ImageIcon saveChangePress=new ImageIcon("btns/SavechangesPress.png");
        JButton saveChanges=new JButton(saveChange);

            //Cancel edit profile
        ImageIcon canc=new ImageIcon("btns/cancel.png");
        ImageIcon cancpress=new ImageIcon("btns/cancelPress.png");
        JButton cancel=new JButton(canc);

            //Cover photos
        JLabel coverPhoto=new JLabel(new ImageIcon("btns/SearchBg/searchBg.png"));
        ImageIcon editCoverPhoto=new ImageIcon("btns/ChangeHeader,DP/changeHeader.png");
        JButton changeCoverPhoto=new JButton(editCoverPhoto);

            //DPMAIN/UPDATE ICON
        JLabel lblDPMain=new JLabel(new ImageIcon("btns/EmptyUser (2).png"));

        ImageIcon editDP=new ImageIcon("btns/ChangeHeader,DP/changeIcon.png");
        ImageIcon editdp=new ImageIcon("btns/ChangeHeader,DP/changeIcon_2.png");

        JButton changeDP=new JButton(editDP);

            //Profile details
        JLabel lblFullName=new JLabel("Full name");
        JLabel lblUserName=new JLabel("");
        JLabel lblLocation=new JLabel();
        JLabel lblBirthday=new JLabel();
        JLabel lblSchool=new JLabel("School at ");

            //Logout Button
        ImageIcon imgs=new ImageIcon("btns/logout.png");
        JButton btnLogout=new JButton(imgs);
        Icon sgmi=new ImageIcon("btns/logoutPressed.png");

        //String SaveUn;

        Profile() {
            setSize(800, 650);
            setTitle("Twitter Profile - ");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
            setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
            try {
                setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
            }
            catch(Exception e) {}
            ImageIcon bgImage=new ImageIcon("btns/TwttrPanel.png");
            pnlTopbar.add(new JLabel(bgImage));
            add(pnlTopbar);

            //this.SaveUn=SaveUn;
            init();
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
            }

    public void AccountName(String aname) {
            lblAccountName.setText(aname);
                }

            //PROFILE
        void init() {
            Container cn=getContentPane();
            bg=new JLabel(new ImageIcon("btns/topBar.png"));
            bg.setLayout(new FlowLayout());
            cn.setBackground(Color.BLACK);

            countsTweets.setText(String.valueOf(count));
            countsTweets.setBounds(280,225,50,20);

            following.setBounds(323,210,50,20);
            following.setCursor(new Cursor(Cursor.HAND_CURSOR));
            following.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new Following();
                }
            });

            Following.setBounds(345,225,50,20);

            followers.setBounds(396,210,56,20);
            followers.setCursor(new Cursor(Cursor.HAND_CURSOR));
            followers.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new Followers();
                }
            });

            Followers.setBounds(418,225,50,20);

                //Search JTextField - Top bar
            search.setBounds(115,8,100,24);
            //search.setBorderPainted(false);
            //search.setContentAreaFilled(false);
            search.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //dispose();
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

                //Update Status
            lst1.setModel(mdl);

            lst1.setOpaque(false);

            lst1_scroll.setBounds(380,290,360,200);

            inp.setBounds(380,260,240,28);

            tweet.setBounds(630,260,90,25);
            tweet.setCursor(new Cursor(Cursor.HAND_CURSOR));
            tweet.setBorderPainted(false);
            tweet.setContentAreaFilled(false);
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
                    String input=inp.getText();
                    mdl.addElement(input);

                    try {
                        BufferedWriter tw=new BufferedWriter(new FileWriter("tweets/tweet.txt",true));

                    if(inp.equals("What's happening?"))
                        inp.setText("");
                    else
                        inp.setText("What's happening?");

                            //Input write on textfile
                        tw.write(input);
                        tw.newLine();
                        tw.flush();
                        tw.close();
                    }

                    catch (Exception ex) {}

                }
            });

                //Open textfile and display in JList
            try {
                File archieve=new File("tweets/tweet.txt");
                FileReader fr=new FileReader(archieve);
                BufferedReader br=new BufferedReader(fr);

                String inps=inp.getText();
                while((inps=br.readLine())!=null)
                    mdl.addElement(inps);
            }
            catch(Exception ex) {}

                //JtextField mouse adapter for clear "what's happening?"
            inp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //inp.setText("What's happening?");
                }
            });
            inp.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e){
                    //inp.setText("What's happening?");
                }
            });
            inp.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    inp.setText("");
                }
            });
            inp.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e){
                    //inp.setText("What's happening?");
                }
            });

                //set bounds top bar panel
            pnlTopbar.setBounds(0,0,getWidth()+60,45);

                //Edit HeaderPhoto
            lblEditProf.setBounds(640,213,80,28);
            lblEditProf.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblEditProf.setBorderPainted(false);
            lblEditProf.setContentAreaFilled(false);

            lblEditProf.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                        //Edit Profile
                    lblEditProf.setIcon(edirProffPress);

                        //Cover Photo
                    coverPhoto.setIcon(editCoverPhoto);
                        //DP MAIN/DP TOP BAR
                    lblDPMain.setIcon(editDP);
                    lblDP.setIcon(editdp);

                        //Save Changes
                    saveChanges.setBounds(640,213,90,28);
                    saveChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    saveChanges.setBorderPainted(false);
                    saveChanges.setContentAreaFilled(false);

                    saveChanges.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveChanges.setIcon(saveChangePress);

                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            saveChanges.setIcon(saveChangePress);
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            saveChanges.setIcon(saveChange);
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            saveChanges.setIcon(saveChangePress);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            saveChanges.setIcon(saveChange);
                        }
                    });

                        //Cancel
                    cancel.setBounds(560,213,80,28);
                    cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    cancel.setBorderPainted(false);
                    cancel.setContentAreaFilled(false);

                    cancel.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            cancel.setIcon(cancpress);
                            new Profile();
                            dispose();
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            cancel.setIcon(cancpress);
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            cancel.setIcon(canc);
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            cancel.setIcon(cancpress);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            cancel.setIcon(canc);
                        }
                    });

                        //Change DP
                    changeDP.setBounds(50,170,128,128);
                    lblDPMain.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    changeDP.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            JFileChooser fcs=new JFileChooser();

                            fcs.setCurrentDirectory(new File(System.getProperty("user.home")));
                            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                            fcs.addChoosableFileFilter(filter);

                            int result=fcs.showOpenDialog(null);
                            if(result==JFileChooser.APPROVE_OPTION){
                                File file=fcs.getSelectedFile();

                                BufferedImage img=null;
                                BufferedImage dpmain=null;
                                try {
                                    img=ImageIO.read(file);
                                    dpmain=ImageIO.read(file);
                                }
                                catch(Exception ex) {}

                                try {
                                        //Label DP
                                    lblDP.setBounds(getWidth()-210,5,24,24);

                                        //Label DPMain
                                    lblDPMain.setBounds(50,170,128,128);

                                        //read from JFileChooser
                                    lblDP.setIcon(new ImageIcon(ImageIO.read(file)));
                                    lblDPMain.setIcon(new ImageIcon(ImageIO.read(file)));

                                        //Image Get Fit
                                    Image simg=img.getScaledInstance(lblDP.getWidth(),lblDP.getHeight(),Image.SCALE_SMOOTH);
                                    Image dpm = dpmain.getScaledInstance(lblDPMain.getWidth(),lblDPMain.getHeight(),Image.SCALE_SMOOTH);

                                        //display photo holder
                                    lblDP.setIcon(new ImageIcon(simg));
                                    lblDP.setBackground(Color.BLACK);
                                    lblDP.setOpaque(true);

                                        //DP Main holder
                                    lblDPMain.setIcon(new ImageIcon(dpm));
                                    lblDPMain.setBackground(Color.BLACK);
                                    lblDPMain.setOpaque(false);

                                }
                                catch(IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });

                        //Change Header
                    changeCoverPhoto.setBounds(0,38,795,170);
                    coverPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    changeCoverPhoto.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            JFileChooser fc=new JFileChooser();

                            fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                            fc.addChoosableFileFilter(filter);

                            int result=fc.showOpenDialog(null);
                            if(result==JFileChooser.APPROVE_OPTION) {
                                File file = fc.getSelectedFile();

                                BufferedImage img=null;
                                try {
                                    img= ImageIO.read(file);
                                }

                                catch(Exception ex) {}

                                try {
                                    //Label DP
                                    coverPhoto.setBounds(0,38,795,170);

                                    //read from JFileChooser
                                    coverPhoto.setIcon(new ImageIcon(ImageIO.read(file)));

                                    Image simg = img.getScaledInstance(coverPhoto.getWidth(), coverPhoto.getHeight(), Image.SCALE_SMOOTH);

                                    //display photo holder
                                    coverPhoto.setIcon(new ImageIcon(simg));
                                    coverPhoto.setBackground(Color.GRAY);
                                    coverPhoto.setOpaque(true);
                                }
                                catch(Exception ex) {}
                            }
                        }
                    });
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    lblEditProf.setIcon(edirProffPress);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    lblEditProf.setIcon(editProf);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    lblEditProf.setIcon(edirProffPress);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    lblEditProf.setIcon(editProf);
                }
            });

                //HeaderPhoto
            coverPhoto.setBounds(0,38,795,170);
                BufferedImage header = null;
                try {
                    header=ImageIO.read(new File("btns/SearchBg/searchBg.png"));
                }
                catch(Exception ex) {}
            Image coverphoto = header.getScaledInstance(coverPhoto.getWidth(),coverPhoto.getHeight(),Image.SCALE_SMOOTH);
            coverPhoto.setIcon(new ImageIcon(coverphoto));
            coverPhoto.setBackground(Color.BLACK);
            coverPhoto.setOpaque(true);

                //label logo

            twitterHomeLogo.setBounds(40,9,56,28);
            twitterHomeLogo.setForeground(Color.BLACK);
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



            String uname="", c_pw="", accnt_name="", un="";
            twitterHomeLogo.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e) {
                   Wall nw=new Wall();
                   nw.setTitle("Twitter Home - "+accnt_name);
                   nw.AccountNames=accnt_name;
                   nw.setProfileInfos2(accnt_name, un);
                   nw.setVisible(true);
                   dispose();
               }
            });

                //Account name label
            lblAccountName.setBounds(getWidth()-370,5,150,25);
            lblAccountName.setForeground(Color.BLACK);

                //logout--button Logout setBounds
            btnLogout.setBounds(getWidth()- 170, 5, 153,25);
            btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnLogout.setBorderPainted(false);
            btnLogout.setContentAreaFilled(false);
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
            lblDP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblDP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new Profile();
                    dispose();
                }
            });
            lblDP.setBounds(getWidth()-210,5,24,24);
            lblDPMain.setBounds(50,170,128,128);

                    /*public ImageIcon ResizeImage(String ImagePath) {
                        ImageIcon MyImage = new ImageIcon(ImagePath);
                        Image img = MyImage.getImage();
                        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon image = new ImageIcon(newImg);
                        return image;
                    } */

                            //add profile details here.
                        lblFullName.setBounds(80,310,250,30);

                        lblUserName.setBounds(80,330,250,30);

                        lblBirthday.setBounds(98,362,150,30);

                        lblLocation.setBounds(98,384,150,30);

                        lblSchool.setBounds(80,408,250,30);

                    //add (inside of Panel Top Bar) - panel Top bar here.
                pnlTopbar.setOpaque(false);
                pnlTopbar.setBackground(Color.GRAY);
                pnlTopbar.setLayout(new FlowLayout());

                pnlTopbar.setLayout(null);
                pnlTopbar.add(search);
                pnlTopbar.add(lblAccountName);
                pnlTopbar.add(twitterHomeLogo);
                pnlTopbar.add(lblDP);
                pnlTopbar.add(btnLogout);

                    //add Update status
                cn.add(inp);
                cn.add(tweet);
                cn.add(lst1_scroll);

                    //Count Tweets
                cn.add(countsTweets);

                    //Following/Followers
                cn.add(following);
                cn.add(Following);

                cn.add(followers);
                cn.add(Followers);

                    //add Edit Profiles
                cn.add(saveChanges);
                cn.add(cancel);
                cn.add(lblEditProf);

                cn.add(lblDPMain);
                cn.add(changeDP);

                cn.add(coverPhoto);
                cn.add(changeCoverPhoto);

                    //add profile details here.
                cn.add(pnlTopbar);

                cn.add(lblFullName);
                cn.add(lblUserName);
                cn.add(lblBirthday);
                cn.add(lblLocation);
                cn.add(lblSchool);

                cn.add(bg);
            }

            public void setProfileInfos(String fn, String un, String bd, String lc, String sch) {
                lblFullName.setText(""+fn);
                lblUserName.setText("@"+un);
                lblLocation.setText(lc);
                lblBirthday.setText(bd);
                lblSchool.setText("School at "+sch);
            }

        }
