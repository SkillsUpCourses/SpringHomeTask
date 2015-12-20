/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.spreadsheet;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author stoxa
 */
public class SpreadsheetViewer {
    
    public static List<String> getMessagesList(SpreadsheetService service, String spreadsheetName, String worksheetName, String columnName){
    
    List<String> messagesList = null;
    
        try {
            messagesList  = getMessagesListRealisation(service, spreadsheetName, worksheetName, columnName);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    
        return messagesList;
    }
    
    
    private static List<String> getMessagesListRealisation(SpreadsheetService service, String spreadsheetName, String worksheetName, String columnName) throws Exception{

            URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
            List<String> messagesList = new ArrayList<>();

            SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
            List<SpreadsheetEntry> spreadsheets = feed.getEntries();

            for (SpreadsheetEntry spreadsheet : spreadsheets) {               
              if(spreadsheet.getTitle().getPlainText().equals(spreadsheetName)){
                  List<WorksheetEntry> worksheets = spreadsheet.getWorksheets();
                  
                     for (WorksheetEntry worksheet : worksheets) {                         
                      if(worksheet.getTitle().getPlainText().equals(worksheetName)){
                         URL listFeedUrl = worksheet.getListFeedUrl();
                          ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
                          List<ListEntry> list = listFeed.getEntries();
                          
                          for (ListEntry row : list) {                             
                              messagesList.add(row.getCustomElements().getValue(columnName));
                          }

                    }
                    }

              }
            }


    return messagesList;
    }

    
}
