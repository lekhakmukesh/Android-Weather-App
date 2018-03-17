package technosanta.com.retrofitlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import technosanta.com.retrofitlearning.model.Currently;
import technosanta.com.retrofitlearning.model.Weather;
import technosanta.com.retrofitlearning.services.WeatherServiceProvider;
import technosanta.com.retrofitlearning.services.WeatherServices;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;


    @BindView(R.id.tempTextView) TextView tempTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        requestCurrentWeather(37.8267,-122.4233);

        ButterKnife.bind(this);

    }

    private void requestCurrentWeather(double lat, double lon) {
        WeatherServiceProvider weatherServiceProvider = new WeatherServiceProvider();
        weatherServiceProvider.getWeather(lat, lon);
    }
}
