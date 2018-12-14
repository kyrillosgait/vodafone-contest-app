package gr.competition.vodafone.vodafonecontestapp.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.db.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_play)
    Button btnPlay;
    @BindView(R.id.btn_history)
    Button btnHistory;
    @BindView(R.id.btn_about)
    Button btnAbout;
    @BindView(R.id.btn_rewards)
    Button btnRewards;
    @BindView(R.id.ll_recharge_layout)
    LinearLayout rechargeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppDatabase db = AppDatabase.Companion.getInstance(this);
        int retriesAmount = getTries();
        Log.d("retries", String.valueOf(retriesAmount));


        btnPlay.setOnClickListener(v -> {

            if(retriesAmount==0){
                rechargeLayout.setVisibility(View.VISIBLE);
            }else {
                rechargeLayout.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        });

        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);
        });

        btnRewards.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RewardsActivity.class);
            startActivity(intent);
        });

    }

    private int getTries() {

        SharedPreferences prefs = this.getSharedPreferences(
                getPackageName(), Context.MODE_PRIVATE);


        String retriesKey = "com.example.app.retries";

        // use a default value when retries is empty
        return prefs.getInt(retriesKey, 0);

    }
}
