package au.com.kamailio.skillset.backend.base;

/**
 * Created by FRincon on 6/09/16.
 */
public interface IWebServiceApi {
    boolean validateUser(String firstName, String lastName);
    String getCompleteName();
}
