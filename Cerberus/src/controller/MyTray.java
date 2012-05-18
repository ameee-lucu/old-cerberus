/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.*;
import java.net.URL;
import javax.swing.ImageIcon;
import view.ProtoLogin;

/**
 *
 * @author Kuuga
 */
public class MyTray {

    public TrayIcon trayIcon =
            //buat icon system tray
        new TrayIcon(createImage("/image/icon.png", "tray icon"));
        public SystemTray tray = SystemTray.getSystemTray();


        
    protected static Image createImage(String path, String description) {
        URL imageURL = MyTray.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    public void showMessageAll(String message) {
    trayIcon.displayMessage("Guardian Beta",
                            "The Following Killer is up And Running:\n"+message, TrayIcon.MessageType.INFO);
    }
    public void init() {
        trayIcon.setToolTip("Guardian Beta");
        trayIcon.displayMessage("Guardian Beta",
                            "The System is up and Running", TrayIcon.MessageType.INFO);
    }

    public void showMessageBurstMode() {
        trayIcon.displayMessage("Guardian Beta",
                            "The Following Killer is up And Running:\nBurstModeKiller", TrayIcon.MessageType.INFO);
    }

    public void AddTrayListener(){
        trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Object obj = e.getSource();
                    if (obj==trayIcon) {
                        ProtoLogin a=new ProtoLogin();
                        a.setVisible(true);
                        a.lblExit.setVisible(false);
                        tray.remove(trayIcon);
                        }
                    }
                });
    }
    public void AddTrayIcon(){
        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        }

    }

}
