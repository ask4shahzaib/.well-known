package com.bilal.cv.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bilal.cv.base.R;
import com.bilal.cv.model.DemoItem;
import com.squareup.picasso.Picasso;

import java.util.List;
public class ProfessionAdapter extends RecyclerView.Adapter {
    private List<DemoItem> demoItems;
    private Context        context;
    public ProfessionAdapter(List<DemoItem> demoItems, Context context) {
        this.demoItems = demoItems;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
          View row = inflater.inflate(R.layout.profession, parent, false);
        return new DemoItemHolder2(row);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProfessionAdapter.DemoItemHolder2 demoItemHolder = (ProfessionAdapter.DemoItemHolder2) holder;
        Picasso.get().load(R.drawable.openlink).into(demoItemHolder.githubLink);

        demoItemHolder.githubLink.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.githubCopyLink)));
            context.startActivity(intent);
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }
    @Override
    public int getItemCount() {
        return demoItems.size();
    }
    public class DemoItemHolder2 extends RecyclerView.ViewHolder {
        ImageView githubLink;
        DemoItemHolder2(View itemView) {
            super(itemView);
            githubLink = itemView.findViewById(R.id.githubCopyLink);
        }
    }

}
