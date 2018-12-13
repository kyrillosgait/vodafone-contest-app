package gr.competition.vodafone.vodafonecontestapp.ui;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Gift;

public class RewardsAdapter extends ArrayAdapter<Gift>
{
    public RewardsAdapter(Context context, ArrayList<Gift> list)
    {
        super(context,0,list);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        Gift gift = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_reward_2, parent, false);

        }

        TextView tvName = (TextView) convertView.findViewById(R.id.giftName);


        tvName.setText(gift.getName());
        return convertView;
    }



}
