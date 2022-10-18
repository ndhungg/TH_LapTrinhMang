/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpClient;
import BT1.DBAccess;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchpath = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        txtdomain = new javax.swing.JTextField();
        btnup = new javax.swing.JButton();
        btndow = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btndn = new javax.swing.JButton();
        txtpass = new javax.swing.JTextField();
        btnb = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstclientpath = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstpath = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Domain");

        txtdomain.setBackground(new java.awt.Color(102, 255, 255));

        btnup.setBackground(new java.awt.Color(255, 255, 51));
        btnup.setText("Up");
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });

        btndow.setBackground(new java.awt.Color(255, 204, 102));
        btndow.setText("dowload");
        btndow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndowActionPerformed(evt);
            }
        });

        jLabel2.setText("user");

        jLabel3.setText("pass");

        txtUser.setBackground(new java.awt.Color(255, 51, 255));

        btndn.setBackground(new java.awt.Color(255, 204, 102));
        btndn.setText("Login");
        btndn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndnActionPerformed(evt);
            }
        });

        txtpass.setBackground(new java.awt.Color(51, 255, 51));

        btnb.setBackground(new java.awt.Color(255, 204, 204));
        btnb.setText("Browse");
        btnb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbActionPerformed(evt);
            }
        });

        jLabel4.setText("Client's Folder");

        jLabel5.setText("Server Folder");

        lstclientpath.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(lstclientpath);

        lstpath.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setViewportView(lstpath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdomain, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnup)
                                .addGap(41, 41, 41)
                                .addComponent(btndow)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btndn)
                                    .addComponent(btnb))
                                .addGap(22, 22, 22))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnup)
                    .addComponent(btndow))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Socket s;
public static final int PORT = 10000;
    private void btndnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndnActionPerformed
        // TODO add your handling code here:
        String domain=this.txtdomain.getText();
        try {
            InetAddress ia=InetAddress.getByName(domain);
            try {
                s=new Socket(ia,PORT);
                PrintWriter pw=new PrintWriter(s.getOutputStream());
                String user=this.txtUser.getText();
                String pass=this.txtpass.getText();
                DBAccess acc = new DBAccess();
                String cmd="DANGNHAP";
                pw.println(cmd);
                pw.println(user);
                pw.println(pass);
                System.out.println(cmd);
                System.out.println(user);
                System.out.println(pass);
               
                pw.flush();
                
                Scanner sc=new Scanner(s.getInputStream());
                
                int cmdR=sc.nextInt();
              //  System.out.println("alo");
                if(cmdR==1){
                    JOptionPane.showMessageDialog(this, "dang nhap thannh cong");
                    DefaultListModel dm=new DefaultListModel();
                    int n=sc.nextInt();
                    for(int i=0;i<n;i++){
                        dm.addElement(sc.nextLine());
                    }
                    this.lstpath.setModel(dm);
                }else
                    JOptionPane.showMessageDialog(this, "dang nhap khong thanh cong");
                    
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            } 
        } catch (UnknownHostException ex) {
             JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_btndnActionPerformed
String path;
    private void btnbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbActionPerformed
        // TODO add your handling code here:
       fchpath.setVisible(true);
       fchpath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
       if(fchpath.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
           try {
               
               path=fchpath.getSelectedFile().getCanonicalPath();
               File dir=new File(path);
               File dsFile[]=dir.listFiles();
               if(dsFile==null){
                   JOptionPane.showMessageDialog(null, "sai duong dan!");
               }else{
                   try {
                       DefaultListModel dm=new DefaultListModel();
                       for(int i=0;i<dsFile.length;i++){
                           String filename=dsFile[i].getName();
                           dm.addElement(filename);
                       }
                       this.lstclientpath.setModel(dm);
                   } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, e.toString());
                   }
               }
           } catch (Exception e) {
               
           }
    }//GEN-LAST:event_btnbActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        // TODO add your handling code here:
        String fileName=(String) this.lstclientpath.getSelectedValue();
        String cpath=path+"\\" + fileName;
        System.out.println(cpath);
        try {
            PrintWriter pw=new PrintWriter(s.getOutputStream());
            pw.println("UPLOAD");
            pw.flush();
            System.out.println("Da goi lenh upload len server");
            pw.println(fileName);
            pw.flush();
            System.out.println("Da goi ten tap tin len server");
            BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
            DataOutputStream dos=new DataOutputStream(bos);
            BufferedInputStream bis=new BufferedInputStream (new FileInputStream(cpath));
            byte buf[]=new byte[bis.available()];
            bos.write(bis.read(buf));
            System.out.println("da goi du lieu tap tin len server");
            bos.flush();
            Scanner sc=new Scanner(s.getInputStream());
            String cmd=sc.nextLine();
            System.out.println("da nhan dap tra tu server");  
            if(cmd.equals("DANHAN")){
                JOptionPane.showMessageDialog(null, "da gui tap tin thanh cong");
                
            }
            else
                JOptionPane.showMessageDialog(null, "that bai");
            this.upateFolderServer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnupActionPerformed
    private void capNhatClientFolder(String cpath){
        File dir=new File(path);
        File dsFile[]=dir.listFiles();
        if(dsFile==null)
        {
        JOptionPane.showMessageDialog(null, " Duong dan sai!");
        }else{
            try {
                DefaultListModel dm=new DefaultListModel();
                for(int i=0;i<dsFile.length;i++){
                String filename=dsFile[i].getName();
                dm.addElement(filename); }
                this.lstclientpath.setModel(dm);
                this.validate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
}
    private void btndowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndowActionPerformed
        // TODO add your handling code here:
        String fileName=(String) this.lstpath.getSelectedValue();
        System.out.println(fileName);
        try {
            PrintWriter pw=new PrintWriter(s.getOutputStream());
            pw.println("DOWNLOAD");
            pw.flush();
            System.out.println("Da goi lenh download len server");
            pw.println(fileName);
            pw.flush();

            System.out.println("Doi server goi noi dung tap tin ve");
            String cpath=path+"\\" + fileName;
            FileOutputStream fos;
            fos = new FileOutputStream(new File(cpath));
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
            byte buf[]=new byte[bis.available()];
            bos.write(bis.read(buf));
            bos.flush();
            bos.close();
            pw=new PrintWriter(s.getOutputStream());
            pw.println("DANHAN");
            pw.flush();

            this.capNhatClientFolder(cpath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btndowActionPerformed
public void upateFolderServer(){
    try {
        BufferedInputStream bi=new BufferedInputStream(s.getInputStream());
        Scanner sc=new Scanner(bi);
        DefaultListModel dm=new DefaultListModel();
        int n=sc.nextInt();
        System.out.println("Da nhan duoc so luong tap tin goi tu server");
        for(int i=0;i<n;i++)
        {
            String filename=sc.nextLine();
            dm.addElement(filename);
        }
        System.out.println("Da hien thi xong danh sach tap tin");
        this.lstpath.setModel(dm);
        this.validate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Lỗi", e.toString(),JOptionPane.ERROR_MESSAGE);
    }
}
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnb;
    private javax.swing.JButton btndn;
    private javax.swing.JButton btndow;
    private javax.swing.JButton btnup;
    private javax.swing.JFileChooser fchpath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstclientpath;
    private javax.swing.JList<String> lstpath;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtdomain;
    private javax.swing.JTextField txtpass;
    // End of variables declaration//GEN-END:variables
}