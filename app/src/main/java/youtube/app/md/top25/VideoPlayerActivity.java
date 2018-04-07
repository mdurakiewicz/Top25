package youtube.app.md.top25;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * Created by Marcin on 05.04.2018.
 */

public class VideoPlayerActivity extends AppCompatActivity {

	private static String VIDEO_BASE_URL= "https://m.youtube.com/watch?v=";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        Bundle bundle = getIntent().getExtras();

        String videoId = "";
        if(bundle != null){
            videoId = bundle.getString(MainActivity.VIDEO_ID);
        }

        String videoURL = VIDEO_BASE_URL + videoId;

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(videoURL);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
