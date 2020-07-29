package com.example.learnapp.app.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.learnapp.R;
import com.example.learnapp.databinding.UserListItemBinding;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    protected List<UserListItemModel> userList;
    protected Context context;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_list_item, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserListItemModel item = userList.get(position);
        loadAvatar(item, holder);
        holder.binding.setModel(item);

    }

    private void loadAvatar(UserListItemModel item, UserViewHolder holder) {
        Glide.with(context)
                .load(item.getAvatar())
                .apply(new RequestOptions().centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.binding.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public void setUserList(List<UserListItemModel> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        private UserListItemBinding binding;

        public UserViewHolder (@NonNull UserListItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
