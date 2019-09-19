package com.ttahm3d.simplecameraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Path;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] mDepartments = new  String[] {"Computer Science","Electronics"};
    String[] mPaths = new String[] {"ComputerScience","Electronics"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mDepartments , mPaths   );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                    intent.putExtra("DepartmentName", mDepartments[i]);
                    intent.putExtra("StoragePath", mPaths[i]);
                    startActivity(intent);
                }
                if(i == 1){
                    Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                    intent.putExtra("DepartmentName", mDepartments[i]);
                    intent.putExtra("StoragePath", mPaths[i]);
                    startActivity(intent);
                }
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String[] rDepartment;
        String[] rPaths;

        MyAdapter(Context c, String[] Departments, String[] Paths){
            super(c, R.layout.row,R.id.Text1, Departments);
            this.context = c;
            this.rDepartment =Departments;
            this.rPaths = Paths;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            //ImageView images = row.findViewById(R.id.ListImage);
            TextView text = row.findViewById(R.id.Text1);

            text.setText(rDepartment[position]);
            return row;
        }
    }
}
