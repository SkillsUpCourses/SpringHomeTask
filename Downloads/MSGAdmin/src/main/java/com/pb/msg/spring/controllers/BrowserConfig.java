/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.spring.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stoxa
 */
public abstract class BrowserConfig {
    
    
  public static void runBrowser(){
      
      try {
          runDefaultBrowserConfig();
      } catch (Exception ex) {
          ex.printStackTrace();
      }
  
  }
  
  private static void runDefaultBrowserConfig() throws Exception{
  
           if(Desktop.isDesktopSupported()){      
                Desktop.getDesktop().browse(new URI("http:/localhost:8080/"));
        }
  }
    
}
