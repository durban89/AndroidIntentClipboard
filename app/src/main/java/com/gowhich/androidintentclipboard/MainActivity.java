package com.gowhich.androidintentclipboard;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private MyData myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) this.findViewById(R.id.button);
        button2 = (Button) this.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String name = "miao";
                clipboardManager.setText(name);

                Intent intent = new Intent(MainActivity.this, ShowTextActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                myData = new MyData("miao", 29);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                String base64String = "";
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(myData);
                    base64String = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                    clipboardManager.setText(base64String);

                    Intent intent = new Intent(MainActivity.this, ShowStringActivity.class);
                    startActivity(intent);
                } catch (Exception e) {

                }
            }
        });
    }
}
