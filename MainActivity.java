package com.example.dheo.myunittesting.Main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dheo.myunittesting.Model.MainModel;
import com.example.dheo.myunittesting.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    EditText edtWidth, edtHeight, edtLength;
    TextView tvResult;

    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        presenter = new MainPresenter(this);

        onAttachView();

       btnCalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String length = edtLength.getText().toString().trim();
                String width = edtWidth.getText().toString().trim();
                String height = edtHeight.getText().toString().trim();
                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(length)) {
                    isEmptyFields = true;
                    edtLength.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(width)) {
                    isEmptyFields = true;
                    edtWidth.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(height)) {
                    isEmptyFields = true;
                    edtHeight.setError("Field ini tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    double l = Double.parseDouble(length);
                    double w = Double.parseDouble(width);
                    double h = Double.parseDouble(height);
                    presenter.mcalculateVolume(l, w, h);
                }
            }
        });
    }


    @Override
    public void onshowVolume(MainModel model) {
        tvResult.setText(model.getVolume());
    }

    @Override
    public void onError() {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDettachView() {
        presenter.onDettach();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDettachView();
    }

}
