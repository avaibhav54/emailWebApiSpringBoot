package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class emailController {

    @Autowired
    private com.email.service.emailService emailService;

    @RequestMapping("/welcome")
public String welcome()
{
    return "this is my email api";
}

    @PostMapping("/sendemail")
    public ResponseEntity<?> sendmail(@RequestBody EmailRequest request)
    {
        System.out.println(request.getMessage()+" "+request.getSubject()+" "+request.getTo());
        boolean result=
        this.emailService.sendEmail(request.getMessage(),request.getSubject(),request.getTo(),"notvalid99999@gmail.com");
        if(result)
            return ResponseEntity.ok("Done");
        return ResponseEntity.ok("error");

    }

}
