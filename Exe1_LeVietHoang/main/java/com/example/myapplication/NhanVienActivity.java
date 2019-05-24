package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class NhanVienActivity extends AppCompatActivity {
    Button btnNV;
    EditText maNV, tenNV;
    RadioButton rbtNam, rbtNu;
    ArrayList<NhanVien> data = new ArrayList<>();
    RecyclerView recyclerView;
    NhanVienAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEven();
        setAdapter();
    }

    public void setControl() {
        maNV = (EditText) findViewById(R.id.editMaNV);
        tenNV = (EditText) findViewById(R.id.editTenNV);
        btnNV = (Button) findViewById(R.id.btnNhapNV);
        rbtNam = (RadioButton) findViewById(R.id.rbtNam);
        rbtNu = (RadioButton) findViewById(R.id.rbtNu);

    }

    public void setEven() {
        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                String manv = maNV.getText().toString();
                String tennv = tenNV.getText().toString();
                String gt = null;

                if((manv.isEmpty()||tennv.isEmpty()) == false){
                    nv.setMaNV(maNV.getText().toString());
                    maNV.requestFocus();
                    maNV.setText(null);

                    nv.setTenNV(tenNV.getText().toString());
                    tenNV.requestFocus();
                    tenNV.setText(null);


                }else {
                    Toast.makeText(NhanVienActivity.this, "Nhập đầy đủ ", Toast.LENGTH_SHORT).show();
                }
                if (nv.setGt(rbtNam.isChecked())) {

                    nv.setImg(R.drawable.nam);
                } else {
                    nv.setImg(R.drawable.nu);
                }

                    data.add(nv);
                    adapter.notifyDataSetChanged();

            }

        });


    }

    void setAdapter() {
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NhanVienAdapter(this, data, R.layout.activity_nhan_vien);

        recyclerView.setAdapter(adapter);
    }

}
