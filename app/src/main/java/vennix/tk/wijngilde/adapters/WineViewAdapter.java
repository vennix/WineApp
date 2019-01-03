package vennix.tk.wijngilde.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Wine;

public class WineViewAdapter extends RecyclerView.Adapter<WineViewAdapter.RecyclerViewHolder> {

    private List<Wine> wineList;

    public WineViewAdapter(List<Wine> wineList) {
        this.wineList = wineList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wine_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int position) {
        Wine wine = wineList.get(position);
        recyclerViewHolder.nameTextView.setText(wine.getName());
        recyclerViewHolder.alcPercentTextView.setText(wine.getAlcoholPercentage().toString());
        //recyclerViewHolder.dateTextView.setText(borrowModel.getBorrowDate().toLocaleString().substring(0, 11));
        recyclerViewHolder.itemView.setTag(wine);
        //recyclerViewHolder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    public void addItems(List<Wine> wines) {
        this.wineList = wines;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        //private TextView itemTextView;
        private TextView nameTextView;
        private TextView alcPercentTextView;

        RecyclerViewHolder(View view) {
            super(view);
            //itemTextView = (TextView) view.findViewById(R.id.itemTextView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            alcPercentTextView = (TextView) view.findViewById(R.id.alcPercentTextView);
        }
    }
}
