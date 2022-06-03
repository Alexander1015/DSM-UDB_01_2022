package sv.edu.udb.guia6_ejercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder> {
    private List<Repositories> Repos;

    public  RepoAdapter(List<Repositories> Repos)
    {
        this.Repos = Repos;
    }
    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(Repos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return Repos != null ? Repos.size() : 0;
    }
}