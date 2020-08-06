package com.sethphat.musicstation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // config
    private boolean isPlay = false;
    private boolean isOpen = false;
    private MediaPlayer mediaPlayer = null;
    private int nowMusic = -1;
    private int nowSecond = 0;
    private int totalSecond = 0;
    private Timer timer = null;

    // control
    Animation rotation;
    ImageButton btnPlayPause;
    ImageButton btnPrev;
    ImageButton btnNext;
    ImageView imgDisc;
    ImageView imgHaha;
    LinearLayout llIns;
    RelativeLayout rlPanel;
    TextView txtDuration;
    TextView txtName;
    TextView txtTimer;
    ProgressBar prgDuration;
    ImageButton btnLike;
    ReactionView reactionView;

    // list view
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration = 5;

    // data
    String[] musics = new String[] { "Despacito", "Shape Of You", "Việt Nam Và Những Chuyến Đi","Let Me Love You","That Girl" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        // get controls
        btnPlayPause = (ImageButton) findViewById(R.id.btnPlayPause);
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        imgDisc = (ImageView) findViewById(R.id.imgDisc);
        imgHaha = (ImageView) findViewById(R.id.imgHaha);
        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        llIns = (LinearLayout) findViewById(R.id.llIns);
        rlPanel = (RelativeLayout) findViewById(R.id.rlPanel);
        txtDuration = (TextView) findViewById(R.id.txtDuration);
        txtName = (TextView) findViewById(R.id.txtName);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
        prgDuration = (ProgressBar) findViewById(R.id.prgDuration);

        // create animation
        rotation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        rotation.setFillAfter(true);
        Glide.with(this).load(R.drawable.haha_anm).into(imgHaha);

        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        imgHaha.startAnimation(animation);

        // drawer...
        addDrawerItems();
        setupDrawer();
        initView();

        // action
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlay = !isPlay;

                if (isPlay) {
                    btnPlayPause.setBackgroundResource(R.drawable.pause_button);
                    //imgDisc.startAnimation(rotation);
                    Glide.with(getBaseContext()).load(R.drawable.rotate).into(imgDisc);
                    mediaPlayer.start();
                    updateTask(totalSecond);
                }
                else {
                    btnPlayPause.setBackgroundResource(R.drawable.play_button);
                    //imgDisc.clearAnimation();
                    imgDisc.setImageResource(R.drawable.rotate);
                    mediaPlayer.pause();
                }
            }
        });

        // prev music
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nowMusic <= 0)
                {
                    Toast.makeText(MainActivity.this, "Đã là bài đầu tiên!", Toast.LENGTH_SHORT).show();
                    return;
                }

                nowMusic--;
                play_new_music(nowMusic);
            }
        });

        // next music
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nowMusic + 1 == musics.length)
                {
                    Toast.makeText(MainActivity.this, "Đã là bài cuối cùng!", Toast.LENGTH_SHORT).show();
                    return;
                }

                nowMusic++;
                play_new_music(nowMusic);
            }
        });

        imgHaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(imgHaha, R.drawable.haha_anm);
            }
        });


        // settings
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Chọn bài hát");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                mDrawerList.bringToFront();
                mDrawerLayout.requestLayout();
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(getString(R.string.app_name));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawerItems() {
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musics);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (isOpen == false) {
                    llIns.setVisibility(View.GONE);
                    rlPanel.setVisibility(View.VISIBLE);
                    isOpen = true;
                }
                nowMusic = position;

                // play music now
                play_new_music(nowMusic);
        }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.menu){
            startActivity(new Intent(MainActivity.this,DSVideo.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public int getMusic(String item)
    {
        switch (item)
        {
            case "Despacito": return R.raw.despacito;
            case "Shape Of You": return R.raw.shapeofyou;
            case "Việt Nam Và Những Chuyến Đi":return R.raw.vietnamnhungchuyendi;
            case "Let Me Love You" : return  R.raw.letmeloveyou;
            default: return R.raw.thatgirl;
        }
    }

    private void initView() {
        btnLike = (ImageButton) findViewById(R.id.btnLike);
        reactionView = (ReactionView) findViewById(R.id.view_reaction);
        reactionView.setVisibility(View.INVISIBLE);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reactionView.show();
            }
        });
    }

    private void updateTask(int totalTime)
    {
        prgDuration.setMax(totalTime);
        prgDuration.setProgress(nowSecond);

        // check old timer
        if (timer != null)
            timer.cancel();

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isPlay == false) {
                    timer.cancel();
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nowSecond++;
                        prgDuration.setProgress(nowSecond);

                        // calculate for the now minutes
                        int now_minutes = nowSecond / 60;
                        int now_seconds = nowSecond % 60;
                        txtTimer.setText(now_minutes + ":" + now_seconds);
                    }
                });
            }
        };

        timer.schedule(task, 0, 1000);
    }

    private void play_new_music(int position)
    {
        // play music turn...
        if (isPlay)
        {
            mediaPlayer.pause();
        }

        // check old timer
        if (timer != null)
            timer.cancel();

        // khoi tao music
        mediaPlayer = MediaPlayer.create(MainActivity.this, getMusic(musics[position]));
        txtName.setText(musics[position]);

        // get duration
        int seconds = totalSecond = mediaPlayer.getDuration() / 1000;
        int minute = seconds / 60;
        int sc = seconds % 60;
        txtDuration.setText(minute + ":" + sc);
        prgDuration.setProgress(0);
        nowSecond = 0;

        // start music
        mediaPlayer.start();
        isPlay = true;
        btnPlayPause.setBackgroundResource(R.drawable.pause_button);
        //imgDisc.startAnimation(rotation);
        Glide.with(this).load(R.drawable.rotate).into(imgDisc);
        updateTask(seconds);
    }

    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);
        Glide.with(this).load(imageResId).into(expandedImageView);
        expandedImageView.bringToFront();

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.rlPanel)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(expandedImageView,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }
}
