/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.ProtoMainMenu;
import javax.swing.JOptionPane;
import view.ProtoMainMenuLinux;


/**
 *
 * @author Nadya
 */
public class Login {
ProtoMainMenu protoMainMenu=new ProtoMainMenu();
ProtoMainMenuLinux protoMainMenuLinux=new ProtoMainMenuLinux();
MyTray myTray=new MyTray();
CheckOS checkOS=new CheckOS();
String result=null;
    public String login(String username,String password){
        if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin")){
            result="SUCCESS";
        }
        else if("".equalsIgnoreCase(username)||"".equalsIgnoreCase(password)){
            result="INPUT";
        }
        else{
            result="FAILED";
        }
        return result;
    }

    public void checkLogin(String result){
        if (result.equals("SUCCESS")){
            checkOS();
        }
        else if(result.equals("INPUT")){
            JOptionPane.showMessageDialog(null,"Username/password tidak boleh kosong!","Warning",JOptionPane.WARNING_MESSAGE);
            myTray.AddTrayIcon();
            myTray.AddTrayListener();


        }else{
            JOptionPane.showMessageDialog(null,"Maaf,Username atau Password anda Salah!","Warning",JOptionPane.WARNING_MESSAGE);
            myTray.AddTrayIcon();
            myTray.AddTrayListener();
        }
    }

    public void checkOS(){
        
        if (checkOS.getProp().equals("Linux")) {
            ProtoInitPy.kill();
            protoMainMenuLinux.show();
        }else{
            ProtoInit.call();
            protoMainMenu.show();
        }

    }
}
