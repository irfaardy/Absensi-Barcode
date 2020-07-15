/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backoffice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.SWT;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.Lib_login;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Atalanta
 */
public class Chart extends javax.swing.JFrame {

    int timeRun = 0;
    ChartPanel chartObj;

    /**
     * Creates new form Chart
     */
    public Chart(String cbo) {
//        Lib_login.is_login();
        initComponents();
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "/src/img/LOGO-app.png");
        this.setIconImage(img.getImage());
        set_chart(cbo);

    }

    private void set_chart(String tgl) {
        String outputFile = System.getProperty("user.dir") + "/csv/absensi_full.xls";

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

        Sheet sheet = workbook.getSheet("Absensi");
        int i = 0, s = 0, a = 0, m = 0, t = 0;
        if (sheet.getLastRowNum() > 0) {
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    if (tgl.equals("Semua")) {
                        
                            String status = String.valueOf(row.getCell(5));
                            if (status.equals("-")) {
                                m++;
                            } else if (status.equals("sakit") || status.equals("Sakit")) {
                                s++;
                            } else if (status.equals("alpha") || status.equals("Alpha")) {
                                a++;
                            } else if (status.equals("izin") || status.equals("Izin")) {
                                i++;
                            } else if (status.equals("terlambat") || status.equals("Terlambat")) {
                                t++;
                            }
                            
                    } else {
                        if (tgl.equals(String.valueOf(row.getCell(0)))) {

                            String status = String.valueOf(row.getCell(5));
                            if (status.equals("-")) {
                                m++;
                            } else if (status.equals("sakit") || status.equals("Sakit")) {
                                s++;
                            } else if (status.equals("alpha") || status.equals("Alpha")) {
                                a++;
                            } else if (status.equals("izin") || status.equals("Izin")) {
                                i++;
                            } else if (status.equals("terlambat") || status.equals("Terlambat")) {
                                t++;
                            }
                        }
                    }
                }
                
     
                
        
              
           }
        DefaultPieDataset dataset= new DefaultPieDataset();
        dataset.setValue("Izin",i);
        dataset.setValue("Sakit",s);
        dataset.setValue("Alpha",a);
        dataset.setValue("Masuk",m);
        dataset.setValue("Terlambat",t);
        String txt = "";
        if(tgl.equals("Semua")){
           txt = ""; 
        } else{
           txt = tgl;
        }
        BarRenderer.setDefaultBarPainter(new StandardBarPainter());
        JFreeChart chart = ChartFactory.createPieChart("Grafik Absensi "+txt,dataset);
        PiePlot plot = (PiePlot) chart.getPlot();
        chart.getPlot().setBackgroundPaint( Color.WHITE );
        plot.setSectionPaint("Izin",new Color(234, 148, 49));
        plot.setSectionPaint("Masuk", new Color(251, 243, 171));
        plot.setSectionPaint("Alpha", new Color(226, 70, 45));
        plot.setSectionPaint("Terlambat", new Color(153, 1, 0));
        plot.setSectionPaint("Sakit", new Color(248, 220, 172));
        ChartPanel pie = new ChartPanel(chart);
        chartObj = pie;
//        final PiePlot3D plot2 = ( PiePlot3D ) chart.getPlot( );             
//      plot2.setStartAngle( 270 );             
//      plot2.setForegroundAlpha( 0.60f );             
//      plot2.setInteriorGap( 0.02 );             
//      int width = 1024;   /* Width of the image */             
//      int height = 720;  /* Height of the image */                             
//      File pieChart3D = new File( "pie_Chart3D.jpeg" );                           
//             try { 
//                 ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );
//             } catch (IOException ex) {
//                 Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, ex);
//             }
//        pie.setPreferredSize(new Dimension(560,367));
//JButton printButton = new JButton("Print");
//		printButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pie.createChartPrintJob();
//			}
//		});
        setContentPane(pie);
                
//        pie.setPreferredSize(new Dimension(600,600));
//        grafik_pie.add(pie); 
           
    } else{
            this.dispose();
            JOptionPane.showMessageDialog(null, "Belum ada data", "Perhatian", JOptionPane.INFORMATION_MESSAGE);
          
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        purinto = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grafik Absensi");
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 600));
        setType(java.awt.Window.Type.POPUP);

        jMenu2.setText("Menu");

        purinto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        purinto.setText("Print");
        purinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purintoActionPerformed(evt);
            }
        });
        jMenu2.add(purinto);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exit.setText("Keluar");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu2.add(exit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void purintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purintoActionPerformed
      chartObj.createChartPrintJob();
    }//GEN-LAST:event_purintoActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chart("-").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem purinto;
    // End of variables declaration//GEN-END:variables
}
