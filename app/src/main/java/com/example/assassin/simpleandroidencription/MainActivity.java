package com.example.assassin.simpleandroidencription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         String EncryptedtextFromNodeJS = "+6OMoj9Xi0a42XFWHtboMAgNPRFv785ajCJ61qxjRLHsalZeyGueEn/yKuI5+Ar2KELz9csYnxcbUa/jRuVTHW616UrWI2/oMiOqXUy348fL6yFJFztdCu5wvf9AkkrMP1rcxF9bM4HaQP1HJ6fy25pOlcUf0EEYFuzz53Hal2s=";
         String exchangeKey = "dskmpadjosa";

         String yourResponse = "YourPlainTextOrWhatEver";
        try {
            CryptLib cryptLib = new CryptLib();
            //DecryptionTextFromNodeOrIos
            String decryptedText = cryptLib.decryptCipherTextWithRandomIV(EncryptedtextFromNodeJS,exchangeKey);
            Log.d("DECRYPT TXT IS==>", decryptedText);

            JSONArray objectDecryption = new JSONArray(decryptedText);
            //Please use debugMode here to see JSONArrayValue/JSONObject after parse
            Log.d("DECRYPT OBJ IS==>", objectDecryption.toString());

            //Encrypt what ever you want to send out for (node.js , ios)
            CryptLib cryptLib2 = new CryptLib();
            //Please make sure how yourResponse Should be then transform it to String first before use method below
            String cipherText = cryptLib2.encryptPlainTextWithRandomIV(yourResponse, exchangeKey);
            Log.d("ENCRYPT TXT IS==>", cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
