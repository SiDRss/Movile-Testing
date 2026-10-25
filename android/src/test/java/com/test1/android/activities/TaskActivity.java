package com.test1.android.activities;

import com.test1.android.control.Button;
import com.test1.android.control.TextBox;
import org.openqa.selenium.By;

public class TaskActivity {
    public TextBox titleInput = new TextBox(By.id("com.ejemplo:id/input_title"));
    public TextBox descriptionInput = new TextBox(By.id("com.ejemplo:id/input_description"));
    public Button saveButton = new Button(By.id("com.ejemplo:id/btn_save"));
    public Button cancelButton = new Button(By.id("com.ejemplo:id/btn_cancel"));
}
