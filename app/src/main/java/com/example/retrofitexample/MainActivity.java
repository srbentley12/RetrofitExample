package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);

        //retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Instance of interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                //check for a response
                if(response.code() != 200){
                    txt.setText("Check the connection");
                    return;
                }

                //Get the data into the textView
                String json = "";

                json = "ID= " + response.body().getId() +
                        "\nuserId= " + response.body().getUserId() +
                        "\ntitle= " + response.body().getTitle() +
                        "\nstatus= " + response.body().isStatus();

                txt.setText(json);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }
}