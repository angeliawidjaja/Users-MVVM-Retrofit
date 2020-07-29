package com.example.learnapp.app.userlistdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.learnapp.R;
import com.example.learnapp.databinding.ActivityUserListDetailBinding;

public class UserListDetailActivity extends AppCompatActivity {
    private UserListDetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserListDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list_detail);
        viewModel = ViewModelProviders.of(this).get(UserListDetailViewModel.class);
        setListener(binding);
        getDetailData();
    }

    private void setListener(final ActivityUserListDetailBinding binding) {
        viewModel.getEventID().observe(this, new Observer<Integer>(){
            @Override
            public void onChanged(Integer integer) {
                if(integer == viewModel.NODATA){
                    Toast.makeText(UserListDetailActivity.this, "No User List Data!", Toast.LENGTH_SHORT).show();
                }
                else if(integer == viewModel.FAILED){
                    Toast.makeText(UserListDetailActivity.this, "Failed to Request Data!", Toast.LENGTH_SHORT).show();
                }
                else if(integer == viewModel.SUCCESS){
                    loadPhoto(binding);
                    binding.setViewmodel(viewModel.getUserDetailData());
                    Toast.makeText(UserListDetailActivity.this, "Complete Providing User Detail Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadPhoto(ActivityUserListDetailBinding binding){
        Glide.with(this)
                .load(viewModel.getUserDetailData().getData().getAvatar())
                .apply(new RequestOptions().centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivAvatar);
    }

    private void getDetailData() {
        Bundle extra = getIntent().getExtras();

        if(extra != null){
            viewModel.requestUserDetailData(Integer.valueOf(extra.getString("id")));
        }
        else{
            Toast.makeText(this, "ID Key Empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
