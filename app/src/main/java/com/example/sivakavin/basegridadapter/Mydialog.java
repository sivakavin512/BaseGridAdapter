package com.example.sivakavin.basegridadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sivakavin on 7/28/2016.
 */
public class Mydialog extends Activity {
    ImageView im_dialog;
    TextView tx_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_frame);
        Intent intent=getIntent();

        if(intent!=null){
           int img=intent.getIntExtra("icon_im",R.drawable.nine);
           String nam=intent.getStringExtra("icon_tx");
            im_dialog= (ImageView) findViewById(R.id.dialog_icon);
            tx_dialog= (TextView) findViewById(R.id.dialog_name);
            im_dialog.setImageResource(img);
            tx_dialog.setText("Name is "+nam);
            Toast.makeText(this,"Intent data",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No Intent Intent data",Toast.LENGTH_LONG).show();
        }
        Window window=this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

    }

    public void closeClick(View view) {
        finish();
    }
}
