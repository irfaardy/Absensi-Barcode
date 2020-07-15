 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Atalanta
 */
public class Lib_login {
    public static String session_username="";
    public static String session_level="";
    public static String message = "";
    public static Map<String,Integer> username = new HashMap<>();
    private static String[] password = new String[]{"12345", "67890","manager"};
    private static String[] level = new String[]{"admin", "manager","manager"};
    
    public static void instalasi_pengguna(){
         username.put("administrator",0);
         username.put("irfa",1);
         username.put("manager",2);
    }
    public static boolean hak_akses(String level){
        if(username.equals(level)){
           return true;
        } else {
            
            return false;
        }
    }
    public static boolean proses_login(String tx_username,String tx_password){
        if (username.containsKey(tx_username)) {
            int key = username.get(tx_username);
            if (password[key].equals(tx_password)) {
                session_level = level[key];
                session_username = tx_username.toLowerCase();
                return true;
            } else {
                message = "Password Salah silahkan coba lagi!";
                return false;
            }

        } else {
            message = "Username tidak ditemukan! mohon cek kembali";
            return false;
        }
    }
    
    public static void is_login(){
         if(Lib_login.session_username.equals("")){
            JOptionPane.showMessageDialog(null, "Dimohon Untuk Login dahulu!", "Perhatian", JOptionPane.WARNING_MESSAGE);
        
            System.exit(0);
        }
    }
}
