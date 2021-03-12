package com.example.leaguemealone;

import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    List<String> summonersList = new ArrayList<String>();

    Button btnAdd;
    Button btnContinue;
    RecyclerView rvList;
    EditText inText;

    SummonersAdapter summonersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnContinue = findViewById(R.id.btnContinue);
        rvList = findViewById(R.id.rvList);
        inText = findViewById(R.id.inText);

//        loadItems();

        SummonersAdapter.OnClickListener onClickListener = new SummonersAdapter.OnClickListener() {
            @Override
            public void onItemClicked(int position) { // removes summoner
                String name = summonersList.get(position);
                Log.d(TAG, "Input at position " + position);
                summonersList.remove(position);
                summonersAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), name + "remove from query", Toast.LENGTH_SHORT).show();
//                saveItems();
            }
        };

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = inText.getText().toString();
                summonersList.add(newName);
                summonersAdapter.notifyItemInserted(summonersList.size()-1);
                inText.setText("");
                Toast.makeText(getApplicationContext(), newName + " added.", Toast.LENGTH_SHORT).show();
//              saveItems();
            }
        });

        summonersAdapter = new SummonersAdapter(summonersList, onClickListener);
        rvList.setAdapter(summonersAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));

    }


    private File getDataFile() {
        return new File(getFilesDir(), "data.txt");
    }

//    // function will load items by reading lines
//    private void loadItems() {
//        try {
//            summonersList = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
//        } catch (IOException e) {
//            Log.e("MainActivity.java", "error reading items", e);
//            summonersList = new ArrayList<>();
//        }
//    }
//
//    // saves by writing into file
//    private void saveItems() {
//        try {
//            FileUtils.writeLines(getDataFile(), summonersList);
//        } catch (IOException e) {
//            Log.e("MainActivity.java", "error writing items", e);
//        }
//    }


}