package au.com.kamailio.skillset.backend.module;

import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.DummyServiceApi;
import au.com.kamailio.skillset.backend.WebServiceApi;
import au.com.kamailio.skillset.backend.base.IWebServiceApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by FRincon on 6/09/16.
 */
@Module
public class DummyServiceModule {

    @Provides
    @Singleton
    public IWebServiceApi getDummyService(){
        return new DummyServiceApi();
    }
}
