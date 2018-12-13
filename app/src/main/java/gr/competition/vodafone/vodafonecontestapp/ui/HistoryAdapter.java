package gr.competition.vodafone.vodafonecontestapp.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
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

    private Resources res;

    public HistoryAdapter(Resources resources) {
        super(DIFF_CALLBACK);
        res = resources;
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reward, parent, false);

        RewardsViewHolder mUnitsVH = new RewardsViewHolder(view);
        return mUnitsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull final RewardsViewHolder holder, int position) {

        final Reward reward = getItem(position);
        if (reward != null) {
            holder.bind(reward, position);

        }

    }

    public class RewardsViewHolder extends RecyclerView.ViewHolder {

        Reward mReward;
        @BindView(R.id.iv_history_icon)
        ImageView mIcon;
        @BindView(R.id.tv_history_date_valid)
        TextView mDate;
        @BindView(R.id.tv_history_reward_code)
        TextView mRewardCode;
        @BindView(R.id.tv_history_reward_title)
        TextView mTitle;
        @BindView(R.id.mcv_history_item)
        MaterialCardView mItem;

        public RewardsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        public void bind(Reward reward, int position) {
            mReward = reward;
//todo(when we have icons): setIcon(mReward.getGift().getCategory());
            mDate.setText(mReward.getRedeemUntil().toString());
            mRewardCode.setText(mReward.getRedeemCode());
            mTitle.setText(mReward.getGift().getName());
            setBackgroundColor(position);
        }

        private void setBackgroundColor(int position) {
            if (position % 2 == 1) mItem.setBackgroundColor(res.getColor(R.color.colorSwitchBg));
        }

    }
}
