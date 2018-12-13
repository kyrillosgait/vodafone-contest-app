package gr.competition.vodafone.vodafonecontestapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    @BindView(R.id.btn_rewards)
    Button btnRewards;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        db = AppDatabase.Companion.getInstance(this);

        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            startActivity(intent);
        });

        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        });

        btnRewards.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RewardsActivity.class);
            startActivity(intent);
        });
    }
}
