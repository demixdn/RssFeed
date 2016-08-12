package com.example.rssfeed.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.rssdata.model.dao.RssItemDAO;
import com.example.rssfeed.R;
import com.example.rssfeed.data.DataManager;
import com.example.rssfeed.data.model.ModelMapper;
import com.example.rssfeed.view.Navigator;
import com.example.rssfeed.view.adapter.FeedAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;

/**
 * An activity representing a list of {@link com.example.rssfeed.data.model.RssItem}. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private Subscription subscription;

    @BindView(R.id.item_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ButterKnife.bind(this);
        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        assert recyclerView != null;
        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }
        subscription = DataManager.getInstance().getRssFeed()
                .subscribe(new Subscriber<List<RssItemDAO>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<RssItemDAO> rssItemDAOs) {
                        initAdapterData(rssItemDAOs);
                    }
                });
    }

    private void initAdapterData(List<RssItemDAO> rssItemDAOs) {
        FeedAdapter adapter = new FeedAdapter(ModelMapper.transformFrom(rssItemDAOs), mTwoPane);
        recyclerView.setAdapter(adapter);
        if(mTwoPane && adapter.getItemCount()>0){
            Navigator.getInstance().goToDetailFragment(ItemListActivity.this, adapter.getItem(0).getLink());
        }
    }

    @Override
    public void onDestroy(){
        if(subscription!=null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        super.onDestroy();
    }

}
