package org.example.alert.impl;

import com.google.inject.ImplementedBy;
import org.example.alert.api.Alert;

@ImplementedBy(MongoDBAlertRepository.class)
public interface AlertRepository
{
//    Alert getAlerts();
    void storeAlert(Alert alert);
    void storeThreshold(String threshold);
    double getThreshold();
}
