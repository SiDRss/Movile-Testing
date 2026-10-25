package com.test1.android.tests;

import com.test1.android.activities.AlarmTimePickerActivity;
import com.test1.android.activities.ClockMainActivity;
import com.test1.android.sesion.Sesion;
import com.test1.android.util.AllureTestWatcher;
import com.test1.android.util.ReportUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Automatización Móvil Android")
@Feature("Módulo de Alarma y Reloj")
@ExtendWith(AllureTestWatcher.class)
public class CreateAlarmTest {
    private ClockMainActivity clockMainActivity = new ClockMainActivity();
    private AlarmTimePickerActivity timePickerActivity = new AlarmTimePickerActivity();

    @Test
    @Story("Crear una nueva alarma para las 9:30 PM")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifica que un usuario pueda abrir la aplicación de Reloj, configurar una alarma a las 9:30 y validarla en la lista.")
    public void verifyCreateAlarm() {
        // 1. Esperar a que la pantalla principal del reloj cargue
        clockMainActivity.waitForClockToLoad();

        // 2. Navegar a la sección de Alarmas
        clockMainActivity.alarmTab.click();
        ReportUtil.captureScreenshot("1. Pantalla Inicial de Alarmas");

        // 3. Hacer clic en el botón '+' para agregar alarma
        clockMainActivity.addAlarmButton.click();

        // 4. Esperar a que el selector visual del reloj aparezca
        WebDriverWait wait = new WebDriverWait(Sesion.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/material_clock_face")));
        ReportUtil.captureScreenshot("2. Selector de Hora Desplegado");

        // 5. Seleccionar la hora (9) y minutos (30)
        timePickerActivity.selectHour("9");
        timePickerActivity.selectMinute("30");
        ReportUtil.captureScreenshot("3. Hora y Minutos Seleccionados");

        // 6. Confirmar la selección de hora
        timePickerActivity.okButton.click();

        // 7. Esperar a que la confirmación / alarma aparezca en la lista
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/digital_clock")));
        ReportUtil.captureScreenshot("4. Alarma Guardada en la Lista");

        // 8. Validación final (Aserción)
        Assertions.assertTrue(
                clockMainActivity.isAlarmCreated("9:30"),
                "ERROR: La alarma programada no se encuentra visible en la lista."
        );
    }

    @AfterEach
    public void tearDown() {
        Sesion.getInstance().closeSession();
    }
}
