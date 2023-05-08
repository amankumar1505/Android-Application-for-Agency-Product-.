package com.example.dayal;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyHolder> {
    Context context;
    ArrayList <ModelClass>arrayList;
    LayoutInflater layoutInflater;

    public CustomerAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
holder.customerName.setText(arrayList.get(position).getCustomerName());
holder.billNumber.setText(arrayList.get(position).getBillNumber());
holder.date.setText(arrayList.get(position).getDate());

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      TextView   customerName , billNumber, date ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.text);
            billNumber = itemView.findViewById(R.id.text2);
            date = itemView .findViewById(R.id.text3);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context,BillDetailsActivity.class);
            context.startActivity(intent);

        }
    }
}
