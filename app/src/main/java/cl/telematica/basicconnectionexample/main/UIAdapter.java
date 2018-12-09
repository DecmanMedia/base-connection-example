package cl.telematica.basicconnectionexample.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.media.midi.MidiDeviceService;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.telematica.basicconnectionexample.R;
import cl.telematica.basicconnectionexample.models.Libro;



public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {

    private Context context;
    private List<Libro> mDataset;

    public UIAdapter(Context context, List<Libro> mDataset) {
        this.context = context;
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mGeneroView;
        public ImageView mPhotoView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textName);
            mGeneroView = (TextView) v.findViewById(R.id.textGenero);
            mPhotoView = (ImageView) v.findViewById(R.id.imagePhoto);
        }
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_libro, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro libro = mDataset.get(position);

        holder.mTextView.setText(libro.getNombre());
        holder.mGeneroView.setText(libro.getGenero());
        Glide
                .with(context)
                .load(libro.getPhoto())
                .into(holder.mPhotoView);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}