package com.junction.natio.web.util;

import java.io.File;
import java.io.FileNotFoundException;

public interface IFileHelper {
    /**
     * This method is used to read the csv file regarding park's visitors data.
     *
     * @return file
     */
    File getVisitorsData() throws FileNotFoundException;
}