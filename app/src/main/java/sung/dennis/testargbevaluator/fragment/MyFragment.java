package sung.dennis.testargbevaluator.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sung.dennis.testargbevaluator.R;

public class MyFragment extends Fragment {
    int page;

    public static MyFragment newInstance(int p) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("page", p);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page, container, false);
        page = getArguments().getInt("page", 0);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("Page " + page);
        return view;
    }
}
