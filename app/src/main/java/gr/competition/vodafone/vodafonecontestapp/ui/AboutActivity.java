package gr.competition.vodafone.vodafonecontestapp.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import gr.competition.vodafone.vodafonecontestapp.R;

import static gr.competition.vodafone.vodafonecontestapp.R.id.btn_kyrillos;
import static gr.competition.vodafone.vodafonecontestapp.R.id.view_offset_helper;

public class AboutActivity extends AppCompatActivity {


//    ImageButton btnKyrillos = (ImageButton) findViewById(R.id.btn_kyrillos);
//    ImageButton btnPanos = (ImageButton) findViewById(R.id.btn_panos);
//    ImageButton btnNikos = (ImageButton) findViewById(R.id.btn_nikos);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        btnKyrillos.setOnClickListener(v ->
//        {
//            try {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("https://www.linkedin.com/in/grassis/"));
//                startActivity(myIntent);
//            } catch (ActivityNotFoundException e) {
//
//                e.printStackTrace();
//            }
//        });
//
//
//        btnPanos.setOnClickListener(v -> {
//
//            try {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("https://www.linkedin.com/in/grassis/"));
//                startActivity(myIntent);
//            } catch (ActivityNotFoundException e) {
//
//                e.printStackTrace();
//            }
//
//        });
//
//        btnNikos.setOnClickListener(v -> {
//
//            try {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("https://www.linkedin.com/in/nikos-markakis-854a17155/"));
//                startActivity(myIntent);
//            } catch (ActivityNotFoundException e) {
//
//                e.printStackTrace();
//            }
//
//        });

    }
}


