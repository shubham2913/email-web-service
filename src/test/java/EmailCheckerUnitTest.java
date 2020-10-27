import com.shubham.email_web_service.EmailCheckController;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckerUnitTest {

    @Test
    //test method to check whether http response code is correct when mapping and request parameter is correct
    public void checkAPIResponseHappyPathTest(){
        try {
            //creating object of controller class
            EmailCheckController emailCheckController=new EmailCheckController();
            //giving list of strings as request parameter to check if 200 status code is returned
            List<String> emails=new ArrayList<>();
            emails.add("abc@gmail.com");
            ResponseEntity responseEntity=emailCheckController.countUniqueEmails(emails);
            //expected response code is 200
            assertEquals(200,responseEntity.getStatusCode().value());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    //test method to check whether http response code is correct when emails request parameter is not present
    public void checkAPIResponseInternalServerErrorTest(){
        try {
            //creating object of controller class
            EmailCheckController emailCheckController=new EmailCheckController();
            //giving null as request parameter to check if internal server error code (500) is returned
            List<String> emails=null;
            ResponseEntity responseEntity=emailCheckController.countUniqueEmails(emails);
            //expected response code is 500
            assertEquals(500,responseEntity.getStatusCode().value());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    //test method to check whether unique email count returned is correct
    public void checkUniqueEmailCountTest(){
        try {
            //creating object of controller class
            EmailCheckController emailCheckController=new EmailCheckController();
            //creating list of emails which will serve as request parameter
            List<String> emails=new ArrayList<>();
            emails.add("test.email@gmail.com");
            emails.add("test.email+spam@gmail.com");
            emails.add("testemail@gmail.com");
            ResponseEntity responseEntity=emailCheckController.countUniqueEmails(emails);
            String responseMessage=responseEntity.getBody().toString();
            //expected response is 1 in this case
            assertEquals(1,Integer.parseInt(responseMessage));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
