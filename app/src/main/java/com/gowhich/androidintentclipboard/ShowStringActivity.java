package com.gowhich.androidintentclipboard;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class ShowStringActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_string);

        textView = (TextView) this.findViewById(R.id.showstring);

        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String msg = clipboardManager.getText().toString();
        byte[] base64Byte = Base64.decode(msg, Base64.DEFAULT);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(base64Byte);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            MyData myData = (MyData) objectInputStream.readObject();
            textView.setText(myData.toString());
        } catch (Exception e) {

        }
    }
}
