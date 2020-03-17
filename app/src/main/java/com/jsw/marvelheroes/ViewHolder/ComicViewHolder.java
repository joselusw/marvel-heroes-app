package com.jsw.marvelheroes.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jsw.marvelheroes.Model.Comic;
import com.jsw.marvelheroes.Presenter.ComicPresenter;
import com.jsw.marvelheroes.R;


public class ComicViewHolder extends RecyclerView.ViewHolder {

    /* -- VARS --*/
    private ImageView iv_image;
    private TextView tv_name;
    private TextView tv_description;
    private ComicPresenter presenter;

    public ComicViewHolder(@NonNull View itemView, ComicPresenter presenter) {
        super(itemView);
        this.iv_image = itemView.findViewById(R.id.iv_image);
        this.tv_name = itemView.findViewById(R.id.tv_name);
        this.tv_description = itemView.findViewById(R.id.tv_description);
        this.presenter = presenter;
    }


    public void render(Comic comic) {
        //Set listeners
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onComicClicked(comic);
            }
        });

        //Fulfill info
        Glide.with(itemView.getContext()).load(comic.getThumbnail().getURL()).into(iv_image);
        tv_name.setText(comic.geTitle());
        tv_description.setText(comic.getDescription());
    }
}
