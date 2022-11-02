package io.mc.mutalk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        FrameLayout contentFrame = findViewById(R.id.content_frame);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        Fragment homeFragment = new HomeFragment();
        Fragment wallsFragment = new WallsFragment();

        // Top App Bar
        topAppBar.setOnMenuItemClickListener((Toolbar.OnMenuItemClickListener) item -> {
            switch(item.getItemId()) {
                case R.id.search:
                    //TODO: implement search function
                    Toast.makeText(this, "Search function is not implemented.\nHere's ChatActivity for you instead.", Toast.LENGTH_SHORT).show();
                    // show ChatActivity instead
                    Intent chatIntent = new Intent(this, ChatActivity.class);
                    this.startActivity(chatIntent);
                    return true;
                case R.id.account:
                    //TODO: implment AccountActivity
                    Toast.makeText(this, "AccountActivity is not implemented.\nHere's SigninActivity for you instead.", Toast.LENGTH_SHORT).show();
                    // show SigninActivity instead
                    Intent signinIntent = new Intent(this, SigninActivity.class);
                    this.startActivity(signinIntent);
                    return true;
            }
            return false;
        });

        // Bottom Navigation Bar
        //TODO: do not switch fragment if already on current one
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.home:
                    // open HomeFragment
                    getSupportFragmentManager().beginTransaction().replace(contentFrame.getId(), homeFragment).commit();
                    return true;
                case R.id.walls:
                    // open wallsFragment
                    getSupportFragmentManager().beginTransaction().replace(contentFrame.getId(), wallsFragment).commit();
                    return true;
                case R.id.page3:
                    //TODO: replace page3 to meaningful id name
                    Toast.makeText(this, "Page3Fragment is not implemented.", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        });

        // open HomeFragment by default
        getSupportFragmentManager().beginTransaction().replace(contentFrame.getId(), homeFragment).commit();
    }
}