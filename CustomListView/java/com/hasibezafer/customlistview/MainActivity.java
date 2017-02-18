package com.hasibezafer.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDateFormat clockFormat = new SimpleDateFormat("hh:mm:ss");
        GregorianCalendar gcalender = new GregorianCalendar();
        String currentTime = clockFormat.format(gcalender.getTime());
        
        users.add(new User("Gözde Yaşar", true, currentTime));
        users.add(new User("Hüseyin Coşkun", false, currentTime));
        users.add(new User("Seda Karataş", true, currentTime));
        users.add(new User("Fatih Keskin", false, currentTime));
        users.add(new User("Betül Çiçek", true, currentTime));
        users.add(new User("Fatih Ballı", false, currentTime));
        users.add(new User("Hanife Bakal", true, currentTime));
    
        final ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, users);
        listView.setAdapter(adapter);
    }
}
