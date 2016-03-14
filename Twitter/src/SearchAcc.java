import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class SearchAcc extends JFrame implements ActionListener {

    JLabel searchBg;

    JLabel lblSearch = new JLabel("Search:");
    JTextField txtSearch = new JTextField();
    JButton btnSearch = new JButton("Search");

    DefaultListModel mdlAccountNames = new DefaultListModel();
    DefaultListModel mdlFileNames = new DefaultListModel();

    JList lstSearch = new JList(mdlAccountNames);
    JScrollPane slstSearch = new JScrollPane(lstSearch);


        //Constructor
    public SearchAcc(){
        setTitle("Search");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("btns/twitterIcon.png"));
        setIconImage(new ImageIcon("btns/twitterIcon.png").getImage());
        try {
            setIconImage(ImageIO.read(new FileInputStream("btns/twitterIcon.png")));
        }
        catch(Exception e) {}
        setup();
        searchAccounts();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

        //Setup function.
    void setup(){
        Container cn = getContentPane();
        searchBg=new JLabel(new ImageIcon("btns/SearchBg/searchBg.png"));
        searchBg.setLayout(new FlowLayout());

        //Position label "Search"
        lblSearch.setBounds(20, 10, 120, 25);

        //Position searchbox.
        txtSearch.setBounds(20, 35, 350, 25);

        //Position search results lisbox.
        slstSearch.setBounds(20, 70, 450, 250);

        lstSearch.setOpaque(false);
        lstSearch.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    String un="", pw="", name="", Bday="", Gen="", Loc="", Scho="";
                    try{
                        File dir = new File("Accounts");
                        for(File f : dir.listFiles()){


                            Scanner scn = new Scanner(new FileInputStream("Accounts/" +mdlFileNames.get(lstSearch.getSelectedIndex())));
                            un=scn.nextLine();
                            pw=scn.nextLine();

                            name=scn.nextLine();
                            Bday=scn.nextLine();
                            Loc=scn.nextLine();
                            Scho=scn.nextLine();
                        }
					} catch(Exception ex) {}
                    FriendsWall fw=new FriendsWall();
                    fw.AccountNamess=name;
                    fw.setTitle("Twitter - "+fw.AccountNamess);
                    fw.setFriendInfo(name,un,Bday,Loc,Scho);
                    dispose();
                }
            }
        });


        btnSearch.setBounds(380, 35, 90, 24);

        btnSearch.addActionListener(this);

        cn.add(lblSearch);
        cn.add(txtSearch);
        cn.add(slstSearch);
        cn.add(btnSearch);
        cn.add(searchBg);
    }

        //Action performed override.
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSearch){
            searchAccounts();

        }
    }

    void searchAccounts(){
        mdlAccountNames.clear();
        mdlFileNames.clear();
        try{
            File dir = new File("Accounts");

            for(File f : dir.listFiles()){

                String username="";
                String pw="";
                String accountname = "";

                    //Another try for reading the current text file.
                try{
                    Scanner scn = new Scanner(new FileInputStream("Accounts/" + f.getName()));
                    username=scn.nextLine();
                    pw=scn.nextLine();
                    accountname = scn.nextLine();
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "read error!");
                }

                if(txtSearch.getText().equals("")){
                    mdlAccountNames.addElement(accountname);
                    mdlFileNames.addElement(f.getName());
                    }
                else {
                    if(accountname.contains(txtSearch.getText())){
                        mdlAccountNames.addElement(accountname);
                        mdlFileNames.addElement(f.getName());
                    }
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error.");
        }
    }
}