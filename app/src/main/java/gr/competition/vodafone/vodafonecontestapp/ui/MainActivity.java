package gr.competition.vodafone.vodafonecontestapp.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
    @BindView(R.id.btn_small_recharge)
    Button btnSmallRecharge;
    @BindView(R.id.btn_medium_recharge)
    Button btnMediumRecharge;
    @BindView(R.id.btn_large_recharge)
    Button btnLargeRecharge;
    @BindView(R.id.cordlayout_main)
    CoordinatorLayout coordinatorLayout;
    private SharedPreferences prefs;
    public static final String RETRIES_KEY = "com.example.app.retries";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppDatabase db = AppDatabase.Companion.getInstance(this);

        btnPlay.setOnClickListener(v -> {

            int retriesAmount = getTries();

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

        btnSmallRecharge.setOnClickListener(v -> {
            int newRetriesAmount = getTries();
            newRetriesAmount++;
            prefs.edit().putInt(RETRIES_KEY, newRetriesAmount).apply();
            success(newRetriesAmount);
        });
        btnMediumRecharge.setOnClickListener(v -> {
            int newRetriesAmount = getTries();
            newRetriesAmount+=3;
            prefs.edit().putInt(RETRIES_KEY, newRetriesAmount).apply();
            success(newRetriesAmount);
        });
        btnLargeRecharge.setOnClickListener(v -> {
            int newRetriesAmount = getTries();
            newRetriesAmount+=7;
            prefs.edit().putInt(RETRIES_KEY, newRetriesAmount).apply();
            success(newRetriesAmount);
        });

    }

    private void success(int newRetriesAmount) {

        rechargeLayout.setVisibility(View.GONE);
        Snackbar.make(coordinatorLayout,
                String.format(getString(R.string.recharge_text),newRetriesAmount),
                Snackbar.LENGTH_LONG).show();

    }

    private int getTries() {

        prefs = this.getSharedPreferences(
                getPackageName(), Context.MODE_PRIVATE);

        // use a default value when retries is empty
        Log.d("retries", String.valueOf(prefs.getInt(RETRIES_KEY, 0)));
        return prefs.getInt(RETRIES_KEY, 0);

    }
}
