package au.com.kamailio.skillset.base;

import android.app.Application;
import au.com.kamailio.skillset.backend.base.DaggerComponent;

/**
 * Created by FRincon on 6/09/16.
 */
public class DaggerApplication extends Application {
    private static DaggerInjectGraph graph;
    private static DaggerApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildComponentAndInject();
    }

    public static DaggerInjectGraph component() {
        return graph;
    }

    public static void buildComponentAndInject() {
        graph = DaggerComponent.Initializer.init(instance);
    }
}
