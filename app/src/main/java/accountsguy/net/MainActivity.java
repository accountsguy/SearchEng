package accountsguy.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.googlesearch);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://google.co.in/");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    public void searchresult(View view) {
        TextView tv = (TextView) findViewById(R.id.searchbox);
        String query = tv.getText().toString();
        query = query.replace("\\s", "+");
        myWebView.loadUrl("https://www.google.co.in/search?q="+query);


//      This code will open search result in other supporting apps.
//      Intent googlesearchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google" +
//                ".co.in/search?q="+query));
//        startActivity(googlesearchIntent);
    }
}
