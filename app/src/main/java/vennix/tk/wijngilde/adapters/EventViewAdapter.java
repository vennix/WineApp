package vennix.tk.wijngilde.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Event;

public class EventViewAdapter extends RecyclerView.Adapter<EventViewAdapter.RecyclerViewHolder> {
    private List<Event> eventList;

    public EventViewAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public EventViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewAdapter.RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(EventViewAdapter.RecyclerViewHolder recyclerViewHolder, int position) {
        Event event = eventList.get(position);
        recyclerViewHolder.nameTextView.setText(event.getName());
        recyclerViewHolder.placesTextView.setText(event.getPlaces());
        recyclerViewHolder.itemView.setTag(event);
        //recyclerViewHolder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void addItems(List<Event> events) {
        this.eventList = events;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        //private TextView itemTextView;
        private TextView nameTextView;
        private TextView placesTextView;

        RecyclerViewHolder(View view) {
            super(view);
            //itemTextView = (TextView) view.findViewById(R.id.itemTextView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            placesTextView = (TextView) view.findViewById(R.id.placesTextView);
        }
    }
}
