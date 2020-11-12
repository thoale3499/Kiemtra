package com.example.customlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String mTitle[] = {"Lê Thị Kim Thoa","Diễm Hương","Phúc Trịnh","Xuân Dưỡng","Nguyễn Trí","Thoa Lê","Thoa Lê","Thoa Lê","Thoa Lê"};
    int img[] = {R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien,R.drawable.daidien};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.List);
        myAdapter adapter = new myAdapter(this, mTitle,  img);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_id:
                lv.removeViewAt(i.position);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    class myAdapter extends ArrayAdapter<String> {
        Context ct;
        String rTitle[];
        int rImg[];

        myAdapter(Context c, String title[], int images[]){
            super(c, R.layout.rowlist, R.id.tv1, title);
            this.ct = c;
            this.rTitle = title;
            this.rImg = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.rowlist,parent,false);
            ImageView imgs = row.findViewById(R.id.anh);
            TextView myTitle = row.findViewById(R.id.tv1);


            imgs.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
    }
}