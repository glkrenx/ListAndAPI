package com.glkrenx.bermainlistdanapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.glkrenx.bermainlistdanapi.adapter.DataAdapter;
import com.glkrenx.bermainlistdanapi.data.remote.APIService;
import com.glkrenx.bermainlistdanapi.model.get.APIResponse;
import com.glkrenx.bermainlistdanapi.model.get.Records;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*menggunakan komponen listview*/
    ListView listView;
    /*memanggil response api untuk mendapatkan response sesui api yang dituju*/
    Call<APIResponse> apiResponseCall;
    /*Sebuah variable list untuk menampung data dari API response. FYI: sesuain dengan kebutuhan*/
    ArrayList<String> namaTaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Set layout yang menjadi reference Activity ini*/
        setContentView(R.layout.activity_main);
        /*set reference listview berdasarkan id*/
        listView = (ListView)findViewById(R.id.listView);
        /*inisialisasi list namaTaksi*/
        namaTaksi = new ArrayList<>();

        /*Memanggil method getAPI untuk mendapatkan response API dan melakukan set ke adapter listviewnya*/
        getAPI();

        /****Penggunaan data dummy/sample ke listview****/
        /*String[] movies = {"Merah Putih", "The Raid 2", "Laskar Pelangi", "Merantau", "Habibie & Ainun", "The Raid"};

        for (int i = 0; i < movies.length; i++){
            namaTaksi.add(movies[i]);
            listView.setAdapter(new DataAdapter(MainActivity.this, namaTaksi));
        }

        listView.setAdapter(new DataAdapter(this, namaTaksi));*/
    }

    private void getAPI(){
        apiResponseCall = APIService.service.getResult("b03c4e46-c6c2-4ed2-9c57-7360de3b3827", 5);

        apiResponseCall.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.isSuccessful()){
                    // here it is the cool thing when response is successful
                    APIResponse body = response.body();
                    for (int i = 0; i < body.getResult().getRecords().size(); i++){
                        Records records = body.getResult().getRecords().get(i);

                        namaTaksi.add(records.getNamaTaksi());
                    }
                    listView.setAdapter(new DataAdapter(MainActivity.this, namaTaksi));
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                // do something cool when its fauilure
            }
        });
    }
}