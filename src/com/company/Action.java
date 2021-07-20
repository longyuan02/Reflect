package com.company;

import com.company.interfaces.ClickAction;

public class Action implements ClickAction {
    @Override
    public void onClickAction() {
        System.out.println("Action->Click");
    }

    public void mainMethod(ClickAction myCallback) {
        System.out.println("ClickAction mainMethod...");
        myCallback.onClickAction();
    }
}
