/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpclient;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author Admin
 */

public class frmHienThi extends javax.swing.JInternalFrame {
    private Socket socket;
    private PrintWriter out=null;
    private Scanner in=null;
    private String username="";
    private String password="";
    private String path="";
    /**
     * Creates new form frmHienThi
     */
    public frmHienThi() {
        initComponents();
    }
    public frmHienThi(Socket s,String username,String password) {
        initComponents();
        this.socket=s;
        this.setTitle("chao "+username);
        this.username=username;
        this.password=password;
        loadlist();
    }

   /* frmHienThi(Socket s, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public void loadlist(){
        try {
            BufferedInputStream bi=new BufferedInputStream(socket.getInputStream());
            in=new Scanner(bi);
            DefaultListModel dm=new DefaultListModel();
            int n=in.nextInt();
            for(int i=0;i<=n;i++){
                String filename=in.nextLine();
                dm.addElement(filename);
            }
            this.lstuserfolder.setModel(dm);
            lstuserfolder.setSelectedIndex(0);
            this.validate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),"errol",JOptionPane.ERROR_MESSAGE);
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

        fcpath = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstclirntfolder = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstuserfolder = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("Currrent Folder at Client");

        jLabel2.setText("your account's Folder on server");

        jButton1.setText("Browser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstclirntfolder);

        jScrollPane2.setViewportView(lstuserfolder);

        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Dowload");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Thoat");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //this.fcpath.setVisible(true);
        fcpath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(this.fcpath.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            try{
                path=this.fcpath.getSelectedFile().getCanonicalPath();
                File dir=new File(path);
                File dsFile[]=dir.listFiles();
                if(dsFile==null){
                    JOptionPane.showMessageDialog(null, "sai");
                }else{
                    DefaultListModel dm=new DefaultListModel();
                    for(int i=0;i<dsFile.length;i++){
                        String filename=dsFile[i].getName();
                        dm.addElement(filename);
                    }
                    this.lstclirntfolder.setModel(dm);
                    lstclirntfolder.setSelectedIndex(0);
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String str = "upload@"+"select * from taikhoan where username='" +username+ "'@";
        String filename;
        
        if(!path.equals("")){
            try {
                filename = lstclirntfolder.getSelectedValue().toString();
                File f = new File(path+"\\"+filename);
                str=str+filename;
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(str+"@"+(int)f.length());
                
                byte[] mybytearray = new byte[(int) f.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
                bis.read(mybytearray, 0 , mybytearray.length);
                OutputStream os = socket.getOutputStream();
                os.write(mybytearray, 0 , mybytearray.length);
                os.flush();
                bis.close();
                loadlist();
                JOptionPane.showMessageDialog(null, "upload tệp tin lên thành công");
            } catch (Exception e) {
                try {
                    if(socket!=null)
                        socket.close();
                } catch (Exception ex) {
                    e.printStackTrace();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "upload tệp tin thất bại");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn file","Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String str="download@"+"select * from taikhoan where username='"+username+"'@";
        String filename;
        try{
                filename=lstuserfolder.getSelectedValue().toString();
                str=str+filename;
                out=new PrintWriter(socket.getOutputStream(),true);
                out.println(str);
                BufferedInputStream bi=new BufferedInputStream(socket.getInputStream());
                in=new Scanner(bi);
                int doDaiFile=in.nextInt();//lay do dai file
                if(path.equals("")){
                    this.fcpath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(this.fcpath.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                    path=this.fcpath.getSelectedFile().getCanonicalPath();
            }
                int bytesRead;
                int current=0;
                File f=new File(path+"\\"+filename);
                byte[] mybytearray = new byte[doDaiFile];
                InputStream is = socket.getInputStream();
                FileOutputStream fos = new FileOutputStream(f);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bytesRead = is.read(mybytearray,0,mybytearray.length);
                current = bytesRead;
                while(current!=doDaiFile){
                bytesRead = is.read(mybytearray, current, mybytearray.length-current);
                if(bytesRead>=0) current+=bytesRead;
}
                bos.write(mybytearray, 0, current);
                bos.flush();
                bos.close();
                loadlist();
                File dir=new File(path);
                File dsFile[]=dir.listFiles();
                DefaultListModel dm=new DefaultListModel();
                for(int i=0;i<dsFile.length;i++){
                    String name=dsFile[i].getName();
                        dm.addElement(name);
                }
                this.lstclirntfolder.setModel(dm);
                lstclirntfolder.setSelectedIndex(0);
                //this.validate();

                }catch(Exception e){
                try{if(socket!=null)socket.close();}catch(Exception ex){e.printStackTrace();}
                e.printStackTrace();}
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fcpath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstclirntfolder;
    private javax.swing.JList<String> lstuserfolder;
    // End of variables declaration//GEN-END:variables
}
