package gr.competition.vodafone.vodafonecontestapp.ui;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Gift;
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
        rewards.add(new Reward(1, new Gift(1, "fun", 1, "1+1 Skydive", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(2, "fun", 1, "1+1 EXIT NOW", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(3, "fun", 1, "1+1 Adventure Rooms", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(4, "food", 2, "1+1 Simply Burgers", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(5, "food", 2, "1+1 Mikel Coffee", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(6, "food", 2, "1+1 Dominos Pizza", ""), "adfasdaljg", new Date()));
        rewards.add(new Reward(1, new Gift(7, "shopping", 3, "15% έκπτωση Adidas", ""), "adfasdaljg", new Date()));

        mAdapter.submitList(rewards);
    }

}
