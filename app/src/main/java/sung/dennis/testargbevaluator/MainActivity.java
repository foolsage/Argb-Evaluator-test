package sung.dennis.testargbevaluator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sung.dennis.testargbevaluator.adapter.MyAdapter;
import sung.dennis.testargbevaluator.fragment.MyFragment;
import sung.dennis.testargbevaluator.listener.MyPageChangeLisener;
import sung.dennis.testargbevaluator.listener.MyPageTransformer;
import sung.dennis.testargbevaluator.view.MyLinearLayout;

public class MainActivity extends AppCompatActivity {
    private MyLinearLayout bgLayout;
    private ViewPager viewPager;
    private List<Fragment> pages = new ArrayList<>();
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black_trans80));
        setContentView(R.layout.activity_main);

        iniPages();

        bgLayout = findViewById(R.id.bgLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), pages));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new MyPageChangeLisener(bgLayout));
        viewPager.setPageTransformer(true, new MyPageTransformer());

        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void iniPages(){
        for(int i=0;i<12;i++){
            pages.add(MyFragment.newInstance(i+1));
        }
    }
}
