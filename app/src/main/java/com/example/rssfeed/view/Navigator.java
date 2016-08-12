package com.example.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rssfeed.R;
import com.example.rssfeed.view.activity.ItemDetailActivity;
import com.example.rssfeed.view.fragment.ItemDetailFragment;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
public class Navigator {
    private static Navigator instance = new Navigator();

    public static Navigator getInstance() {
        return instance;
    }

    private Navigator() {
    }

    public void goToDetailActivity(Context context, String link){
        Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra(ItemDetailFragment.ARG_ITEM_LINK, link);
        context.startActivity(intent);
    }

    public void goToDetailFragment(AppCompatActivity activity, String link){
        Bundle arguments = new Bundle();
        arguments.putString(ItemDetailFragment.ARG_ITEM_LINK, link);
        ItemDetailFragment fragment = new ItemDetailFragment();
        fragment.setArguments(arguments);
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit();
    }
}
