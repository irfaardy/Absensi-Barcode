/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penyimpanan;

import absensi.Form_absen_otomatis;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author Atalanta
 */
public class Karyawan {
public static Map<String,String> map = new HashMap<>();
public static Map<String,String> kry_map = new HashMap<>();   
   public static void isi_map(){
       String outputFile = System.getProperty("user.dir") + "/csv/data_Karyawan.xls";

       FileInputStream inputStream;
       inputStream = null;
       try {
           inputStream = new FileInputStream(outputFile);
       } catch (FileNotFoundException ex) {

           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
       }
       Workbook workbook = null;
       try {
           workbook = new HSSFWorkbook(inputStream);
       } catch (IOException ex) {
          
           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
       }

       Sheet sheet = workbook.getSheet("karyawan");
       for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
           Row row = sheet.getRow(rowIndex);
           if (row != null) {
               Cell rfid = row.getCell(0);
               Cell nama = row.getCell(1);
              map.put(String.valueOf(rfid),String.valueOf(nama));
           }

    }
   }
   
    public static void refresh_penyimpanan_absen(){
       String outputFile = System.getProperty("user.dir") + "/csv/absensi.xls";

       FileInputStream inputStream;
       inputStream = null;
       try {
           inputStream = new FileInputStream(outputFile);
       } catch (FileNotFoundException ex) {

           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
       }
       Workbook workbook = null;
       try {
           workbook = new HSSFWorkbook(inputStream);
       } catch (IOException ex) {
          
           Logger.getLogger(Form_absen_otomatis.class.getName()).log(Level.SEVERE, null, ex);
       }
  
       Sheet sheet = workbook.getSheet("Absensi");
       for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
           Row row = sheet.getRow(rowIndex);
           if (row != null) {
               Cell tanggal= row.getCell(0);
               Cell rfid = row.getCell(1);
                kry_map.put(String.valueOf(tanggal),String.valueOf(rfid));
           }
          
    }
       
            System.out.println(kry_map.size());
                    
        
   }
   
}
