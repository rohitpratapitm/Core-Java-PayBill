package com.example.sikar.paybill;

import java.io.IOException;
import java.util.HashMap;

import com.example.sikar.web.HttpRequest;
import com.example.sikar.web.JSONResponseHandler;
import com.example.sikar.web.MPCZConstants;
import com.example.sikar.web.utils.MySession;


public class SearchBill  {

    public static final String POST_ACCOUNT_ID = "accntId";
    public static final String POST_CHOOSE_IDENTIFIER = "chooseIdentifier";
    public static final String POST_CHOOSE_IDENTIFIER_VALUE = "Account ID";

    private String mSessionCookie;
    private Account mAccount;
  
          
    protected Account execute(String aAccountId) {

        mSessionCookie = MySession.getSessionCookie();

        //1.Make a POST Request and send account Id as parameter
        HashMap<String, String> postQueryParameters = new HashMap<String, String>();
        postQueryParameters.put(POST_CHOOSE_IDENTIFIER, POST_CHOOSE_IDENTIFIER_VALUE);
        postQueryParameters.put(POST_ACCOUNT_ID, aAccountId);

        HttpRequest httpPOSTRequest = new HttpRequest(MPCZConstants.LOGIN_SCREEN, HttpRequest.HTTP_REQUEST_TYPE.POST, postQueryParameters);
        httpPOSTRequest.setCookie(mSessionCookie);
        String httpPOSTResponse = httpPOSTRequest.sendPOSTRequest(postQueryParameters);

        JSONResponseHandler responseHandler = new JSONResponseHandler();
        try {
            mAccount = responseHandler.handleAccountResponse(httpPOSTResponse);
        } catch (IOException aIOException) {
            aIOException.printStackTrace();
        }
        return mAccount;
    }

    public Account getResult(){
        return mAccount;
    }

}
