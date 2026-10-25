package com.test1.android.tests;

import com.test1.android.activities.MainActivity;
import com.test1.android.sesion.Sesion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AddTaskTest {
    private MainActivity mainActivity = new MainActivity();

    @Test
    public void verifyCreateTask() {
        mainActivity.addTaskButton.click();
        mainActivity.taskInput.setText("Mi primera tarea");
        mainActivity.saveButton.click();
    }

    @AfterEach
    public void tearDown() {
        Sesion.getInstance().closeSession();
    }
}

