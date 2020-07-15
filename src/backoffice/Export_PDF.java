/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backoffice;

import absensi.Form_absen_otomatis;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lib.Lib_login;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import penyimpanan.Karyawan;
import static penyimpanan.Karyawan.kry_map;
/**
 *
 * @author Atalanta
 */
public class Export_PDF extends javax.swing.JFrame {
    private static ArrayList<Object> ABSEN_DATA = new ArrayList();
    private DefaultTableModel tableModel;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
    /**
     * Creates new form Export_PDF
     */
    public Export_PDF() {
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") +"/src/img/LOGO-app.png");
//        Lib_login.is_login();
        initComponents();
        export.setEnabled(false);
        isi_tabel();
         
           
        
      
    }
    public void backup_data(){
         String outputFile = System.getProperty("user.dir") + "/csv/absensi.xls";
        String backupFile = System.getProperty("user.dir") + "/csv/absensi_full.xls";

        FileInputStream inputStream, bk_data;
        inputStream = null;
        bk_data = null;
        try {
            inputStream = new FileInputStream(outputFile);
            bk_data = new FileInputStream(backupFile);
        } catch (FileNotFoundException ex) {

            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        Workbook workbook = null;
        Workbook workbook_bk = null;
        try {
            workbook = new HSSFWorkbook(inputStream);
            workbook_bk = new HSSFWorkbook(bk_data);
        } catch (IOException ex) {

            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableModel = (DefaultTableModel) tb_absen.getModel();
        tableModel.setRowCount(0);
        Sheet sheet = workbook.getSheet("Absensi");
        Sheet sheet_bk = workbook_bk.getSheet("Absensi");

        if (sheet.getLastRowNum() > 0) {
            export.setEnabled(true);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                if (row != null) {
                    Row row_bk = sheet_bk.createRow(sheet_bk.getLastRowNum() + 1);
                    org.apache.poi.ss.usermodel.Cell cell = row_bk.createCell(0);
                    row_bk.createCell(0).setCellValue(String.valueOf(row.getCell(0)));
                    row_bk.createCell(1).setCellValue(String.valueOf(row.getCell(1)));
                    row_bk.createCell(2).setCellValue(String.valueOf(row.getCell(2)));
                    row_bk.createCell(3).setCellValue(String.valueOf(row.getCell(3)));

                    row_bk.createCell(4).setCellValue(String.valueOf(row.getCell(4)));
                    row_bk.createCell(5).setCellValue(String.valueOf(row.getCell(5)));
                    //
                }

            }

            // Create a FileOutputStream by passing the excel file name.
            FileOutputStream outputStream;
            outputStream = null;
            try {
                outputStream = new FileOutputStream(backupFile);

            } catch (FileNotFoundException ex) {

                Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // Write the FileOutputStream to workbook object.
                workbook_bk.write(outputStream);

                System.out.println("Backup Success");

            } catch (IOException ex) {

                Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                // Finally close the FileOutputStream.
                outputStream.close();
            } catch (IOException ex) {

                Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);

            }

        } else {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Tidak dapat Mengekspor, karena Data Absensi masih kosong", "Perhatian", JOptionPane.INFORMATION_MESSAGE);

        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void isi_tabel(){
       String outputFile = System.getProperty("user.dir") + "/csv/absensi.xls";
       
       FileInputStream inputStream;
       inputStream = null;
       try {
           inputStream = new FileInputStream(outputFile);
       } catch (FileNotFoundException ex) {

           Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
       }
       Workbook workbook = null;
       try {
           workbook = new HSSFWorkbook(inputStream);
       } catch (IOException ex) {
          
           Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
       }
         tableModel = (DefaultTableModel) tb_absen.getModel();
         tableModel.setRowCount(0);
       Sheet sheet = workbook.getSheet("Absensi");
        if (sheet.getLastRowNum() > 0) {
            export.setEnabled(true);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    tableModel.addRow(new Object[]{
                        row.getCell(0),
                        row.getCell(1),
                        row.getCell(2),
                        row.getCell(3),
                        row.getCell(4),
                        row.getCell(5),});
                }
             
              
           }
           
    } else{
            this.dispose();
            JOptionPane.showMessageDialog(null, "Tidak dapat Mengekspor, karena Data Absensi masih kosong", "Perhatian", JOptionPane.INFORMATION_MESSAGE);
          
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    private void clearExcel() throws IOException{
        String outputFile = System.getProperty("user.dir") + "/csv/absensi.xls";
        String  srcfile = System.getProperty("user.dir") + "/csv/bk/absensi.bk";
        FileInputStream inputStream;
        inputStream = null;
        try {
            inputStream = new FileInputStream(outputFile);
        } catch (FileNotFoundException ex) {

            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException ex) {

            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableModel = (DefaultTableModel) tb_absen.getModel();
        tableModel.setRowCount(0);
        Sheet crnt = workbook.getSheetAt(0);
        FileOutputStream output;
        File file = new File(outputFile); 
          
        if(file.delete()) 
        { 
            kry_map.clear();
            System.out.println("File deleted successfully");
            export.setEnabled(false);
            this.dispose();
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
        
    InputStream src = null;
    OutputStream dst = null;
    try {
        src = new FileInputStream(srcfile);
        dst = new FileOutputStream(outputFile);

        // the size of the buffer doesn't have to be exactly 1024 bytes, try playing around with this number and see what effect it will have on the performance
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = src.read(buffer)) > 0) {
            dst.write(buffer, 0, length);
        }
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        src.close();
        dst.close();
    }
//        try {
////            output = new FileOutputStream(outputFile);
////            workbook.write(output);
////            output.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
private void SavePDF() throws IOException{
    try {
            LocalDateTime now = LocalDateTime.now();
            String outputFile = System.getProperty("user.dir") + "/exported/"+dtf.format(now)+"_"+System.currentTimeMillis()+"_Absensi_karyawan.pdf";
            Document doc = new Document(); 
            PdfWriter.getInstance(doc, new FileOutputStream(outputFile));
            doc.open();
            Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
            Font footer = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.ITALIC);
           
                doc.add(new Paragraph("ABSENSI KARYAWAN",chapterFont));
                doc.add(new Paragraph("=============================="));
                doc.add(Chunk.NEWLINE);
            PdfPTable pdfTable = new PdfPTable(tb_absen.getColumnCount());
            //adding table headers
            for (int i = 0; i < tb_absen.getColumnCount(); i++) {
                pdfTable.addCell(tb_absen.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < tb_absen.getRowCount(); rows++) {
                for (int cols = 0; cols < tb_absen.getColumnCount(); cols++) {
                    pdfTable.addCell(tb_absen.getModel().getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.add(Chunk.NEWLINE);
            
             doc.add(new Paragraph("Export: "+dtf2.format(now),footer));
            
            JOptionPane.showMessageDialog(null, "Sukses Meng-export data\n Lokasi File: "+outputFile, "Perhatian", JOptionPane.INFORMATION_MESSAGE);
            backup_data();
            clearExcel();
//            doc.close();
            System.out.println("Exsport Sukses");
        } catch (DocumentException ex) {
            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_absen = new javax.swing.JTable();
        export = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export PDF");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REKAP DATA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 230, 50));

        tb_absen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "RFID", "Nama", "Masuk", "Terlambat", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_absen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 520, 220));

        export.setText("REKAP");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        getContentPane().add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 90, 30));

        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 90, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 310));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BG_CLOCK_blured.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 400));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transparent.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        int p = JOptionPane.showConfirmDialog(null,"Apakah anda ingin mengekspor data ini?","Konfirmasi" ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (p == JOptionPane.OK_OPTION) {        
            try {
            SavePDF();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan\n File absensi.bk tidak ditemukan ", "Perhatian", JOptionPane.INFORMATION_MESSAGE);
            
//            Logger.getLogger(Export_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_exportActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

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
            java.util.logging.Logger.getLogger(Export_PDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Export_PDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Export_PDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Export_PDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Export_PDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JLabel bg;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_absen;
    // End of variables declaration//GEN-END:variables
}
