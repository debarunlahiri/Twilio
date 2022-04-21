package com.lahiriproductions.twilio;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.ChatGrant;
import com.twilio.jwt.accesstoken.VoiceGrant;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.NewKey;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioApplication {

    public static String ACCOUNT_SID = "AC356f6085564cd8c5c4e23108e231ec77";
    public static String AUTH_TOKEN = "b7a0ec32dd02b0edec9ad9a14bf3eed7";
    public static String TWILIO_SERVICE_SID = "VAacf68c0dc30020d18a371b63a65b4472";
    public static String TWILIO_API_KEY = "SK07fd520ce52605be1d816636aa88a577";
    public static String TWILIO_API_SECRET_KEY = "pBEOq88Cg0QhjWQgbjuHStF0vfNWddpy";
    public static String TWILIO_APP_SID = "AP749f7aacef1b2dfd028536c2b14301a0";

    public static void main(String[] args) {
        SpringApplication.run(TwilioApplication.class, args);

//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        NewKey newKey = NewKey.creator().setFriendlyName("cart-all").create();
//
//        System.out.println(newKey);

        String twilioAccountSid = ACCOUNT_SID;
        String twilioApiKey = "SK83feb4c590ba857b6058ffe9f56ab85e";
        String twilioApiSecret = "zcTLBpdqA0QoY55XvNWHWHKLd5MSTyV9";

        // Required for Voice
        String outgoingApplicationSid = System.getenv("VAacf68c0dc30020d18a371b63a65b4472");
        String identity = "dialandgetservice@gmail.com";

        // Create Voice grant
        VoiceGrant grant = new VoiceGrant();
        grant.setOutgoingApplicationSid(outgoingApplicationSid);

        // Optional: add to allow incoming calls
        grant.setIncomingAllow(true);

        // Create access token
        AccessToken token = new AccessToken.Builder(
                twilioAccountSid,
                twilioApiKey,
                twilioApiSecret
        ).identity(identity).grant(grant).build();

        System.out.println(token.toJwt());
    }

}
