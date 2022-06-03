package sv.edu.udb.guia6_ejercicio1;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("{user}/repos")
    Call<List<Repositories>> getReposByUser(@Path("user") String user);
}
