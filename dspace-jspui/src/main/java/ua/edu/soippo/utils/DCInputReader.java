package ua.edu.soippo.utils;

import org.dspace.app.util.DCInputsReader;
import org.dspace.app.util.DCInputsReaderException;
import org.dspace.core.I18nUtil;

import java.util.Locale;

/**
 * Created by Igor on 12.11.2015.
 */
public class DCInputReader extends DCInputsReader {
    private static String prevSessionLocale = "";
    private static DCInputReader inputsReader = null;

    public DCInputReader() throws DCInputsReaderException {
    }

    public DCInputReader(String fileName) throws DCInputsReaderException {
        super(fileName);
    }

    public static DCInputReader getInputsReader(String sessionLocale) {
        try {
            if (inputsReader == null)
                inputsReader = new DCInputReader();

            if (!sessionLocale.equals(prevSessionLocale)) {
                String fileName = I18nUtil.getInputFormsFileName(new Locale(sessionLocale));
//                StringBuilder fileName = new StringBuilder(ConfigurationManager.getProperty("dspace.dir")
//                        + File.separator + "config" + File.separator + getFormDefFile());

//                if (!sessionLocale.equals("en"))
//                    fileName.insert(fileName.length() - 4, "_" + sessionLocale);

                prevSessionLocale = sessionLocale;
            }
        } catch (DCInputsReaderException e) {
            e.printStackTrace();
        }

        return inputsReader;
    }
}
