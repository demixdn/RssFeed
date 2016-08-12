package com.example.rssfeed.view.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rssfeed.R;
import com.example.rssfeed.data.model.RssItem;
import com.example.rssfeed.view.Navigator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    private List<RssItem> rssItems;
    private boolean isTwoPane;

    public FeedAdapter(List<RssItem> items, boolean twoPane){
        this.rssItems = items;
        this.isTwoPane = twoPane;
    }

    public RssItem getItem(int position){
        return rssItems.get(position);
    }

    @Override
    public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rss, parent, false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedHolder holder, int position) {
        RssItem item = getItem(position);
        holder.title.setText(item.getTitle());
        holder.date.setText(item.getPubTime());
        holder.author.setText(item.getAuthor());
        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl())
                .centerCrop()
                .crossFade()
                .into(holder.image);
        holder.itemView.setTag(item.getLink());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = (String)view.getTag();
                if (isTwoPane){
                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
                    Navigator.getInstance().goToDetailFragment(activity, link);
                }else {
                    Navigator.getInstance().goToDetailActivity(view.getContext(), link);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssItems == null ? 0 : rssItems.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivItemRssImage) ImageView image;
        @BindView(R.id.tvItemRssTitle) TextView title;
        @BindView(R.id.tvItemRssDate) TextView date;
        @BindView(R.id.tvItemRssAuthor) TextView author;

        public FeedHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }
    }
}
