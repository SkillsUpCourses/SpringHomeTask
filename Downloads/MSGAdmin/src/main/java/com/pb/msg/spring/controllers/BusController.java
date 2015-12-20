package com.pb.msg.spring.controllers;

import com.pb.msg.busentity.BusEntity;
import static com.pb.msg.busentity.AddBusId.insertBusId;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.annotation.ComponentScan;
import static org.springframework.http.RequestEntity.method;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createbus")
public class BusController {


    @RequestMapping(method = RequestMethod.POST)
    public BusEntity createbus(@RequestParam(value="sid") String sid, 
                             @RequestParam(value="busId") String busId,
                             @RequestParam(value="deparLogin") String deparLogin,
                             @RequestParam(value="respPerson") String respPerson,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="descr") String descr) {
        //РАСКОММЕНТИТЬ
//        try {
//            com.pb.util.gsv.net.protocol.https.SSLContextFactory.registerDefaultSSLSocketFactory();
//        } catch (GeneralSecurityException ex) {
//           ex.printStackTrace(); //Logger.getLogger(AddNewBusId.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String answer = insertBusId(sid, busId, deparLogin, respPerson, email, descr);
        return new BusEntity(sid, busId, deparLogin, respPerson, email, descr, answer);
        
    }
   
    
    
    
}