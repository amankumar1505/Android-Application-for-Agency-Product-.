package com.example.dayal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView ;

    SearchView searchView;
    String URL = "https://itc.dayalagency.com/api/invoice/list";
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass>searchList;
    String [] customerList = new String[]{"Aman kumar","Mohan kumar","Shyam kumar","Amit kumar","Rishi kumar","Aman kumar","Mohan kumar","Shyam kumar","Amit kumar","Rishi kumar","Aman kumar","Mohan kumar","Shyam kumar","Amit kumar","Rishi kumar"};
    String [] billNumber = new  String[] {"Bill 1","Bill 2","Bill 3","Bill 4","Bill 5","Bill 1","Bill 2","Bill 3","Bill 4","Bill 5","Bill 1","Bill 2","Bill 3","Bill 4","Bill 5"};

    String [] date = new  String[] {"01-2022 - Bihar","01-2023 - Bihar","02-2023 - Bihar","03-2024 - Bihar","04-2024 - Bihar","01-2022 - Bihar","01-2023 - Bihar","02-2023 - Bihar","03-2024 - Bihar","04-2024 - Bihar","01-2022 - Bihar","01-2023 - Bihar","02-2023 - Bihar","03-2024 - Bihar","04-2024 - Bihar"};



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerView);

        /*for(int i =0; i<customerList.length; i++ ){
            ModelClass modelClass = new ModelClass();
            modelClass.setCustomerName(customerList[i]);
            modelClass.setBillNumber(billNumber[i]);
            modelClass.setDate(date[i]);

            arrayList.add(modelClass);
        }*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        CustomerAdapter customerAdapter = new CustomerAdapter(SearchActivity.this,arrayList);
        recyclerView.setAdapter(customerAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();
                if(query.length()>0){
                    for(int i=0;i<arrayList.size();i++){
                        if(arrayList.get(i).getCustomerName().toUpperCase().contains(query.toUpperCase())||arrayList.get(i).getBillNumber().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setCustomerName(arrayList.get(i).getCustomerName());
                            modelClass.setBillNumber(arrayList.get(i).getBillNumber());
                            modelClass.setDate(arrayList.get(i).getDate());

                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    CustomerAdapter customerAdapter = new CustomerAdapter(SearchActivity.this,searchList);
                    recyclerView.setAdapter(customerAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    CustomerAdapter customerAdapter = new CustomerAdapter(SearchActivity.this,arrayList);
                    recyclerView.setAdapter(customerAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if(newText.length()>0){
                    for(int i=0;i<arrayList.size();i++){
                        if(arrayList.get(i).getCustomerName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getBillNumber().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setCustomerName(arrayList.get(i).getCustomerName());
                            modelClass.setBillNumber(arrayList.get(i).getBillNumber());
                            modelClass.setDate(arrayList.get(i).getDate());

                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    CustomerAdapter customerAdapter = new CustomerAdapter(SearchActivity.this,searchList);
                    recyclerView.setAdapter(customerAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    CustomerAdapter customerAdapter = new CustomerAdapter(SearchActivity.this,arrayList);
                    recyclerView.setAdapter(customerAdapter);
                }
                return false;
            }
        });



    }


    }
