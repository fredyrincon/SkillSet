package au.com.kamailio.skillset.backend;

import au.com.kamailio.skillset.backend.base.IWebServiceApi;

/**
 * Created by FRincon on 6/09/16.
 */
public class WebServiceApi implements IWebServiceApi {

    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getCompleteName() {
        return "WebService Implementation";
    }
}
