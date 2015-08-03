package com.example.sikar.paybill;

import java.util.HashMap;
import java.util.Map;

import com.example.sikar.web.HttpPostTask;
import com.example.sikar.web.HttpRequest;
import com.example.sikar.web.JSONResponseHandler;
import com.example.sikar.web.MPCZConstants;
import com.example.sikar.web.utils.MySession;


public class PayBill  {

    private Map<String,String> mQueryParameters;
    private TransactionInfo mResult;
    private Account mAccount;

    public PayBill(Account aAccount){
        mAccount = aAccount;
    }

    protected TransactionInfo execute() {

        mQueryParameters = initializeQueryParameters();
        HttpRequest httpGETRequest = new HttpRequest(MPCZConstants.PAYMENT_SCREEN,HttpRequest.HTTP_REQUEST_TYPE.GET,mQueryParameters);
        httpGETRequest.setCookie(MySession.getSessionCookie());
        String httpGETResponse = httpGETRequest.sendGETRequest();
               
        JSONResponseHandler handler = new JSONResponseHandler();
        
        mResult = handler.handleTransactionResponse(httpGETResponse);

        return mResult;
    }

   
    protected void onPostExecute(Object aResult) {
        //mWebView.loadUrl(MPCZConstants.PAYMENT_SCREEN,mQueryParameters);
    }

    private Map<String,String> initializeQueryParameters(){

        BillInfo billInfo = mAccount.getBillInfo();

        Map<String,String> queryParameters = new HashMap<String,String>();
        //Constant properties
        queryParameters.put(MPCZConstants.POST_CHOOSE_IDENTIFIER, MPCZConstants.POST_CHOOSE_IDENTIFIER_VALUE);
        queryParameters.put(BillInfo.BILLER_ID,BillInfo.BILLER_ID_VALUE);
        queryParameters.put(MPCZConstants.RU,MPCZConstants.RU_ACKNOWLEDGMENT_VALUE);
        queryParameters.put(MPCZConstants.PAYMENT_GATEWAY,MPCZConstants.PAYMENT_GATEWAY_VALUE);
        queryParameters.put(MPCZConstants.SELECT_NAME,MPCZConstants.SELET_NAME_VALUE);

        //Account properties
        queryParameters.put(HttpPostTask.POST_ACCOUNT_ID,mAccount.getAccountId());
        queryParameters.put(Account.CUSTOMER_NAME,mAccount.getCustomerName());
        //queryParameters.put(Account.ADDRESS,mAccount.getAddress());
        queryParameters.put("consAddres",mAccount.getAddress());
        //queryParameters.put(Account.CITY,mAccount.getCity());
        queryParameters.put("city",mAccount.getCity());
        queryParameters.put(Account.MOBILE_NO,mAccount.getMobileNumber());
        queryParameters.put(Account.EMAIL_ID,mAccount.getEmailId());
        //Bill properties
        queryParameters.put(BillInfo.BILL_ID,billInfo.getBillId());
        queryParameters.put(BillInfo.AMT_TO_BE_PAID,billInfo.getAmtToBePaid());
        queryParameters.put(BillInfo.OUTSTANDING_AMT,billInfo.getOutStandingAmt());
        queryParameters.put(BillInfo.LAST_BILL_AMT,billInfo.getLastBillAmt());
        queryParameters.put(BillInfo.CURRENT_BILL_AMT,billInfo.getCurrentBillAmt());
        //queryParameters.put(BillInfo.MONTH,billInfo.getBillMonth());
        queryParameters.put("billMon",billInfo.getBillMonth());
        queryParameters.put(BillInfo.ISSUE_DATE,billInfo.getBillIssueDate());
        queryParameters.put("billdueDate",billInfo.getBillDueDate());

        return queryParameters;
    }
}
