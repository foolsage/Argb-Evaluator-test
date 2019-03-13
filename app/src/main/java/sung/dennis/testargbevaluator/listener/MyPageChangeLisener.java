package sung.dennis.testargbevaluator.listener;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.v4.view.ViewPager;

import sung.dennis.testargbevaluator.view.MyLinearLayout;

public class MyPageChangeLisener implements ViewPager.OnPageChangeListener {
    private MyLinearLayout llLayout;
    private int[] colors = new int[]{Color.GREEN, Color.BLUE, Color.RED};

    public MyPageChangeLisener(MyLinearLayout llLayout){
        this.llLayout = llLayout;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        ArgbEvaluator evaluator = new ArgbEvaluator();
//        ArgbEvaluator evaluator2 = new ArgbEvaluator();
//        int evaluate = (Integer) evaluator.evaluate(positionOffset, 0XFF8080FF,0XFFFF8080);
//        int evaluate2 = (Integer) evaluator2.evaluate(positionOffset, 0XFFFF8080, 0XFF8080FF);
//        if (position % 2 == 0) {
////            llLayout.setGradient(0XFF8080FF,0XFFFF8080);
//            llLayout.setGradient(evaluate, evaluate2);
//        }else {
////            llLayout.setGradient(0XFFFF8080,0XFF8080FF);
//            llLayout.setGradient(evaluate2, evaluate);
//        }
        int index1 = (position%colors.length),
                index2 = ((position+1)%colors.length),
                index3 = ((position+2)%colors.length);
        ArgbEvaluator evaluator = new ArgbEvaluator();
        ArgbEvaluator evaluator2 = new ArgbEvaluator();
        int evaluate = (Integer) evaluator.evaluate(positionOffset, colors[index1], colors[index2]);
        int evaluate2 = (Integer) evaluator2.evaluate(positionOffset, colors[index2], colors[index3]);
        llLayout.setGradient(evaluate2, evaluate);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
