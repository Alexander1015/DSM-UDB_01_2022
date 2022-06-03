package sv.edu.udb.guia6_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sv.edu.udb.guia6_ejercicio1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ActivityMainBinding binding;
    RepoAdapter repoAdapter;
    List<Repositories> repos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerView();
        binding.searchRepos.setOnQueryTextListener(this);
    }

    private void initRecyclerView() {
        repoAdapter = new RepoAdapter(repos);
        binding.listRepos.setLayoutManager(new LinearLayoutManager(this));
        binding.listRepos.setAdapter(repoAdapter);
    }

    private ApiService getApiService() {
        //Aqui tenemos la api que da github
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        return service;
    }

    private void searchByName(String user) {
        final Call<List<Repositories>> batch = getApiService().getReposByUser(user);
        batch.enqueue(new Callback<List<Repositories>>() {
            @Override
            public void onResponse(@Nullable Call<List<Repositories>> call, @Nullable Response<List<Repositories>>
                    response) {
                if (response != null && response.body() !=null)
                {
                    repos.clear();
                    repos.addAll(response.body());
                    repoAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(@Nullable Call<List<Repositories>> call, @Nullable Throwable t) {
                if(t!=null)
                {
                    showError(t);
                }
            }
        });
    }
    private void showError(Throwable t) {
        Toast.makeText(this, "Ha ocurrido un error"+t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(!query.isEmpty()){
            searchByName(query);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}