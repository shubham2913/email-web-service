package com.shubham.email_web_service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailCheckController {

    @GetMapping("/unique-emails")
    public ResponseEntity countUniqueEmails(@RequestParam(value = "emails", required = false) List<String> emails) {
        try {
            //getting total number of emails passed in query
            int n= emails.size();

            //creating a set which will hold all unique emails
            Set<String> uniqueEmails=new HashSet<>();

            //iterating over all emails and creating a parsed email in accordance with Gmail account matching rules
            for(String email : emails){
                int l=email.length();
                //ignoring empty emails
                if(l==0)
                    continue;
                //iterating over the email from the end and finding the index of last @ character
                int index=-1;
                for(int i=l-1;i>=0;i--){
                    if(email.charAt(i)=='@'){
                        index=i;
                        break;
                    }
                }

                //if @ character is not present or if email address begins with @(no username) or ends at @(no domain), address is not valid, moving on to the next email
                if(index<=0 || index==l-1)
                    continue;
                //creating string builder object to hold the parsed email address
                StringBuilder parsedEmail=new StringBuilder();

                //iterating over the address till the last @ index calculated above
                for(int i=0;i<index;i++){
                    //if current character is +, we need to ignore the rest of the username
                    if(email.charAt(i)=='+')
                        break;
                    else if(email.charAt(i)!='.')
                        parsedEmail.append(email.charAt(i));
                }
                parsedEmail.append(email.substring(index,l));
                System.out.println("parsed email is : " + parsedEmail.toString());
                //adding parsed email to uniqueEmails set.
                uniqueEmails.add(parsedEmail.toString());
            }

            return new ResponseEntity<>(Integer.toString(uniqueEmails.size()), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

