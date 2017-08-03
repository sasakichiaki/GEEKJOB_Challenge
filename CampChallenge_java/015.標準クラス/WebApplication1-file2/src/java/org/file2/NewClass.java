/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.file2;
import java.io.*;

/**
 *
 * @author sasakichiaki
 */
public class NewClass {
    
    public static void main(String[] args) {
        
        File fp = new File("zikosyoukai/sasaki.txt");
        
        try{
            
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            
            System.out.print(br.readLine());
            
        } catch(Exception ex) {
            
        }
        
    }
    
}
