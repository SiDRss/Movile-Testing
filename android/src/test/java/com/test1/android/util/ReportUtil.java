package com.test1.android.util;

import com.test1.android.sesion.Sesion;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class ReportUtil {

    // Adjunta una captura de pantalla directamente al reporte de Allure de forma programática (sin depender de AspectJ)
    public static void captureScreenshot(String name) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) Sesion.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshotBytes), "png");
        } catch (Exception e) {
            System.err.println("No se pudo capturar la pantalla: " + e.getMessage());
        }
    }

    // Adjunta un mensaje de texto informativo al reporte
    public static void logText(String title, String message) {
        Allure.addAttachment(title, "text/plain", message != null ? message : "");
    }
}
