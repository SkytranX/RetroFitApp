package com.example.retrofitapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.retrofitapp.R;
import com.example.retrofitapp.repository.Repository;

import java.util.List;

import retrofit2.Call;

//Two different ways extend ViewModel
public class MainViewModel extends AndroidViewModel {
    // 2 extends AndroidViewModel alt+enter >create constructor

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public Call<List<String>> getShibes(int count) {
        return Repository.getInstance().getShibes(count);
    }
}
