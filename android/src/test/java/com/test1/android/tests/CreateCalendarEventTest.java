package com.test1.android.tests;

import com.test1.android.activities.CalendarMainActivity;
import com.test1.android.sesion.Sesion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCalendarEventTest {
    private CalendarMainActivity calendarMainActivity = new CalendarMainActivity();

    @Test
    public void verifyCreateCalendarEvent() {
        String eventTitle = "Reunion de Proyecto";

        // 1. Abrir menú de creación (+)
        calendarMainActivity.addEventButton.click();

        // 2. Elegir opción 'Evento'
        calendarMainActivity.eventOption.click();

        // 3. Escribir el título
        calendarMainActivity.titleInput.setText(eventTitle);

        // 4. Guardar evento
        calendarMainActivity.saveButton.click();

        // 5. Aserción: Verificar presencia del evento
        Assertions.assertTrue(
                calendarMainActivity.isEventCreated(eventTitle),
                "ERROR: El evento en el calendario no fue creado correctamente.");
    }

    @AfterEach
    public void tearDown() {
        Sesion.getInstance().closeSession();
    }

}
