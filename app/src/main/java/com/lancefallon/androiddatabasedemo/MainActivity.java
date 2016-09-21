package com.lancefallon.androiddatabasedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lancefallon.androiddatabasedemo.dao.UserDao;
import com.lancefallon.androiddatabasedemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String Tag = "MAIN_ACTIVITY";

    private List<User> mUsers = new ArrayList<User>();
    private UserDao mUserDao;

    private Button submitNameButton;
    private EditText editNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNameText = (EditText)findViewById(R.id.main_activity_edit_text);
        submitNameButton = (Button)findViewById(R.id.main_activity_submit_name);
        submitNameButton.setOnClickListener(this);

        this.mUserDao = UserDao.getInstance();
        refreshList();
    }

    private void refreshList(){
        this.mUsers = mUserDao.getUsers(this);
        showUsers();
    }

    private void showUsers() {
        for (User user : mUsers){
            Log.d(Tag, user.toString());
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.main_activity_submit_name) {
            String name = editNameText.getText().toString();
            if (!name.isEmpty()) {
                long id = mUserDao.addUser(this, name);
                mUsers.add(new User(id, name));
                showUsers();
                editNameText.getText().clear();
            }
        }
    }
}
