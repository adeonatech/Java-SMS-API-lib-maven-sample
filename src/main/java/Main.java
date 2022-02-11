import net.adeonatech.dto.SendTextBody;
import net.adeonatech.dto.TokenBody;
import net.adeonatech.dto.TransactionBody;
import net.adeonatech.service.SendSMSImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TokenBody tokenBody = new TokenBody();

        //set your username here
        tokenBody.setUsername("{YOUR_USERNAME}");
        //set your username here
        tokenBody.setPassword("{YOUR_PASSWORD}");

        SendSMSImpl sendSMS = new SendSMSImpl();

        SendTextBody sendTextBody = new SendTextBody();

        // set your number list here
        sendTextBody.setMsisdn(sendSMS.setMsisdns(new String[]{"{MOBILE_1}", "{MOBILE_2}"}));
        // set your source address here
        sendTextBody.setSourceAddress("{YOUR_SOURCE_ADDRESS}");
        // set your message here
        sendTextBody.setMessage("{YOUR_MESSAGE}");
        // set the transaction id which is unique id for each SMS submission
        sendTextBody.setTransaction_id("{TRANSACTION_ID}");

        TransactionBody transactionBody = new TransactionBody();
        transactionBody.setTransaction_id("{TRANSACTION_ID}");

        // send SMS and print the SMS status
        System.out.println(sendSMS.sendText(sendTextBody, sendSMS.getToken(tokenBody).getToken()).getStatus());
        // get SMS submission status
        System.out.println(sendSMS.getTransactionIDStatus(transactionBody,sendSMS.getToken(tokenBody).getToken()).getDataTransaction().getCampaign_status());
    }
}
