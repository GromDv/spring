package ru.gb.demoAOP.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.demoAOP.DTO.MoneyActionsDTO;
import ru.gb.demoAOP.aspects.TimeLoggedExecution;
import ru.gb.demoAOP.domen.User;
import ru.gb.demoAOP.repository.ProductActionsRepository;
import ru.gb.demoAOP.repository.ProductRepository;
import ru.gb.demoAOP.repository.UserRepository;

@Service
@AllArgsConstructor
public class MoneyActionService {
    private final UserRepository userRepo;
    private final ProductRepository prodRepo;
    private final ProductActionsRepository prodActionsRepo;

    /**
     * Главный метод перевода денег
     *
     * @param transfer
     */
    @TimeLoggedExecution
    public void TransferMoney(MoneyActionsDTO transfer) {
        User sender = userRepo.findById(transfer.getFromAccountId()).orElse(null);
        User receiver = userRepo.findById(transfer.getToAccountId()).orElse(null);

        if (sender != null && receiver != null) {
            makeTransfer(sender, receiver, transfer);
        }
    }

    /**
     * Метод только переводит деньги со счета на счет (выделен для транзакции)
     *
     * @param sender
     * @param receiver
     * @param transfer
     */
    @Transactional
    void makeTransfer(User sender, User receiver, MoneyActionsDTO transfer) {
        sender.setPayAccount(sender.getPayAccount().subtract(transfer.getAmount()));
        receiver.setPayAccount(receiver.getPayAccount().add(transfer.getAmount()));
        userRepo.saveAndFlush(receiver);
        userRepo.saveAndFlush(sender);
    }
}
