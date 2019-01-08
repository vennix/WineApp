package vennix.tk.wijngilde.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Kind;

public class KindViewAdapter extends RecyclerView.Adapter<KindViewAdapter.RecyclerViewHolder> {
    private List<Kind> kindList;
    private View.OnClickListener onClickListener;

    public KindViewAdapter(List<Kind> kindList, View.OnClickListener onClickListener) {
        this.kindList = kindList;
        this.onClickListener = onClickListener;
    }

    @Override
    public KindViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new KindViewAdapter.RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kind_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(KindViewAdapter.RecyclerViewHolder recyclerViewHolder, int position) {
        Kind kind = kindList.get(position);
        recyclerViewHolder.nameTextView.setText(kind.getName());
        recyclerViewHolder.itemView.setTag(kind);
        recyclerViewHolder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return kindList.size();
    }

    public void addItems(List<Kind> kinds) {
        this.kindList = kinds;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;

        RecyclerViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
        }
    }
}
