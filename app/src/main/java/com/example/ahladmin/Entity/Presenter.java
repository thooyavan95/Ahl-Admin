package com.example.ahladmin.Entity;

import com.example.ahladmin.Interfaces.ModelInterface;
import com.example.ahladmin.Interfaces.ViewInterface;

public class Presenter implements ModelInterface {

private static final String TAG = "Presenter";
private ViewInterface viewInterface;
private Model model;

    public Presenter(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        model = new Model(Presenter.this);
    }

    public void addGoal()
    {

    }

    public void addCard()
    {

    }


}
