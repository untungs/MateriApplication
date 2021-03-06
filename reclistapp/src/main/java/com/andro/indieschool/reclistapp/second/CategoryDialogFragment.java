package com.andro.indieschool.reclistapp.second;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDialogFragment extends DialogFragment {

    private static final String KEY_CATEGORIES = "KEY_CATEGORIES";

    private List<Category> categories;

    public static CategoryDialogFragment newInstance(ArrayList<Category> categories) {
        CategoryDialogFragment fragment = new CategoryDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_CATEGORIES, categories);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = getArguments().getParcelableArrayList(KEY_CATEGORIES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new CategoryAdapter(categories));
    }

    @Override
    public void onResume() {
        if (getDialog().getWindow() == null) {
            return;
        }
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
