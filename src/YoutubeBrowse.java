
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class YoutubeBrowse extends javax.swing.JFrame {

    String title;
    String r_id;
    String video_id;
    String video_url = "";
    int v_index;
    ArrayList<quality> al = new ArrayList<>();

    /**
     * Creates new form YoutubeBrowse
     */
    int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    int w = Toolkit.getDefaultToolkit().getScreenSize().width;

    public YoutubeBrowse(String title, String r_id, String video_id) {
        initComponents();
        this.setSize(w, h);
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browserView.setBounds(0, 100, w, h - 400);
        this.r_id = r_id;
        this.video_id = video_id;
        this.title = title;
        titleBrowse.setText(this.title);
        qualities.setSize(w, 20);
        getContentPane().setBackground(java.awt.Color.PINK);
        this.add(browserView, BorderLayout.CENTER);
        
        fetch_urls job = new fetch_urls();
        Thread t = new Thread(job);
        t.start();

        setVisible(true);
        browser.loadURL("https://www.youtube.com/embed/" + video_id);

    }

    class fetch_urls implements Runnable {

        @Override
        public void run() {

            try {
                URL url = new URL("https://www.youtube.com/watch?v=" + video_id + "");
                URLConnection spoof = url.openConnection();

                spoof.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
                BufferedReader br = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
                String strLine = "";
                String gets = "";

                while ((strLine = br.readLine()) != null) {

                    if (strLine.contains("<script>var ytplayer")) {
                        if (gets.contains("</script>")) {
                            break;
                        }
                        gets = gets + strLine;
                    }
                }

//                System.out.println(gets);
                int index = 0;
                gets = gets.substring(gets.indexOf("url=") + 4);

                String[] word
                        = {
                            "%2F", "%3A", "%3F", "%3D", "%26", "%252"
                        };
                String[] word1
                        = {
                            "/", ":", "?", "=", "&", "%2"
                        };

                for (int i = 0; i < word.length; i++) {
                    gets = gets.replaceAll(word[i], word1[i]);
                }
//                System.out.println(gets);

                while (true) {

                    if (gets.indexOf("url=") == -1) {
                        break;
                    }
                    index = gets.indexOf("url=");
                    String gets1 = gets.substring(0, index);
                    System.out.println(gets1);
                    System.out.println("===============================");
                    String q[]
                            = {
                                "hd", "medium", "small"
                            };

                    if (gets1.contains("signature") && gets1.contains("quality=")) {
//                        System.out.println(gets1);
                        String type = gets1.substring(gets1.indexOf("type=video/") + 11, gets1.indexOf("%", gets1.indexOf("type=video/")));

                        String type1 = gets1.substring(gets1.indexOf("quality=") + 8, gets1.length());

                        gets1 = gets1.substring(0, gets1.indexOf("\\u0026"));
                        for (int i = 0; i < q.length; i++) {

                            if (type1.contains(q[i])) {
                                type1 = q[i];
                                break;
                            }

                        }
                        al.add(new quality(type + " " + type1, gets1));

//                        System.out.println(type+" "+type1+" ===========================");
                    }
                    gets = gets.substring(index + 4);

                }

                Checkbox cb[] = new Checkbox[al.size()];
                CheckboxGroup cbg = new CheckboxGroup();
                int x = 20;
                for (int i = 0; i < al.size(); i++) {
                    final int j = i;

                    System.out.println(al.get(i).type);
                    cb[i] = new Checkbox(al.get(i).type, false, cbg);
                    cb[i].setBounds(x, 10, 100, 30);
                    qualities.add(cb[i]);
                    qualities.repaint();

                    cb[i].addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            v_index = j;
                        }
                    });

                    x += 100;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBrowse = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        qualities = new javax.swing.JPanel();
        download = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        titleBrowse.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        titleBrowse.setForeground(new java.awt.Color(204, 51, 0));
        titleBrowse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(titleBrowse);
        titleBrowse.setBounds(50, 30, 700, 40);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 0));
        jLabel1.setText("Select your video quality:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 460, 770, 30);

        qualities.setBackground(new java.awt.Color(255, 255, 255));
        qualities.setLayout(null);
        jScrollPane2.setViewportView(qualities);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 510, 1350, 40);

        download.setText("Download");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });
        getContentPane().add(download);
        download.setBounds(0, 580, 180, 40);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(250, 590, 350, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        // TODO add your handling code here:
        download1 ob = new download1();
        Thread t = new Thread(ob);
        t.start();

    }//GEN-LAST:event_downloadActionPerformed

    class quality {

        String type;
        String URL;

        public quality(String type, String URL) {
            this.type = type;
            this.URL = URL;
        }

    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        System.out.println(bi);
        return bi;
    }

    class download1 implements Runnable {

        @Override
        public void run() {
            String name = JOptionPane.showInputDialog("");
            String video_url = al.get(v_index).URL;
            try {

                URL vid = new URL(video_url);
                URLConnection conn = vid.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
                InputStream is = conn.getInputStream();
                long total = conn.getContentLength();
                FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + name);
                byte b[] = new byte[10000];
                int count = 0;
                while (true) {
                    int r = is.read(b, 0, 10000);

                    System.out.println("  in downloading " + r);
                    if (r == -1) {
                        break;
                    }
                    count = count + r;
                    int percent = (int) (count * 100 / total);
                    progressBar.setValue(percent);
                    progressBar.setString("" + percent);
                    fos.write(b, 0, r);
                }
                progressBar.setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "Video Downloaded successfully");
                fos.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "This video cannot be downloaded");
                e.printStackTrace();
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel qualities;
    private javax.swing.JLabel titleBrowse;
    // End of variables declaration//GEN-END:variables
}
