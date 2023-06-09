package com.example.a20230501_android_menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int ID_GROUP_TEXT_COLOR = 1;
    public static final int ID_GROUP_TEXT_STYLE = 2;
    public static final int ID_GROUP_TEXT_SIZE = 3;
    public static final int ID_GROUP_ARTIST = 4;
    public static final int ID_GROUP_ALBUM = 5;
    public static final int ID_GROUP_SONG = 6;
    public static final int ID_GROUP_MOVIE = 7;

    public static final int ID_COLOR_RED = 11;
    public static final int ID_COLOR_GREEN = 12;
    public static final int ID_COLOR_BLUE = 13;

    public static final int ID_TEXT_NORMAL = 21;
    public static final int ID_TEXT_BOLD = 22;
    public static final int ID_TEXT_ITALIC = 23;

    public static final int ID_TEXTSIZE_10P = 31;
    public static final int ID_TEXTSIZE_18P = 32;
    public static final int ID_TEXTSIZE_24P = 33;

    TextView objTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTxtView = (TextView) findViewById(R.id.textView1);

        registerForContextMenu(objTxtView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu mnuTextColor = menu.addSubMenu("Text Color");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_RED, 1, "Red");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_GREEN, 2, "Green");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_BLUE, 3, "Blue");

        SubMenu mnuTextStyle = menu.addSubMenu("Text Style");
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_NORMAL, 1, "Normal").setChecked(true);
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_BOLD, 2, "Bold").setChecked(true);
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_ITALIC, 3, "Italic").setChecked(true);

        SubMenu mnuTextSize = menu.addSubMenu("Text Size");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_10P, 1, "10 Pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_18P, 2, "18 Pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_24P, 3, "24 Pt");

        SubMenu mnuArtist = menu.addSubMenu("Artist");
        mnuArtist.setIcon(R.drawable.artist);

        SubMenu mnuAlbum = menu.addSubMenu("Album");
        mnuAlbum.setIcon(R.drawable.album);

        SubMenu mnuSong = menu.addSubMenu("Song");
        mnuSong.setIcon(R.drawable.song);

        SubMenu mnuMovie = menu.addSubMenu("Movie");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case ID_COLOR_RED:
                objTxtView.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxtView.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxtView.setTextColor(Color.BLUE);
                return true;
            case ID_TEXT_NORMAL:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                item.setChecked(true);
                return true;
            case ID_TEXT_BOLD:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                item.setChecked(true);
                return true;
            case ID_TEXT_ITALIC:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                item.setChecked(true);
                return true;
            case ID_TEXTSIZE_10P:
                objTxtView.setTextSize(10);
                return true;
            case ID_TEXTSIZE_18P:
                objTxtView.setTextSize(18);
                return true;
            case ID_TEXTSIZE_24P:
                objTxtView.setTextSize(24);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        SubMenu mnuTextBackGroundColor = menu.addSubMenu("Text Background Color");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_RED, Menu.NONE, "Red");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_GREEN, Menu.NONE, "Green");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_BLUE, Menu.NONE, "Blue");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case ID_COLOR_RED:
                objTxtView.setBackgroundColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxtView.setBackgroundColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxtView.setBackgroundColor(Color.BLUE);
                return true;
        }

        return super.onContextItemSelected(item);
    }
}