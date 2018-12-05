package cl.telematica.basicconnectionexample.main.presenter;

import cl.telematica.basicconnectionexample.main.MyAsyncTask;
import cl.telematica.basicconnectionexample.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void fetchData(final String url, final int timeOut) {
        MyAsyncTask task = new MyAsyncTask(url, timeOut, mainView);
        task.execute();
    }
}
