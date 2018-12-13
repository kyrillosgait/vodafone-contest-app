package gr.competition.vodafone.vodafonecontestapp.ui;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Reward;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.rv_history)
    RecyclerView historyRecyclerView;
    private HistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        setUpAdapter(historyRecyclerView);

        /*todo(when db created): RewardViewModel rewardViewModel = ViewModelProviders.of(this).get(RewardViewModel.class);
        rewardViewModel.getRewards().observe(this, new Observer<List<Reward>>() {
            @Override
            public void onChanged(List<Reward> rewards) {
                mAdapter.submitList(rewards);
            }
        });*/

    }

    private void setUpAdapter(RecyclerView historyRecyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new HistoryAdapter(getResources());
        historyRecyclerView.setAdapter(mAdapter);

        testPopulate();
    }

    private void testPopulate() {
        ArrayList<Reward> rewards = new ArrayList<>();
//        rewards.add(new Reward(1, new Gift(1, "", "Gift 1", 1, " "), "df34Ghks", new Date()));
//        rewards.add(new Reward(2, new Gift(2, "", "1+1 Goody's", 1, " "), "df34Ghks", new Date()));
//        rewards.add(new Reward(3, new Gift(3, "", "Trip to Barcelona", 1, " "), "df34Ghks", new Date()));
//        rewards.add(new Reward(4, new Gift(4, "", "20% Discount for Zara", 1, " "), "df34Ghks", new Date()));
//        rewards.add(new Reward(5, new Gift(5, "", "Gift 5", 1, " "), "df34Ghks", new Date()));
//        rewards.add(new Reward(6, new Gift(6, "", "Gift 6", 1, " "), "df34Ghks", new Date()));

        mAdapter.submitList(rewards);
    }

}
