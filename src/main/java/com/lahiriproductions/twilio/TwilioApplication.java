package com.lahiriproductions.twilio;

import com.twilio.Twilio;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.ChatGrant;
import com.twilio.jwt.accesstoken.VoiceGrant;
import com.twilio.rest.api.v2010.account.NewKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioApplication {

    public static String ACCOUNT_SID = "AC356f6085564cd8c5c4e23108e231ec77";
    public static String AUTH_TOKEN = "c1f9912a155f853961a50690fd0f485a";
    public static String TWILIO_SERVICE_SID = "SK07fd520ce52605be1d816636aa88a577";
    public static String TWILIO_API_KEY = "SK07fd520ce52605be1d816636aa88a577";
    public static String TWILIO_API_SECRET_KEY = "pBEOq88Cg0QhjWQgbjuHStF0vfNWddpy";
    public static String TWILIO_APP_SID = "AP749f7aacef1b2dfd028536c2b14301a0";

    public static void main(String[] args) {
        SpringApplication.run(TwilioApplication.class, args);

        String twilioAccountSid = System.getenv(ACCOUNT_SID);
        String twilioApiKey = System.getenv(TWILIO_API_KEY);
        String twilioApiSecret = System.getenv(TWILIO_API_SECRET_KEY);

        // Required for Voice
        String outgoingApplicationSid = System.getenv(TWILIO_APP_SID);
        String identity = "user";

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
