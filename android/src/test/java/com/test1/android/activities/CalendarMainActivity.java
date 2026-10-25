package com.test1.android.activities;

import com.test1.android.control.BaseControl;
import com.test1.android.control.Button;
import com.test1.android.control.TextBox;
import org.openqa.selenium.By;

public class CalendarMainActivity {
    // Botón para crear nuevo evento / recordatorio (+)
    public Button addEventButton = new Button(By.xpath(
            "//*[contains(@content-desc, 'Create') or contains(@content-desc, 'Crear') or contains(@content-desc, 'Add')] " +
            "| //*[@id='com.google.android.calendar:id/floating_action_button']"
    ));

    // Opción evento dentro del menú flotante
    public Button eventOption = new Button(By.xpath(
            "//*[@text='Event' or @text='Evento' or contains(@content-desc, 'Event') or contains(@content-desc, 'Evento')]"
    ));

    // Campo de título del evento
    public TextBox titleInput = new TextBox(By.xpath(
            "//*[@text='Add title' or @text='Agregar un título'] " +
            "| //*[@id='com.google.android.calendar:id/title_edit_text']"
    ));

    // Botón Guardar
    public Button saveButton = new Button(By.xpath(
            "//*[@text='Save' or @text='Guardar' or contains(@content-desc, 'Save') or contains(@content-desc, 'Guardar')] " +
            "| //*[@id='com.google.android.calendar:id/save_action_button']"
    ));

    // Verificación de que el evento exista en el calendario
    public boolean isEventCreated(String title) {
        BaseControl eventItem = new BaseControl(By.xpath(
                "//*[contains(@text, '" + title + "')]"
        ));
        return eventItem.isControlDisplayed();
    }
}

