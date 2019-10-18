package com.example.hw13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int image[] = {
                R.drawable.image01,
                R.drawable.image02,
                R.drawable.image03,
                R.drawable.image04,
                R.drawable.image05,
                R.drawable.image06,
                R.drawable.image07,
                R.drawable.image08,
                R.drawable.image09,
                R.drawable.image10};
        final ImageView imageview = findViewById(R.id.imageView2);
        final EditText editText = findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText.getText().toString().matches(""))
                {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    int imageID = Integer.parseInt(editText.getText().toString());
                    if (imageID > 9 || imageID < 0) {
                        Toast toast = Toast.makeText(MainActivity.this, "請輸入0~9!!", Toast.LENGTH_LONG);
                        toast.show();

                        imageID = Integer.parseInt(editText.getText().toString());
                    }
                    else {
                        imageview.setImageResource(image[imageID]);
                    }
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    editText.setText("");
                }
            }
        });


    }
}
