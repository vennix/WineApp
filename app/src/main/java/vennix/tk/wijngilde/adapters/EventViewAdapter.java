package vennix.tk.wijngilde.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Event;

public class EventViewAdapter extends RecyclerView.Adapter<EventViewAdapter.RecyclerViewHolder> {
    private List<Event> eventList;
    private OnItemClickListener listener;

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
        recyclerViewHolder.dateTextView.setText(new SimpleDateFormat("dd-MM-yyyy").format(event.getDate()));
        recyclerViewHolder.placesTextView.setText(Integer.toString(event.getPlaces()));
        recyclerViewHolder.itemView.setTag(event);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void addItems(List<Event> events) {
        this.eventList = events;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView dateTextView;
        private TextView placesTextView;

        RecyclerViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
            placesTextView = view.findViewById(R.id.placesTextView);

            // handle onClick in list
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClicked(eventList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(Event event);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
