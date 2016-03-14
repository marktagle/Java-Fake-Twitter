import javax.swing.*;

    class Program {
        public static void main(String []args) {

            try {
        for(UIManager.LookAndFeelInfo inf : UIManager.getInstalledLookAndFeels()) {
            //System.out.println(inf.getName());
            if(inf.getName().equals("Nimbus")) {
                UIManager.setLookAndFeel(inf.getClassName());
            }
        }
    } catch(Exception xe) {}

            new login();
            //new Profile();
            //new Wall();
            //new FriendsWall();
        }
    }
