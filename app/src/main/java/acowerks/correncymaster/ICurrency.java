package acowerks.correncymaster;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Aleksandar Dobrinić on 17.3.2016..
 */
public interface ICurrency {

    public static final String WEB_SERVICE_URL = "http://finance.yahoo.com/webservice/v1/symbols";

    @GET("/{id}=X/quote?format=json")
    void getCurrency (@Path("id") String id, Callback<GetCurrency> callback);
}
