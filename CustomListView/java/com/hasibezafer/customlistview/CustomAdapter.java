package com.hasibezafer.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hasibezafer on 18.02.2017.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<User> userList;

    public CustomAdapter(Activity activity, List<User> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.custom_layout, null);
        TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
        TextView textViewSystemClock = (TextView) lineView.findViewById(R.id.textViewSystemClock);
        ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);

        User user = userList.get(i);
        textViewUserName.setText(user.getUserName());
        textViewSystemClock.setText(user.getCurrentTime());

        if (user.isUserGender()) {
            imageViewUserPicture.setImageResource(R.drawable.women_profile);
        } else {
            imageViewUserPicture.setImageResource(R.drawable.man_profile);
        }

        return lineView;
    }
}
