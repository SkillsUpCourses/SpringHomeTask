/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.spreadsheet;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import static com.pb.msg.spreadsheet.SpreadsheetConnection.REDIRECT_URI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author stoxa
 */
public class SpreadsheetAuth {
    
    public static SpreadsheetService getAuth(GoogleAuthorizationCodeFlow flow){
    
        SpreadsheetService service = null;
        String authCode = null;
        
        try {
            authCode = getAuthCode();
            service = getDefaultAuth(flow, authCode);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        return service;
    
    }
    
    private static SpreadsheetService getDefaultAuth(GoogleAuthorizationCodeFlow flow, String authCode) throws IOException{
    
        GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(REDIRECT_URI).execute();
        GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);

            // create the service and pass it the credentials you created earlier
        SpreadsheetService service = new SpreadsheetService("MSGproject");
        service.setOAuth2Credentials(credential);
        return service;
    } 
    
    private static String getAuthCode() throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        return code;
        
    }
    
}
