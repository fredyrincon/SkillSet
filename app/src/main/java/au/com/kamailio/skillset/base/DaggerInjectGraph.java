package au.com.kamailio.skillset.base;

import au.com.kamailio.skillset.ui.HomeActivity;
import au.com.kamailio.skillset.ui.MainActivity;

public interface DaggerInjectGraph {
    void inject(MainActivity mainActivity);

    void inject(HomeActivity homeActivity);
}
