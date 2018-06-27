package com.battleships;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class I18N {
    private static final ObjectProperty<Locale> locale;

    static {
        locale = new SimpleObjectProperty<>(Locale.getDefault());
        locale.addListener(((observable, oldValue, newValue) -> Locale.setDefault(newValue)));
    }

    public static List<Locale> getSupportedLocales() {
        return new ArrayList<>(Arrays.asList(
                Locale.ENGLISH,
                new Locale("pl")));
    }

    public static Locale getDefaultLocale() {
        Locale sysDefault = Locale.getDefault();
        return getSupportedLocales().contains(sysDefault) ? sysDefault : Locale.ENGLISH;
    }
}
