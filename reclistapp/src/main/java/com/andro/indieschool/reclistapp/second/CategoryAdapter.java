package com.andro.indieschool.reclistapp.second;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.model.Category;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindCategory(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private CheckBox checkBoxSelected;

        ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_category_title);
            checkBoxSelected = itemView.findViewById(R.id.checkbox_category_selected);
        }

        void bindCategory(Category category) {
            textTitle.setText(category.title);
            checkBoxSelected.setChecked(category.selected);
        }
    }

}
