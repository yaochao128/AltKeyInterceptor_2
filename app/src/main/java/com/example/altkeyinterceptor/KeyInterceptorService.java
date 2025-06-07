package com.example.altkeyinterceptor;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

public class KeyInterceptorService extends AccessibilityService {
    private boolean altPressed = false;
    private boolean ctrlPressed = false;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        boolean isDown = event.getAction() == KeyEvent.ACTION_DOWN;

        if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT) {
            altPressed = isDown;
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_CTRL_LEFT || keyCode == KeyEvent.KEYCODE_CTRL_RIGHT) {
            ctrlPressed = isDown;
        }
        if (altPressed && keyCode == KeyEvent.KEYCODE_TAB && isDown) return true;
        if (ctrlPressed && keyCode == KeyEvent.KEYCODE_SPACE && isDown) return true;
        if (ctrlPressed && keyCode == KeyEvent.KEYCODE_ENTER && isDown) return true;

        return false;
    }
}