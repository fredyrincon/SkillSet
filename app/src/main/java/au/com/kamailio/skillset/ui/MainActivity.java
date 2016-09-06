package au.com.kamailio.skillset.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import au.com.kamailio.skillset.R;
import au.com.kamailio.skillset.backend.WebServiceApi;
import au.com.kamailio.skillset.backend.base.IWebServiceApi;
import au.com.kamailio.skillset.base.MyApplication;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Resources URL
//http://jakewharton.github.io/butterknife/
//https://github.com/square/retrofit
//http://square.github.io/okhttp/
//http://www.vogella.com/tutorials/Dagger/article.html
//http://frogermcs.github.io/inject-everything-viewholder-and-dagger-2-example/
public class MainActivity extends AppCompatActivity {

    //UI binding
    @BindView(R.id.welcomeTextView) TextView welcomeTextView;
    @BindView(R.id.validationTextView) TextView validationTextView;

    @BindView(R.id.nextButton1) TextView nextButton1;
    @BindView(R.id.nextButton2) TextView nextButton2;
    @BindView(R.id.nextButton3) TextView nextButton3;
    @BindView(R.id.nextButton4) TextView nextButton4;

    //Resource binding
    @BindString(R.string.text_welcome) String welcomeText;

    //Dependency injection
    @Inject
    IWebServiceApi webServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //Bundle butter knife
        ((MyApplication) getApplication()).getComponent().inject(this); //Inject the data
        initView();
        testDependecyInjection();
    }

    public void initView() {
        welcomeTextView.setText(welcomeText);
    }

    public void testDependecyInjection() {
        boolean injected =  webServiceApi == null ? false : true;
        welcomeTextView.setText("Dependency injection worked: " + String.valueOf(injected) + " value " + webServiceApi.getCompleteName());
    }

    @OnClick({R.id.nextButton2, R.id.nextButton3 })
    public void onClickCast(Button button) {
        Toast.makeText(this, button.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @OnClick( R.id.nextButton1 )
    public void nextScreen(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @OnClick( R.id.nextButton4 )
    public void changeTextValidation(View view) {
        validationTextView.setText("Still in the MainActivity");
    }
}
