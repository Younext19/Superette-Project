package com.damso.superette.database;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damso.superette.R;

// HADO YWEROLEK CHA YDIROU F RECYCLERVIEW
public class SetViewHolder extends RecyclerView.ViewHolder {
    public TextView Marque;
    public SetViewHolder(@NonNull View itemView) {
        super(itemView);
        Marque = itemView.findViewById(R.id.marquee);
    }
}
