package aea.bt.cryptography.pdf;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import aea.bt.cryptography.Control.Game_control_read;
import aea.bt.cryptography.Control.Game_control_write;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;

public class pdf1_lesson extends AppCompatActivity {
    HomeWatcher mHomeWatcher;
    String textScroll = "ສາມາດເລື່ອນລົງເພື່ອເບີ່ງໜ້າຕໍ່ໄປ";
    PDFView pdfView;
    Button play;
    Vibrator vibrator;
    public static int write_class_pdf_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1_lesson);
pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("aa.pdf").load();
    }
}