package com.example.rssfeed.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.rssfeed.R;
import com.example.rssfeed.view.activity.ItemDetailActivity;
import com.example.rssfeed.view.activity.ItemListActivity;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the link that this fragment
     * represents.
     */
    public static final String ARG_ITEM_LINK = "arg_item_link";

    private WebView webView;
    private ProgressBar progressBar;
    private String link;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_LINK)) {
            link = getArguments().getString(ARG_ITEM_LINK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        webView = (WebView) rootView.findViewById(R.id.wvDetail);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        showContent();
    }

    private void showContent(){
        if(webView!=null && link != null) {
            webView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onReceivedTitle(WebView view, String title) {
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
                }

                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    ItemDetailFragment.this.setValue(newProgress);
                    super.onProgressChanged(view, newProgress);
                }
            });

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);

                }
            });
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            webView.loadUrl(link);
            progressBar.setProgress(0);
        }
    }

    private void setValue(int newProgress) {
        if(progressBar!=null)
            progressBar.setProgress(newProgress);
    }


}
