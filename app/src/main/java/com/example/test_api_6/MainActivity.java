package com.example.test_api_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvID;
    private TextView tvTitle;
    private Button btnCallApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvID = findViewById(R.id.tv_id);
        tvTitle = findViewById(R.id.tv_title);
        btnCallApi = findViewById(R.id.btn_callapi);

        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
            }
        });

    }

    private void clickCallApi() {

        // https://api.themoviedb.org/3/movie/popular?api_key=ab0667fb0b0c1e076bd874cf0a174098&language=en-US&page=1
        ApiService.apiService.convertData("ab0667fb0b0c1e076bd874cf0a174098"
                                           , "en-US"
                                           , 1)
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Toast.makeText(MainActivity.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();

                        Data data = response.body();
                        if (data != null) {
                            tvID.setText(data.getResults().getId());
                            tvTitle.setText(data.getResults().getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}