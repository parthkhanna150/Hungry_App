import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class splashScreen extends javax.swing.JFrame {

    public splashScreen() {
        
            initComponents();
//            BufferedImage orgimage = ImageIO.read(getClass().getResource("Splash.jpg"));
//            BufferedImage resizedImage = resize(orgimage,400,300);
//            jLabel1.setIcon(new ImageIcon(resizedImage));
            setSize(410,300);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
           
            jProgressBar1.setForeground(new java.awt.Color(51,153,0));
            new Thread(new progress()).start();

    }
    
    public class progress implements Runnable
    {

        @Override
        public void run() 
        {
            for (int i = 1; i <=100; i++) 
            {
                if(i<30)
                {
                    jLabel2.setText("Initializing..............");
                jProgressBar1.setValue(i);
                }
                else if(i<60)
                {
                    jLabel2.setText("Loading................");
                jProgressBar1.setValue(i);
                }
                else if(i<90)
                {
                    jLabel2.setText("Processing..............");
                jProgressBar1.setValue(i);
                }
                else
                {
                    jLabel2.setText("Launching..............");
                jProgressBar1.setValue(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(splashScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dispose();
            new mainFrame().setVisible(true);
        }
        
    }
   
    public static void main(String args[]) {
     
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jProgressBar1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(80, 240, 200, 20);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 220, 260, 10);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome foodies!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-30, 10, 270, 20);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Full Stack Recipe Software");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 70, 340, 70);

        bg.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        bg.setForeground(new java.awt.Color(204, 51, 0));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splash.jpg"))); // NOI18N
        bg.setText("Let's get Fat ;)");
        getContentPane().add(bg);
        bg.setBounds(0, 0, 410, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
