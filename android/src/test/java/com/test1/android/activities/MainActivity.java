package com.test1.android.activities;

import com.test1.android.control.BaseControl;
import com.test1.android.control.TextBox;
import org.openqa.selenium.By;

public class MainActivity {
    public BaseControl addTaskButton = new BaseControl(By.id("com.ejemplo:id/fab_add"));
    public TextBox taskInput = new TextBox(By.id("com.ejemplo:id/input_title"));
    public BaseControl saveButton = new BaseControl(By.id("com.ejemplo:id/btn_save"));
}

