package com.priorityproperties.avantaricalendar;

import android.animation.ObjectAnimator;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.truizlop.fabreveallayout.FABRevealLayout;
import com.truizlop.fabreveallayout.OnRevealChangeListener;

public class MainActivity extends AppCompatActivity {
    private FABRevealLayout fabRevealLayout;
    private RecyclerView vR_recycler;
    private AdapterAlarm adapterAlarm;
    private TextView sunday,monday,tuesday,wednesday,thursday,friday,saturday;
    private Button vB_hours,vB_minutes,vB_seconds;
    private LinearLayout vL_week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        vR_recycler.setHasFixedSize(true);
        vR_recycler.setLayoutManager(new LinearLayoutManager(this));
        vR_recycler.setAdapter(adapterAlarm);
        configureFABReveal();
    }
    private void findViews() {
        adapterAlarm=new AdapterAlarm(Util.setList(),this);
        fabRevealLayout = (FABRevealLayout) findViewById(R.id.fab_reveal_layout);
        vR_recycler=findViewById(R.id.vR_recycler);
        vL_week=findViewById(R.id.vL_week);
        sunday=findViewById(R.id.vT_sunday);
        monday=findViewById(R.id.vT_monday);
        tuesday=findViewById(R.id.vT_tuesday);
        wednesday=findViewById(R.id.vT_wednesday);
        thursday=findViewById(R.id.vT_thursday);
        friday=findViewById(R.id.vT_friday);
        saturday=findViewById(R.id.vT_saturday);
        vB_hours=findViewById(R.id.vB_hours);
        vB_minutes=findViewById(R.id.vB_minutes);
        vB_seconds=findViewById(R.id.vB_seconds);

    }



    private void configureFABReveal() {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
                showMainViewItems();
            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
                showSecondaryViewItems();
                prepareBackTransition(fabRevealLayout);
            }
        });
    }

    private void showMainViewItems() {
        scale(vR_recycler,50);
    }

    private void showSecondaryViewItems() {

        scale(vB_hours, 100);
        scale(vB_minutes, 150);
        scale(vB_seconds, 200);
        scale(vL_week, 50);
    }

    private void prepareBackTransition(final FABRevealLayout fabRevealLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fabRevealLayout.revealMainView();
            }
        }, 5000);
    }

    private void scale(View view, long delay){
        view.setScaleX(0);
        view.setScaleY(0);
        view.animate()
                .scaleX(1)
                .scaleY(1)
                .setDuration(500)
                .setStartDelay(delay)
                .setInterpolator(new OvershootInterpolator())
                .start();
    }


}
