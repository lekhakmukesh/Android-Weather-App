package technosanta.com.retrofitlearning.services;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import technosanta.com.retrofitlearning.model.Currently;
import technosanta.com.retrofitlearning.model.Weather;

/**
 * Created by TechnoSanta on 3/17/18.
 */

public class WeatherServiceProvider {

    private static final String BASE_URL = "https://api.darksky.net/forecast/7b8945816df438900bc9e0da0c5c5226/";
    private static final String TAG = WeatherServiceProvider.class.getSimpleName();
    private Retrofit retrofit;

    Retrofit getRetrofit(){

        if(this.retrofit == null) {

            this.retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }return this.retrofit;
    }


    public void getWeather(double lat, double lon){
        WeatherServices weatherServices = getRetrofit().create(WeatherServices.class);
        Call<Weather> weatherData = weatherServices.getWeather(lat, lon);
        weatherData.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                Currently currently = response.body().getCurrently();
                Log.e(TAG, "Temperature = " + currently.getTemperature());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

                Log.e(TAG, "onFailure: Unable to get weather data");
            }
        });
    }

}
