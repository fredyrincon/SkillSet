package au.com.kamailio.skillset.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import au.com.kamailio.skillset.R;
import au.com.kamailio.skillset.backend.base.GitHubService;
import au.com.kamailio.skillset.backend.module.UseMockBackend;
import au.com.kamailio.skillset.backend.module.prefs.BooleanPreference;
import au.com.kamailio.skillset.base.DaggerApplication;
import au.com.kamailio.skillset.model.Repository;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

    @BindView(R.id.listdataView) ListView listDataView;

    //Resource binding
    @BindString(R.string.text_welcome) String welcomeText;

    //Dependency injection
    @Inject
    GitHubService gitHubService;

    @Inject
    @UseMockBackend
    BooleanPreference useMock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //Bundle butter knife
        DaggerApplication.component().inject(this);
        initView();
        testDependecyInjection();

    }

    public void initView() {
        welcomeTextView.setText(welcomeText);
    }

    public void testDependecyInjection() {
        boolean injected =  gitHubService == null ? false : true;
        welcomeTextView.setText("Dependency injection worked");
    }

    @OnClick({R.id.nextButton2, R.id.nextButton3 })
    public void onClickCast(Button button) {
        Toast.makeText(this, button.getText().toString() + " loading data...", Toast.LENGTH_SHORT).show();
        loadData();
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

    private void loadData() {

        useMock.set(true); // for QA

        gitHubService.listRepos("fredyrincon")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Repository>>() {
                    @Override
                    public void call(List<Repository> repositories) {
                        List<String> names = new ArrayList<>();
                        for(Repository repository : repositories) {
                            names.add(repository.name);
                        }
                        fillList(names);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("RepositoriesList", "Error receiving list of repos", throwable);
                    }
                });
    }

    public void fillList(List<String> names) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listDataView.setAdapter(adapter);
    }
}
