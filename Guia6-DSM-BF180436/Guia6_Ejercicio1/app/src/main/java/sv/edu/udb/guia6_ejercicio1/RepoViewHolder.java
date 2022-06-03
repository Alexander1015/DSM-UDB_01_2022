package sv.edu.udb.guia6_ejercicio1;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import sv.edu.udb.guia6_ejercicio1.databinding.ItemRepoBinding;

public class RepoViewHolder extends RecyclerView.ViewHolder{
    private ItemRepoBinding itemRepoBinding;

    public RepoViewHolder(View view) {
        super(view);
        itemRepoBinding = ItemRepoBinding.bind(view);
    }
    public void bind(String name) {
        itemRepoBinding.textView.setText(name);
    }
}