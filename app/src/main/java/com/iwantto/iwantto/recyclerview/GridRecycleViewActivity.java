package com.iwantto.iwantto.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.iwantto.iwantto.R;

public class GridRecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);
        mRvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecycleViewActivity.this,3));
        mRvGrid.setAdapter(new GridAdapter(GridRecycleViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public Void onClick(int pos) {
                Toast.makeText(GridRecycleViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
                return null;
            }
        }));
    }
}
