package au.com.kamailio.skillset.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import au.com.kamailio.skillset.R;
import au.com.kamailio.skillset.backend.WebServiceApi;
import au.com.kamailio.skillset.backend.base.IWebServiceApi;
import au.com.kamailio.skillset.base.MyApplication;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.homeTextView) TextView homeTextView;
    @BindString(R.string.text_welcome) String homeText;

    @Inject
    IWebServiceApi webServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this); //Bundle butter knife
        ((MyApplication) getApplication()).getDummyComponent().inject(this); //Inject the data
        initView();
        testDependecyInjection();
    }

    public void initView() {
        homeTextView.setText(homeText);
    }

    public void testDependecyInjection() {
        boolean injected =  webServiceApi == null ? false : true;
        homeTextView.setText("Dependency injection worked: " + String.valueOf(injected) + " value " + webServiceApi.getCompleteName());
    }
}
