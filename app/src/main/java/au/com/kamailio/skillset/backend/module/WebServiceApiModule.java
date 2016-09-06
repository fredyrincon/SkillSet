package au.com.kamailio.skillset.backend.module;

import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.WebServiceApi;
import au.com.kamailio.skillset.backend.base.IWebServiceApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by FRincon on 6/09/16.
 */
@Module
public class WebServiceApiModule {

    @Provides
    @Singleton
    public IWebServiceApi getWebServiceApi(){
        return new WebServiceApi();
    }
}
