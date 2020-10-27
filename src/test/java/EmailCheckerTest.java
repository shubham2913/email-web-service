import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class EmailCheckerTest {

//    @Test
//    //test method to check whether http response code is correct when mapping and request parameter is correct
//    public void checkAPIResponseHappyPathTest(){
//        try {
//            HttpUriRequest request = new HttpGet( "http://localhost:8080/check-emails?emails=abc@gmail.com,xyz@gmail.com" );
//
//            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
//            assertEquals((HttpStatus.SC_OK),
//                    httpResponse.getStatusLine().getStatusCode()
//                    );
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    //test method to check whether http response code is correct when emails request parameter is not present
//    public void checkAPIResponseInternalServerErrorTest(){
//        try {
//            HttpUriRequest request = new HttpGet( "http://localhost:8080/check-emails" );
//
//            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
//            assertEquals((HttpStatus.SC_INTERNAL_SERVER_ERROR),
//                    httpResponse.getStatusLine().getStatusCode()
//                    );
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    //test method to check whether unique email count returned is correct
//    public void checkUniqueEmailCountTest(){
//        try {
//            HttpUriRequest request = new HttpGet( "http://localhost:8080/check-emails?emails=test.email@gmail.com,test.email%2bspam@gmail.com,testemail@gmail.com" );
//
//            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
//            String responseMessage = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
//            assertEquals((Integer.toString(1)),
//                    responseMessage
//                    );
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
