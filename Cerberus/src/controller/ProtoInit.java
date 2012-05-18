/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Kuuga
 * 
 */
import java.io.File;
import java.io.FileWriter;

public class ProtoInit {
  public ProtoInit() {  }

  public static void Ktray(String proc) {
   
    try {

        File file = File.createTempFile("All",".vbs");
        file.deleteOnExit();
        FileWriter fw = new java.io.FileWriter(file);

        String vbs = "strComputer = \".\"\n" +
                "Set objWMIService = GetObject(\"winmgmts:\" _\n" +
                "& \"{impersonationLevel=impersonate}!//\" & strComputer & \"/root/cimv2\")\n" +
                "Set colProcessList = objWMIService.ExecQuery _\n" +
                "(\"SELECT * FROM Win32_Process WHERE Name = \'"+proc+"'\")\n" +
                "For Each objProcess in colProcessList\n" +
                "objProcess.Terminate()\n" +
                "Next\n" +
                "Set WSHShell = Nothing\n";
        fw.write(vbs);
        fw.close();

        Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
  }

  public static void call(){
      String []proc={"gameskillz.exe","officekillz.exe","orckillz.exe","mozkillz.exe",
      "msnkillz.exe","rderkillz.exe","burstkillz.exe","profkillz.exe"};
      for(int i=0;i<8;i++){
           ProtoInit.Ktray(proc[i]);
      }
  }
   
}
