import net.adeonatech.dto.SendTextBody;
import net.adeonatech.dto.TokenBody;
import net.adeonatech.dto.TransactionBody;
import net.adeonatech.service.SendSMSImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        TokenBody tokenBody = new TokenBody();

        // set your username here
        tokenBody.setUsername("{YOUR_USERNAME}");
        // set your username here
        tokenBody.setPassword("{YOUR_PASSWORD}");

        SendSMSImpl sendSMS = new SendSMSImpl();

        SendTextBody sendTextBody = new SendTextBody();

        // set your number list here
        sendTextBody.setMsisdn(sendSMS.setMsisdns(new String[] { "{MOBILE_1}", "{MOBILE_2}" }));
        // set your source address here
        sendTextBody.setSourceAddress("{YOUR_SOURCE_ADDRESS}");
        // set your message here
        sendTextBody.setMessage("{YOUR_MESSAGE}");
        // set the transaction id which is unique id for each SMS submission
        sendTextBody.setTransaction_id("{TRANSACTION_ID}");

        TransactionBody transactionBody = new TransactionBody();
        transactionBody.setTransaction_id("{TRANSACTION_ID}");

        // send SMS and get the response
        net.adeonatech.dto.SendTextResponse sendTextResponse = sendSMS.sendText(sendTextBody,
                sendSMS.getToken(tokenBody).getToken());

        System.out.println("\"status\": \"" + sendTextResponse.getStatus() + "\",");
        System.out.println("    \"comment\": \"" + sendTextResponse.getComment() + "\",");
        System.out.println("    \"errCode\": \"" + sendTextResponse.getErrCode() + "\",");

        // Add 5-second delay before checking the status
        Thread.sleep(5000);

        // get SMS submission status response
        net.adeonatech.dto.TransactionResponse transactionResponse = sendSMS.getTransactionIDStatus(transactionBody,
                sendSMS.getToken(tokenBody).getToken());

        String campaignStatus = "";
        if (transactionResponse != null && transactionResponse.getDataTransaction() != null) {
            campaignStatus = transactionResponse.getDataTransaction().getCampaign_status();
        }

        System.out.println("\"campaign_status\": \"" + campaignStatus + "\"");
    }
}
