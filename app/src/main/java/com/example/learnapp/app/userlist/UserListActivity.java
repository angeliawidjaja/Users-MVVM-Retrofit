package com.example.learnapp.app.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.learnapp.R;
import com.example.learnapp.app.MainNavigator;
import com.example.learnapp.app.userlistdetail.UserListDetailActivity;
import com.example.learnapp.databinding.ActivityUserListBinding;

public class UserListActivity extends AppCompatActivity implements MainNavigator {
    private UserListAdapter adapter;
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);
        viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);

        setAdapter(binding);
        getData();
        setListener(binding);
    }

    private void getData() {
        viewModel.requestSelectedData();
    }

    private void setAdapter(ActivityUserListBinding binding) {
        binding.rvUserList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(getBaseContext(), this);
        binding.rvUserList.setAdapter(adapter);
    }

    private void setListener(ActivityUserListBinding binding){
        binding.btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

        viewModel.getEventID().observe(this, new Observer<Integer>(){
            @Override
            public void onChanged(Integer integer) {
                if(integer == viewModel.EXCEED){
                    Toast.makeText(UserListActivity.this, "You have reached last page!", Toast.LENGTH_SHORT).show();
                }
                else if(integer == viewModel.NODATA){
                    Toast.makeText(UserListActivity.this, "No User List Data!", Toast.LENGTH_SHORT).show();
                }
                else if(integer == viewModel.FAILED){
                    Toast.makeText(UserListActivity.this, "Failed to Request Data!", Toast.LENGTH_SHORT).show();
                }
                else if(integer == viewModel.SUCCESS){
                    adapter.setUserList(viewModel.getData().getUserList());
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, UserListDetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
