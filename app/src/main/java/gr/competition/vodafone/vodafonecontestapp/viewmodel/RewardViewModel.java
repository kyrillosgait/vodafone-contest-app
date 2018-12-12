package gr.competition.vodafone.vodafonecontestapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import gr.competition.vodafone.vodafonecontestapp.db.AppDatabase;
import gr.competition.vodafone.vodafonecontestapp.db.RewardDao;
import gr.competition.vodafone.vodafonecontestapp.model.Reward;

public class RewardViewModel extends AndroidViewModel {

    private LiveData<List<Reward>> rewardsLiveData;
    private LiveData<List<Reward>> returnedRewards;
    private AppDatabase mAppDatabase;
    private RewardDao rewardDao;

    public RewardViewModel(Application application) {
        super(application);
        mAppDatabase = AppDatabase.Companion.getInstance(application);
        rewardDao = mAppDatabase.rewardDao();
        rewardsLiveData = rewardDao.loadAllRewards();
    }

    public LiveData<List<Reward>> getRewards() {
        if (returnedRewards == null) returnedRewards = new MutableLiveData<>();
        return returnedRewards;
    }

    public void addReward(Reward newReward) {
        insertReward(newReward);
    /*    List<Reward> rewards = rewardDao.loadAllRewards();
        rewards.add(newReward);
        rewardsLiveData.setValue(rewards);
    */
    }

    private void insertReward(Reward newReward) {
        new insertAsyncTask(rewardDao).execute(newReward);
    }

    private static class insertAsyncTask extends AsyncTask<Reward, Void, Void> {

        private RewardDao mAsyncTaskDao;

        insertAsyncTask(RewardDao rewardDao) {
            mAsyncTaskDao = rewardDao;
        }

        @Override
        protected Void doInBackground(final Reward... params) {
            mAsyncTaskDao.insertReward(params[0]);
            return null;
        }
    }

}
