/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backoffice;
import absensi.Form_absen_otomatis;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lib.*;
/**
 *
 * @author Atalanta
 */
public class Form_dashboard_admin extends javax.swing.JFrame {

    /**
     * Creates new form Form_dashboard_admin
     */
    public Form_dashboard_admin() {
        Lib_login.is_login();
        initComponents();
        
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        absen_manual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pdf_export.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_username.setText("Hi, "+Lib_login.session_username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bg_trans2 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        absen_manual = new javax.swing.JLabel();
        pdf_export = new javax.swing.JLabel();
        bg_trans3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrator");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrator Dashboard");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 530, 50));

        bg_trans2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
        bg_trans2.setText("bgtrans");
        getContentPane().add(bg_trans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 550, 50));

        lbl_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Admin");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/exit.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 100, 100));

        absen_manual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/absen_manual.png"))); // NOI18N
        absen_manual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                absen_manualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                absen_manualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                absen_manualMouseExited(evt);
            }
        });
        getContentPane().add(absen_manual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 100, 100));

        pdf_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/pdf.png"))); // NOI18N
        pdf_export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdf_exportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdf_exportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdf_exportMouseExited(evt);
            }
        });
        getContentPane().add(pdf_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 100, 100));

        bg_trans3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
        bg_trans3.setText("bgtrans");
        getContentPane().add(bg_trans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 250));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BG_CLOCK_blured.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void absen_manualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absen_manualMouseEntered
         String imageName = System.getProperty("user.dir") +"/src/img/icon/absen_manual_hovered.png";
 
        try {
            absen_manual.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
        } catch (IOException ex) {
            Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_absen_manualMouseEntered

    private void pdf_exportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdf_exportMouseEntered
         String imageName = System.getProperty("user.dir") +"/src/img/icon/pdf_hover.png";
       try {
           pdf_export.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
       } catch (IOException ex) {
          Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_pdf_exportMouseEntered

    private void pdf_exportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdf_exportMouseExited
         String imageName = System.getProperty("user.dir") +"/src/img/icon/pdf.png";
       try {
           pdf_export.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
       } catch (IOException ex) {
          Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_pdf_exportMouseExited

    private void absen_manualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absen_manualMouseExited
        String imageName = System.getProperty("user.dir") +"/src/img/icon/absen_manual.png";
       try {
           absen_manual.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
       } catch (IOException ex) {
         Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_absen_manualMouseExited

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        String imageName = System.getProperty("user.dir") +"/src/img/icon/exit.png";
        try {
            exit.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
        } catch (IOException ex) {
            Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exitMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        String imageName = System.getProperty("user.dir") +"/src/img/icon/exit_hover.png";
        try {
            exit.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );
        } catch (IOException ex) {
            Logger.getLogger(Form_dashboard_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
         int p = JOptionPane.showConfirmDialog(null,"Apakah anda ingin Logout?","Konfirmasi" ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

        if (p == JOptionPane.OK_OPTION) {
            
            Lib_login.session_username="";
            this.dispose();
        }
    }//GEN-LAST:event_exitMouseClicked

    private void absen_manualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absen_manualMouseClicked
        Form_admin_input_manual frm = new Form_admin_input_manual();
        frm.setVisible(true);
    }//GEN-LAST:event_absen_manualMouseClicked

    private void pdf_exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdf_exportMouseClicked
        Export_PDF frm = new Export_PDF();
        frm.setVisible(true);
    }//GEN-LAST:event_pdf_exportMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Form_dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_dashboard_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel absen_manual;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg_trans2;
    private javax.swing.JLabel bg_trans3;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel pdf_export;
    // End of variables declaration//GEN-END:variables
}