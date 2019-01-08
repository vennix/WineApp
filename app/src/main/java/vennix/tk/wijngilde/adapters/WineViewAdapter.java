package vennix.tk.wijngilde.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        recyclerViewHolder.yearTextView.setText(wine.getYear());
        recyclerViewHolder.producerTextView.setText(wine.getHouse());
        recyclerViewHolder.itemView.setTag(wine);
    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    public void addItems(List<Wine> wines) {
        this.wineList = wines;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTextView;
        private TextView yearTextView;
        private TextView producerTextView;

        RecyclerViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            nameTextView = view.findViewById(R.id.nameTextView);
            yearTextView = view.findViewById(R.id.yearTextView);
            producerTextView = view.findViewById(R.id.producerTextView);
        }

        @Override
        public void onClick(View v) {

            Log.e("result", "index");
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(Wine wine);
    }

}
