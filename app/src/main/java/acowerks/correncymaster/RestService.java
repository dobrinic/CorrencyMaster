package acowerks.correncymaster;

import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Aleksandar Dobrinić on 17.3.2016..
 */
public class RestService {

    public String currencyMultiplier;

    public void makeJsonObjectRequest(String currency) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ICurrency.WEB_SERVICE_URL)
                .build();

        ICurrency iCurrency = restAdapter.create(ICurrency.class);

        Callback<GetCurrency> callback = new Callback<GetCurrency>() {

            @Override
            public void success(GetCurrency getCurrency, Response response) {

                currencyMultiplier = getCurrency.getList().getResources().get(0).getResource().getFields().getPrice();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR_Retrofit", error.getMessage());
            }
        };
        iCurrency.getCurrency(currency, callback);
    }

//    public void clickForCurrency (String currency){
//        iCurrency.getCurrency(currency, callback);
//    }
}
