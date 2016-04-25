package ua.edu.soippo.utils;

import ua.edu.soippo.utils.DCInputReader;

public class Utils {
    private static String prevSessionLocale = "";
    private static java.util.Hashtable<String, String> typesTable = new java.util.Hashtable<String, String>();

    public static String getTypeLocalized(String type, String locale) {
        if (!locale.equals(prevSessionLocale)) {
            typesTable.clear();
            java.util.List vList = DCInputReader.getInputsReader(locale).getPairs("common_types");

            for (int i = 0; i < vList.size(); i += 2)
                typesTable.put((String) vList.get(i + 1), (String) vList.get(i));

            prevSessionLocale = locale;
        }

        String result = typesTable.get(type);
        return result == null ? type : result;
    }
}
