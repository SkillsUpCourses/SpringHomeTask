/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.msg.busentity;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.lang.StringBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ЕКБ
 */
 public abstract class AddBusId {
    
   
   
    public static String insertBusId(String sid, String busId, String deparLogin, String respPerson, String email, String descr) {
    
    
    String answer = null;
    StringBuilder builder = builRequest(sid, busId, deparLogin,respPerson, email, descr);
    
    try {
         answer = sendBusIdInsertRequest(builder);
    } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
    }
    
    return analizeAnswer(answer, busId);
    }
 
    
    private static String sendBusIdInsertRequest(StringBuilder builder) throws UnsupportedEncodingException {
    
        String answer = null;    
        byte[] buff = null;      
        //РАСКОММЕНТИТЬ
        //buff = Utils.client.post(Utils.url, builder.toString().getBytes("UTF-8"));
        //ЗАКОММЕНТИТЬ
        buff = builder.toString().getBytes("UTF-8");
        System.out.println(builder.toString());

        return (answer!=null)?answer:"answer";    
    }  
    
    private static StringBuilder builRequest(String sid, String busId, String deparLogin, String respPerson, String email, String descr){
    
    StringBuilder builder = new StringBuilder();
    
    builder.setLength(0);
    builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    builder.append("<doc>");
    builder.append("<r sid=\"").append(sid).append("\" t=\"BUS_PROC_ADD_AND_EDIT\">");
    builder.append("<s BusId=\"").append(busId).append("\" DeparLogin=\"").append(deparLogin);
    builder.append("\" ResponsiblePerson=\"").append(respPerson).append("\" Email=\"").append(email);
    builder.append("\" Descr=\"").append(descr).append("\"/>");
    builder.append("</r>");
    builder.append("</doc>");
    
    return  builder;
    
    }
    
    private static String analizeAnswer(String answer, String busId){
        
    if (answer.contains("<BUS_PROC_ADD_AND_EDIT/>")) {
        
        System.out.println("BusId "+busId+" added");
        System.out.println("BusId "+busId+" added");
        return "BusId "+busId+" added";
        
    }  else {
            String [] line =  answer.split("\" ");
            String err = null;
            
            for(String item : line){
                if(item.contains("errtext=")){
                    err = item;
                    break;
                }
    
            }
        System.out.println(err);    
        return err;
    }
    
    
    }
}
