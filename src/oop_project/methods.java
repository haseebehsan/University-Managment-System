/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

/**
 *
 * @author Haseeb
 */
public class methods {
    methods(){
        
    }

    public static String char_tostring(char[] a){
        String res = "";
        for(int i = 0; i < a.length; i++){
            res+=a[i];
        }
        return res;
    }
    public static String add_spaces(String input) {
        String output = input;
        for (long i = input.length(); i < 15; i++) {
            output += " ";
        }
        return output;
    }
    public static String remove_spaces(String n) {
        String result = n;
        for (int i = n.length() - 1; i >= 0; i--) {
            if(n.charAt(i) == '-'){
                result = result.substring(0, i);
            }
        }
        return result ;
    }
    
}
