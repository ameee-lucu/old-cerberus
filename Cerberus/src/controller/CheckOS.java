/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author kuuga
 */
import java.util.*;
public class CheckOS {
    public String getProp(){
        boolean completed=false;
        String os=null;
        try{
            Properties properties=System.getProperties();
            Enumeration enumeration=properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key=(String) enumeration.nextElement();
                String value=System.getProperty(key);
                if (key.equals("os.name") && value.equalsIgnoreCase("Linux")) {
                    os="Linux";
                }if(key.equals("os.name") && value.equalsIgnoreCase("Windows XP")){
                    os="windows";
                    
                }
            }

            completed=true;
        }finally{

        }

        return os;
    }
    

}
