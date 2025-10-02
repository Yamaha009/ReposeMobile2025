package com.example.simpleanimation_studentname;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;


    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.tv);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.tv) {
            menu.add(0, MENU_ALPHA_ID, 0, "alpha");
            menu.add(0, MENU_SCALE_ID, 0, "scale");
            menu.add(0, MENU_TRANSLATE_ID, 0, "scale");
            menu.add(0, MENU_ROTATE_ID, 0, "scale");
            menu.add(0, MENU_COMBO_ID, 0, "scale");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected  (MenuItem item)
    {
        Animation anim=null;
        int itemId= item.getItemId();
        if(itemId==MENU_ALPHA_ID)
        {
            anim = AnimationUtils.loadAnimation(this,R.anim.myalpha);
        }
        else if (itemId==MENU_SCALE_ID)
        {
            anim = AnimationUtils.loadAnimation(this,R.anim.myscale);
        }
        else if (itemId==MENU_TRANSLATE_ID)
        {
            anim = AnimationUtils.loadAnimation(this,R.anim.mytrans);
        }
        else if (itemId==MENU_ROTATE_ID)
        {
            anim = AnimationUtils.loadAnimation(this,R.anim.myrotate);
        }
        else if (itemId==MENU_COMBO_ID)
        {
            anim = AnimationUtils.loadAnimation(this,R.anim.mycombo);
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}

