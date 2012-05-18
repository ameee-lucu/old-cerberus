/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Nadya
 */
public class ProtoInitPy {
    public static void kill() {

    try {
        File file = File.createTempFile("ProtoInitpy", ".py");
        file.deleteOnExit();
        FileWriter fw = new java.io.FileWriter(file);
                String python ="import os\n" +
                        "os.system(\"pkill python\")\n" +
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
