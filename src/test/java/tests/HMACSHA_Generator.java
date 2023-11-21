package tests;

import org.apache.commons.codec.binary.Hex;
import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACSHA_Generator {
    @Test
    public void secureKey() throws NoSuchAlgorithmException, InvalidKeyException {
        String secret = "6C5C8E00CA414513AA1B8F904845FFBB";
        String message = "AccountId=101009300&Password=Voda@123&SenderName=VF-5080&ReceiverMSISDN=01023818181&SMSText=hello one two three four five six seven eight nine";

        Mac mac =  Mac.getInstance("HMACSHA256");

        SecretKeySpec sek = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),"HMACSHA256");
        mac.init(sek);
        String hashkey = Hex.encodeHexString(mac.doFinal(message.getBytes(StandardCharsets.UTF_8)));
        System.out.println(hashkey);
    }
}
