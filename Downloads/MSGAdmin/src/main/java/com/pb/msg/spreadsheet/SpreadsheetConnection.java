/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.spreadsheet;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import java.awt.Desktop;
import java.net.URI;
import java.util.Arrays;



/**
 *
 * @author stoxa
 */
public class SpreadsheetConnection {
    private static final String CLIENT_ID = "192706670878-vlq7b3s98svjke0ck2o93f6h7lsl3pk2.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "Vb9-e6rqtdr74GYPTG7h_8Tq";
            static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    
    public static GoogleAuthorizationCodeFlow getConnection(){
        GoogleAuthorizationCodeFlow connection =null;
        try {
            connection = getDefaultConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  connection;
    }
    
    private static GoogleAuthorizationCodeFlow getDefaultConnection() throws Exception{
        
            HttpTransport httpTransport = new NetHttpTransport();
            JsonFactory jsonFactory = new JacksonFactory();

            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET,
                    Arrays.asList(DriveScopes.DRIVE, 
                                  "https://spreadsheets.google.com/feeds", 
                                  "https://docs.google.com/feeds"))
                    .setAccessType("online")
                    .setApprovalPrompt("auto").build();

            String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();

            if(Desktop.isDesktopSupported()){      
                    Desktop.getDesktop().browse(new URI(url));
            }
            return flow;
    }    
}
