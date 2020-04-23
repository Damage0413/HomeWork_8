package com.damage0413.homework_8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    private String fielname;
    MediaController mediaController;
    EditText editText;
    Button openButton;
    Button qiutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edittext);
        openButton=(Button)findViewById(R.id.starttoplay);
        openButton.setOnClickListener(new startlistener());
        qiutButton=(Button)findViewById(R.id.quit);
        qiutButton.setOnClickListener(new qiutlistener());
        mediaController=new MediaController(this);
    }
    class startlistener implements View.OnClickListener {

        @Override
        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            fielname=editText.getText().toString();
            System.out.println(fielname);
            File video=new File(fielname);
            //若文件被找到
            if(video.exists()){
                videoView.setVideoPath(video.getAbsolutePath());//文件绝对路径
                videoView.setMediaController(mediaController);//设置videoView与mediaControler的关联
                mediaController.setMediaPlayer(videoView);
                videoView.requestFocus();
            }
            else{
                Toast.makeText(MainActivity.this,"很抱歉，您输入的文件不存在，请重新输入", Toast.LENGTH_LONG).show();
            }

        }
    }
    class qiutlistener implements View.OnClickListener {

        @Override
        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            finish();
        }
    }

}
