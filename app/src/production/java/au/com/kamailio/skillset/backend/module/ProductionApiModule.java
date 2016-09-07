package au.com.kamailio.skillset.backend.module;


import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.base.GitHubService;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

@Module(includes = ApiModule.class)
public class ProductionApiModule {
    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(ApiModule.EXPRESS_API_URL);
    }

    @Provides
    @Singleton
    GitHubService provideGitHubService(RestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class);
    }
}
