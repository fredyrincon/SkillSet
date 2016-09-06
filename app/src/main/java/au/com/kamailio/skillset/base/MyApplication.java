package au.com.kamailio.skillset.base;

import android.app.Application;

import au.com.kamailio.skillset.backend.component.DiComponent;
import au.com.kamailio.skillset.backend.component.DaggerDiComponent;
import au.com.kamailio.skillset.backend.component.DiDummyComponent;
import au.com.kamailio.skillset.backend.component.DaggerDiDummyComponent;

/**
 * Created by FRincon on 6/09/16.
 */
public class MyApplication extends Application {
    DiComponent component;
    DiDummyComponent dummyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDiComponent.builder().build();
        dummyComponent = DaggerDiDummyComponent.builder().build();
    }


    public DiComponent getComponent() {
        return component;
    }

    public DiDummyComponent getDummyComponent() {
        return dummyComponent;
    }
}
