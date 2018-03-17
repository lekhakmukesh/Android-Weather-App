package technosanta.com.retrofitlearning.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import technosanta.com.retrofitlearning.model.Weather;

/**
 * Created by TechnoSanta on 3/17/18.
 */

public interface WeatherServices {
    @GET ("{lat}, {lon}")
    Call<Weather> getWeather(@Path("lat")double lat,@Path("lon") double lon);


}
