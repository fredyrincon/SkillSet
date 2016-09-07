package au.com.kamailio.skillset.backend.base;

import java.util.List;

import au.com.kamailio.skillset.model.Repository;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubService {
    @GET("/users/{user}/repos")
    @Headers("User-Agent: DaggerDemo")
    Observable<List<Repository>> listRepos(@Path("user") String user);
}
