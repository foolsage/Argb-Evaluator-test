package sung.dennis.testargbevaluator;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sung.dennis.testargbevaluator.adapter.MyAdapter;
import sung.dennis.testargbevaluator.fragment.MyFragment;
import sung.dennis.testargbevaluator.listener.MyPageChangeLisener;
import sung.dennis.testargbevaluator.view.MyLinearLayout;

public class Main2Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private LinearLayout bg;
    private ViewPager viewPager;
    private List<Fragment> pages = new ArrayList<>();
    private TextView textView2;
    private int[] colors = new int[]{Color.GREEN, Color.BLUE, Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black_trans80));
        setContentView(R.layout.activity_main2);

        iniPages();

        bg = findViewById(R.id.bg);
        bg.setBackgroundColor(colors[0]);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), pages));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void iniPages(){
        for(int i=0;i<12;i++){
            pages.add(MyFragment.newInstance(i+1));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ArgbEvaluator evaluator = new ArgbEvaluator();
        int evaluate = (Integer) evaluator.evaluate(positionOffset, colors[position%colors.length], colors[(position+1)%colors.length]);
        bg.setBackgroundColor(evaluate);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
