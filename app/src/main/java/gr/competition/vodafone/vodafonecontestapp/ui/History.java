package gr.competition.vodafone.vodafonecontestapp.ui;

import android.os.Bundle;
import android.app.Activity;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Reward;
import gr.competition.vodafone.vodafonecontestapp.viewmodel.RewardViewModel;

public class History extends AppCompatActivity {

    @BindView(R.id.rv_history)
    RecyclerView historyRecyclerView;
    private HistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        setUpAdapter(historyRecyclerView);

        RewardViewModel rewardViewModel = ViewModelProviders.of(this).get(RewardViewModel.class);
        rewardViewModel.getRewards().observe(this, new Observer<List<Reward>>() {
            @Override
            public void onChanged(List<Reward> rewards) {
                //TODO: add rewards from db.
            }
        });

    }

    private void setUpAdapter(RecyclerView historyRecyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new HistoryAdapter();
        historyRecyclerView.setAdapter(mAdapter);
    }

}
