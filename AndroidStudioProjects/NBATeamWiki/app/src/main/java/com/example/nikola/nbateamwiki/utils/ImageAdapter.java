package com.example.nikola.nbateamwiki.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.nikola.nbateamwiki.R;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public static String[] mThumbIds = {
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2F01ff5c3361d99ec7b33676ec762ada61--nba-golden-state-warriors.jpg?alt=media&token=ac787975-b1d3-4258-835c-c23597e7b64c",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2F631558868-golden-state-warriors-v-sacramento-kings.jpg.jpg?alt=media&token=2003e521-43c2-43ec-abb9-aa931bfd3b65",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2FBest-Golden-State-Warriors-Logo-Wallpaper.jpg?alt=media&token=1da8f959-5579-487a-b7fc-7561490fc9df",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2Fgolden-state-warriors.jpg?alt=media&token=14b4333e-6474-4997-bb45-e9ff4b188515",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2Fhttps_%252F%252Fhypebeast.com%252Fimage%252F2018%252F06%252Fgolden-state-warriors-2018-nba-championship-win-0.jpg?alt=media&token=afe81109-ec00-468f-92bc-3200bc65961b",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2FGolden-State-Warriors-Parade.jpg?alt=media&token=231de2a2-6c1d-49ac-88ff-536f4c6512b5",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2Fgolden-state-warriors-2017-nba-finals.jpg?alt=media&token=5aba2b78-6554-42c9-98fc-1e040183fd4c",
            "https://firebasestorage.googleapis.com/v0/b/nbateamwiki.appspot.com/o/gallery%2F25warriors-web-facebookJumbo.jpg?alt=media&token=6d61c21b-3926-49d9-aaeb-92c84465ae23",

    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public String getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(480, 480));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        String url = getItem(position);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loader)
                .fit()
                .centerCrop().into(imageView);
        return imageView;
    }
}
