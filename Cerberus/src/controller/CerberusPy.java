/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author kuuga
 */
import java.io.File;
import java.io.FileWriter;

public class CerberusPy {
    
    //file.setWritable(true);
    public static void kill(String[]items) {
      
    try {
        File file=File.createTempFile("Cerberus", ".py");
        file.deleteOnExit();
        FileWriter fw = new java.io.FileWriter(file);

        String python ="import os\n" +
                        "import time\n" +
                        "varSeq={1:\""+items[0]+"\",2:\""+items[1]+"\",3:\""+items[2]+"\",4:\""+items[3]+"\",5:\""+items[4]+"\",6:\""+items[5]+"\",7:\""+items[6]+"\",8:\""+items[7]+"\"}\n" +
                        "saveKey=[]\n" +
                        "x=1\n" +
                        "for key in varSeq:\n" +
                        "   if varSeq[key]==\"null\":\n" +
                        "       saveKey.append(key)\n" +
                        "for i in saveKey:\n" +
                        "   del varSeq[i]\n" +
                        "while 1:\n" +
                        "   for newKey in varSeq:\n" +
                        "       os.system(\"pkill \"+varSeq[newKey])\n" +
                        "       time.sleep(5)\n"+
                        "";
        fw.write(python);
        fw.close();

        Process p = Runtime.getRuntime().exec("python " + file.getPath());
        

    }
    catch(Exception e){
        e.printStackTrace();
    }


  }
    


}
