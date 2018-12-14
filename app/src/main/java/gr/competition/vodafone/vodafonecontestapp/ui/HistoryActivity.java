package gr.competition.vodafone.vodafonecontestapp.ui;

import android.content.Intent;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.db.AppDatabase;
import gr.competition.vodafone.vodafonecontestapp.model.Gift;
import gr.competition.vodafone.vodafonecontestapp.model.Reward;
import gr.competition.vodafone.vodafonecontestapp.viewmodel.RewardViewModel;

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

        Intent intent = getIntent();
        RewardViewModel rewardViewModel = ViewModelProviders.of(this).get(RewardViewModel.class);

        if(intent!=null){
            if (intent.hasExtra("GIFT_MAIN")){
                String name = intent.getStringExtra("GIFT_MAIN");
                AppDatabase db = AppDatabase.Companion.getInstance(this);
                Gift gift = db.giftDao().getGiftByName(name);
                int id = getRandomId();
                String redeemdCode = createRandomString();
                Date newDate = getDateUntil();
                Reward reward = new Reward(id,gift,redeemdCode,newDate);
                rewardViewModel.addReward(reward);
            }
        }

        rewardViewModel.getRewards().observe(this, new Observer<List<Reward>>() {
            @Override
            public void onChanged(List<Reward> rewards) {
                mAdapter.submitList(rewards);
            }
        });

    }

    private Date getDateUntil() {
        Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.DATE, 7); //same with c.add(Calendar.DAY_OF_MONTH, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        return currentDatePlusOne;
    }

    private String createRandomString() {
        return UUID.randomUUID().toString();
    }

    private int getRandomId() {
        Random r = new Random();
        int low = 1;
        int high = 10000000;
        return r.nextInt(high-low) + low;
    }

    private void setUpAdapter(RecyclerView historyRecyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new HistoryAdapter(getResources());
        historyRecyclerView.setAdapter(mAdapter);

//        testPopulate();
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
