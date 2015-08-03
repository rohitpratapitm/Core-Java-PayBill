package com.example.sikar.paybill;



//public class ShowBill extends Activity {
//
//    private Account mAccount;
//    private Context mContext ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_show_bill);
//
//        mContext = this.getApplicationContext();
//
//        mAccount = (Account)getIntent().getExtras().get("Account");
//
//        TextView customerNameView = (TextView)findViewById(R.id.customer_name);
//        if(mAccount == null){
//            customerNameView.setText("Account object is NULL");
//            return;
//        }
//        BillInfo billInfo = mAccount.getBillInfo();
//
//        customerNameView.setText(mAccount.getCustomerName());
//
//        TextView accountNumberView = (TextView)findViewById(R.id.accountnumber);
//        accountNumberView.setText(mAccount.getAccountId());
//
//        TextView billAmountView = (TextView)findViewById(R.id.billamount);
//        billAmountView.setText(billInfo.getAmtToBePaid());
//
//        TextView billDueDatetView = (TextView)findViewById(R.id.duedate);
//        billDueDatetView.setText(billInfo.getBillDueDate());
//
//        final Button payBillButton = (Button)findViewById(R.id.pay_bill);
//        payBillButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent payBillIntent = new Intent(ShowBill.this,PayBill.class);
//                payBillIntent.putExtra("Account",mAccount);
//                startActivity(payBillIntent);
//            }
//        });
//
//    }
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_show_bill, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
