
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vasu
 */
public class singlePanelYoutube extends javax.swing.JPanel {

    /**
     * Creates new form singlePanelYoutube
     */
    int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    int w = Toolkit.getDefaultToolkit().getScreenSize().width;

    public singlePanelYoutube() {
        initComponents();
        this.setSize(w, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        thumbnailYoutube = new javax.swing.JLabel();
        titleYoutube = new javax.swing.JLabel();
        decriptionYoutube = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        add(thumbnailYoutube);
        thumbnailYoutube.setBounds(30, 30, 230, 140);

        titleYoutube.setBackground(new java.awt.Color(255, 255, 255));
        titleYoutube.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        titleYoutube.setForeground(new java.awt.Color(204, 51, 0));
        add(titleYoutube);
        titleYoutube.setBounds(360, 30, 290, 40);

        decriptionYoutube.setForeground(new java.awt.Color(0, 0, 102));
        add(decriptionYoutube);
        decriptionYoutube.setBounds(350, 100, 290, 80);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel decriptionYoutube;
    public javax.swing.JLabel thumbnailYoutube;
    public javax.swing.JLabel titleYoutube;
    // End of variables declaration//GEN-END:variables
}
