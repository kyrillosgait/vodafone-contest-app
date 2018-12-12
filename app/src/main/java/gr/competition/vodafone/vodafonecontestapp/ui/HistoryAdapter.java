package gr.competition.vodafone.vodafonecontestapp.ui;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Reward;

public class HistoryAdapter extends ListAdapter<Reward, HistoryAdapter.RewardsViewHolder> {

    private static final DiffUtil.ItemCallback<Reward> DIFF_CALLBACK = new DiffUtil.ItemCallback<Reward>() {
        @Override
        public boolean areItemsTheSame(@NonNull Reward oldUnit, @NonNull Reward newUnit) {
            return (oldUnit.getId() == newUnit.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Reward oldUnit, @NonNull Reward newUnit) {
            return oldUnit == newUnit;
        }

    };

    public HistoryAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rewards, parent, false);

        RewardsViewHolder mUnitsVH = new RewardsViewHolder(view);
        return mUnitsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull final RewardsViewHolder holder, int position) {

        final Reward reward = getItem(position);
        if (reward != null) {
            holder.bind(reward);

        }

    }

    public class RewardsViewHolder extends RecyclerView.ViewHolder {

        Reward mReward;

        public RewardsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        public void bind(Reward reward) {
            mReward = reward;

        }

    }
}
