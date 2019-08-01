package com.prabhat.firebasechat.mycard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context context;
    private List<Album> albumList;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
            Album album = albumList.get(i);
            holder.title.setText(album.getName());
            holder.count.setText(album.getNumOfSongs()+" songs");

        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu(holder.overflow);
            }
        });


    }

    public void showPopMenu(View view){
        PopupMenu popupMenu = new PopupMenu(context,view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_album,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListner());
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title,count;
        public ImageView thumbnail,overflow;
        public MyViewHolder(@NonNull View view) {
            super(view);
            title =(TextView) view.findViewById(R.id.title);
            count =(TextView) view.findViewById(R.id.count);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    public AlbumsAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    class MyMenuItemClickListner implements PopupMenu.OnMenuItemClickListener{

        public MyMenuItemClickListner(){

        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            int id = item.getItemId();

            switch (id){
                case R.id.action_add_favourite:
                    Toast.makeText(context,"Add to Favourite",Toast.LENGTH_LONG).show();
                    break;

                case R.id.action_play_next:
                    Toast.makeText(context,"Play Next",Toast.LENGTH_LONG).show();
            }
            return false;
        }
    }
}
