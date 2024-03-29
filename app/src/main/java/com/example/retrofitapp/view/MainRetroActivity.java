package com.example.retrofitapp.view;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofitapp.R;
import com.example.retrofitapp.adapter.ShibeAdapter;
import com.example.retrofitapp.viewmodel.MainViewModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRetroActivity extends AppCompatActivity implements View.OnClickListener {
    //Delcaring private MainViewModel method labeling it viewModel
    private MainViewModel viewModel;
    //Declaring RecyclerView and labeling it retroScreen
    RecyclerView retroScreen;
    Button buttonSwitch;
    Boolean buttonPress = false;

    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_screen);
        //ViewModelProviders not Provider
        viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);
        //callback
        viewModel
                .getShibes(20)
                .enqueue(new Callback<List<String>>() {
                    //ShibeAdapter labeled adapter will be assigned new ShibeAdapter passing in the response.body
                    //retroscreen will use setAdapter method and passing in adapter
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        ShibeAdapter adapter = new ShibeAdapter(response.body());
                        retroScreen.setAdapter(adapter);
                    }

                    // Toast displaying onFailure to run, display Toast "FAILED"
                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Toast.makeText(MainRetroActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
                    }
                });

        buttonSwitch = findViewById(R.id.button_switch);
        buttonSwitch.setOnClickListener(this);

        //  Init retroScreen by findViewById to retro_screen layout
        retroScreen = findViewById(R.id.retro_Screen);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        retroScreen.setLayoutManager(linearLayoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);

        gridLayoutManager = new GridLayoutManager(this, 1);
        retroScreen.setLayoutManager(gridLayoutManager);


//  buttonPress = true;
//  GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//  retroScreen.setLayoutManager(gridLayoutManager)

        //  set LayoutManager method to retroScreen and passing in linearLayoutManager
        retroScreen.setHasFixedSize(true);

        //setting setHasFixedSize on retroScreen to true
    }

    @Override
    public void onClick(View view) {
        if(gridLayoutManager.getSpanCount()== 1 ){
            gridLayoutManager.setSpanCount(4);
            retroScreen.setLayoutManager(gridLayoutManager);
        } else {
            gridLayoutManager.setSpanCount(1);
        }
//        Toast.makeText(this, "SWITCH!", Toast.LENGTH_SHORT).show();
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainRetroActivity.this,4);
//        gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount() == 2 ? 1 : 4);
//        if (buttonPress == true) {
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//            retroScreen.setLayoutManager(linearLayoutManager);
//            buttonPress = false;
//        } else if (buttonPress == false) {
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainRetroActivity.this, 4);
//            retroScreen.setLayoutManager(gridLayoutManager);
//            buttonPress = true;
//        }

    }
}
