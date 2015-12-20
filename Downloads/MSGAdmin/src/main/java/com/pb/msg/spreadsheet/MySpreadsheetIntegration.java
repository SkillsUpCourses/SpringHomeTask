/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.spreadsheet;

/**
 *
 * @author stoxa
 */

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import static com.pb.msg.spreadsheet.SpreadsheetAuth.getAuth;
import static com.pb.msg.spreadsheet.SpreadsheetConnection.*;
import static com.pb.msg.spreadsheet.SpreadsheetViewer.getMessagesList;
import java.util.List;


public class MySpreadsheetIntegration {


    public static void mainSpread(String[] args) throws Exception {

        GoogleAuthorizationCodeFlow flow  = getConnection();
        SpreadsheetService service = getAuth(flow); 
        List<String> messagesList = getMessagesList(service, "Список ошибок", "Лист1", "GeneratedRow");
        
        for(String msg : messagesList){
        
            System.out.println(msg);
        
        }

    }
}
