package au.com.kamailio.skillset.backend.component;

import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.module.WebServiceApiModule;
import au.com.kamailio.skillset.ui.MainActivity;
import dagger.Component;

/**
 * Created by FRincon on 6/09/16.
 */
@Singleton
@Component(modules = {WebServiceApiModule.class})

public interface DiComponent {
    // to update the fields in your activities
    void inject(MainActivity activity);
}
