package gr.competition.vodafone.vodafonecontestapp.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import gr.competition.vodafone.vodafonecontestapp.R;
import gr.competition.vodafone.vodafonecontestapp.model.Gift;

public class RewardsActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        lv = (ListView) findViewById(R.id.list);

        ArrayList<Gift> gifts = new ArrayList<Gift>();

        gifts.add(new Gift(1, "fun", 1, "1+1 Skydive", "https://www.vodafonecu.gr/cu-around/offer/skydive-athens"));
        gifts.add(new Gift(2, "fun", 1, "1+1 EXIT NOW", "https://www.vodafonecu.gr/cu-around/offer/exit-now"));
        gifts.add(new Gift(3, "fun", 1, "1+1 Adventure Rooms", "https://www.vodafonecu.gr/cu-around/offer/adventure-rooms"));
        gifts.add(new Gift(4, "food", 2, "1+1 Simply Burgers", "https://thankyou.vodafone.gr/offer/46"));
        gifts.add(new Gift(5, "food", 2, "1+1 Mikel Coffee", "https://thankyou.vodafone.gr/offer/152"));
        gifts.add(new Gift(6, "food", 2, "1+1 Dominos Pizza", "https://thankyou.vodafone.gr/offer/48"));
        gifts.add(new Gift(7, "shopping", 3, "15% έκπτωση Adidas", "https://www.vodafonecu.gr/cu-around/offer/adidas"));
        gifts.add(new Gift(8, "shopping", 3, "15% έκπτωση Funky Buddha", "https://www.vodafonecu.gr/cu-around/offer/funky-buddha"));
        gifts.add(new Gift(9, "shopping", 3, "15% έκπτωση Forever 21", "https://www.vodafonecu.gr/cu-around/offer/forever21"));
        gifts.add(new Gift(10, "data", 4, "500 MB", "https://www.vodafone.gr"));
        gifts.add(new Gift(11, "data", 4, "1 GB", "https://www.vodafone.gr"));
        gifts.add(new Gift(12, "data", 4, "2 GB", "https://www.vodafone.gr"));
        gifts.add(new Gift(13, "trip", 5, "1+1 Μπαλί", "https://www.vodafonecu.gr/cu-around/offer/travel-and-more-bali"));

        ArrayAdapter<Gift> arrayAdapter =
                new RewardsAdapter(this, gifts);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Gift entry = (Gift) parent.getItemAtPosition(position);

                String url = entry.getUrl();

                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
//                    Toast.makeText(this, "No application can handle this request."
//                            + " Please install a webbrowser",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        lv.setAdapter(arrayAdapter);
    }
}
