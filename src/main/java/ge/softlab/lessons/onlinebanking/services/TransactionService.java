package ge.softlab.lessons.onlinebanking.services;

import ge.softlab.lessons.onlinebanking.models.TransactionAddModel;

public interface TransactionService {
    void addTransaction(TransactionAddModel data);
}
