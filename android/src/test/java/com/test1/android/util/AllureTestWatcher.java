package com.test1.android.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class AllureTestWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // En caso de fallo inesperado, toma automáticamente una captura del estado del móvil
        ReportUtil.captureScreenshot("Evidencia de Fallo - " + context.getDisplayName());
        ReportUtil.logText("Detalle del Error", cause != null ? cause.getMessage() : "Error desconocido");
    }
}

