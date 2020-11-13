package com.example.dz6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bgButton;
    public ConstraintLayout layout;
    Context context;
    CharSequence[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgButton = (Button)findViewById(R.id.btSetColor);
        layout = (ConstraintLayout)findViewById(R.id.mainLayout);
        context = MainActivity.this;
        items = new CharSequence[]{getText(R.string.red), getText(R.string.yellow), getText(R.string.green)};
        bgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message_header);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                int hint = R.string.red;
                switch (item) {
                    case 0:
                        layout.setBackgroundResource(R.color.redColor);
                        hint = R.string.red;
                        break;
                    case 1:
                        layout.setBackgroundResource(R.color.yellowColor);
                        hint = R.string.yellow;
                        break;
                    case 2:
                        layout.setBackgroundResource(R.color.greenColor);
                        hint = R.string.green;
                }
                Toast.makeText(context, hint, Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
