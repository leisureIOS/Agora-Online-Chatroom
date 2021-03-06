package io.agora.agorachat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import io.agora.agorachat.R;
import io.agora.agorachat.utils.BitmapUtils;

public class MusicSelectorRecyclerAdapter extends RecyclerView.Adapter<MusicSelectorRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;

    private int[] ImgPaths = {R.mipmap.bg_0, R.mipmap.bg_1, R.mipmap.bg_2,
            R.mipmap.bg_3, R.mipmap.bg_4, R.mipmap.bg_5, R.mipmap.bg_6};

    private OnItemClickListener mOnItemClickListener;

    public MusicSelectorRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MusicSelectorRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.selector_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.img.setImageBitmap(BitmapUtils.readBitMap(mContext, ImgPaths[new Random().nextInt(6)]));
        holder.name.setText("音乐 " + position);

        if (mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView img;
        public TextView name;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.img_selector_item);
            name = view.findViewById(R.id.txt_selector_item_name);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}
