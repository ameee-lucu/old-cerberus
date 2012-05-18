/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author kuuga
 */
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import view.ProtoLogin;
public class MyTrayLinux {
    public   void createAndShowGUI(String message) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        final TrayIcon trayIcon =
                new TrayIcon(createImage("/image/icon.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("Main Menu");
        popup.add(aboutItem);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
            trayIcon.displayMessage("Guardian Beta",
                            "The Following Killer is up And Running:\n"+message, TrayIcon.MessageType.INFO);
                            
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }


        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ProtoLogin protoLogin=new ProtoLogin();
                protoLogin.lblExit.setVisible(false);
                protoLogin.show();
                tray.remove(trayIcon);
                trayIcon.removeActionListener(this);

            }
        });




    }
        public static Image createImage(String path, String description) {
        URL imageURL = MyTrayLinux.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
        

}
