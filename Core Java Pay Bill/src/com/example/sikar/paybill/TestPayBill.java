package com.example.sikar.paybill;

import com.example.sikar.web.utils.MySession;

public class TestPayBill {

	public static void main(String[] args) {
		
		String sessionCookie = MySession.getSessionCookie();
		
		SearchBill searchBill = new SearchBill();
		Account account = searchBill.execute("9493692000");
		
		System.out.println(account.getAccountId());
		PayBill payBill = new PayBill(account);
			
		System.out.println(payBill.execute());
	}

}
