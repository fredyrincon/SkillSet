package au.com.kamailio.skillset.backend.base;


import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import au.com.kamailio.skillset.model.Repository;
import retrofit.http.Path;
import rx.Observable;

public class MockGitHubService implements GitHubService {
    @Inject
    public MockGitHubService() {
    }

    @Override
    public Observable<List<Repository>> listRepos(@Path("org") String user) {
        return Observable.just(Arrays.asList(
                createMockRepository("Mock repository 1"),
                createMockRepository("Mock repository 2"),
                createMockRepository("Mock repository 3")
        ));
    }

    private Repository createMockRepository(String name) {
        Repository mockRepo = new Repository();
        mockRepo.name = name;
        return mockRepo;
    }
}
