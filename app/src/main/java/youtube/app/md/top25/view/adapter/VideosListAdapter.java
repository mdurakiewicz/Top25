package youtube.app.md.top25.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import youtube.app.md.top25.R;
import youtube.app.md.top25.view.data.VideoViewData;

/**
 * Created by Marcin on 04.04.2018.
 */

public class VideosListAdapter extends BaseAdapter{

    private List<VideoViewData> videoViewDataList = new ArrayList<>();
    private LayoutInflater inflater=null;

    public VideosListAdapter(Context context) {
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return videoViewDataList.size();
    }

    @Override
    public Object getItem(int position) {
        if (position < 0 || position >= videoViewDataList.size()) {
            return null;
        } else {
            return videoViewDataList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.row_video, null);

        TextView txtChannelTitle = rowView.findViewById(R.id.channelTitle);
        TextView txtTitle = rowView.findViewById(R.id.title);
        ImageView imgView = rowView.findViewById(R.id.imgVideo);

        txtChannelTitle.setText(videoViewDataList.get(position).getChannelTitle());
        txtTitle.setText(videoViewDataList.get(position).getTitle());
        Picasso.get().load(videoViewDataList.get(position).getImgUrl()).into(imgView);

        return rowView;
    }

    public void setVideoViewDataList(List<VideoViewData> videoViewDataList){
        if (videoViewDataList == null) {
            return;
        }

        this.videoViewDataList.clear();
        this.videoViewDataList.addAll(videoViewDataList);
        notifyDataSetChanged();
    }

}
