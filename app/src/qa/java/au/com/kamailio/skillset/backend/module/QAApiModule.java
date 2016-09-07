package au.com.kamailio.skillset.backend.module;


import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.base.GitHubService;
import au.com.kamailio.skillset.backend.base.MockGitHubService;
import au.com.kamailio.skillset.backend.module.prefs.BooleanPreference;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

@Module(includes = ApiModule.class)
public class QAApiModule {
    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(ApiModule.PRODUCTION_API_URL);
    }

    @Provides
    @Singleton
    GitHubService provideGitHubService(RestAdapter restAdapter, MockRestAdapter mockRestAdapter, MockGitHubService mockService,
                                       @UseMockBackend BooleanPreference useMockMode) {
        if(useMockMode.get()) {
            return mockRestAdapter.create(GitHubService.class, mockService);
        } else {
            return restAdapter.create(GitHubService.class);
        }
    }

    @Provides
    @Singleton
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter) {
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        return mockRestAdapter;
    }
}
