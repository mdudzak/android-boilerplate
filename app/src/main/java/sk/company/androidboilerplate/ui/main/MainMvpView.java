package sk.company.androidboilerplate.ui.main;

import java.util.List;

import sk.company.androidboilerplate.data.model.Ribot;
import sk.company.androidboilerplate.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
