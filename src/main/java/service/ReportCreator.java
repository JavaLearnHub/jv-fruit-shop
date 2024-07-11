package service;

import db.Storage;

public class ReportCreator {

    private static final String DATA_SEPARATOR = ",";
    private static final StringBuilder storeActivitiesReport = new StringBuilder();

    public static String createReport(Storage storage) {

        storeActivitiesReport.append("fruit,quantity")
                .append(System.lineSeparator());

        for (String product : storage.getProductsNames()) {
            storeActivitiesReport
                    .append(product)
                    .append(DATA_SEPARATOR)
                    .append((storage.getQuantity(product)).orElse(0))
                    .append(System.lineSeparator());
        }

        return storeActivitiesReport.toString();
    }
}
