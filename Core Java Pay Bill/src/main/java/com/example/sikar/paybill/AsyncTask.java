package main.java.com.example.sikar.paybill;

public abstract class AsyncTask<T1, T2, T3> {

	protected abstract Void doInBackground(String[] params);

	protected abstract void onPostExecute(Void aNull) ;

}
