package org.example.alert.impl;

import com.google.inject.ImplementedBy;
import org.example.alert.api.Alert;
import org.example.user.api.User;

@ImplementedBy(MongoDbAlertRepository.class)
public interface AlertRepository
{
    Alert getAlert(String id);
    void storeAlert(Alert alert);
}
