package ge.softlab.lessons.onlinebanking.services;

import ge.softlab.lessons.onlinebanking.entities.TransactionDomain;
import ge.softlab.lessons.onlinebanking.models.TransactionAddModel;
import ge.softlab.lessons.onlinebanking.repositories.AccountRepository;
import ge.softlab.lessons.onlinebanking.repositories.TransactionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor // შექმნის კონსტრუქტორს
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    @Override
    public void addTransaction( TransactionAddModel data) {
        var transaction = new TransactionDomain();

      //      if(data.amount()==null || data.amount() < 0.1){
      //     throw new RuntimeException("wrong amount"); ამას ვალიდაცია აკეთებს და დაწერა არაა საჭირო

      //  }
            if (Objects.equals(data.creditAccountId(),data.debitAccountId())){
                throw new RuntimeException("არ შეიძლება ერთიდაიგივე ანგარიშებს შორის გადარიცხვა");
            }
        var credit = accountRepository.findById(data.creditAccountId()).orElseThrow();
        if (Objects.equals(credit.getBlocked(), Boolean.TRUE)){
            throw new RuntimeException("account_is_blocked");//ეს ამოწმებს დაბლოკილი ხო არაა კრედიტ ანგარიში
        }

        var debit = accountRepository.findById(data.debitAccountId()).orElseThrow();
        if (Objects.equals(debit.getBlocked(), Boolean.TRUE)){
            throw new RuntimeException("account_is_blocked");//ეს ამოწმებს დაბლოკილი ხომ არაა დებეტ ანგარიში
        }

        if(debit.getAmount() - data.amount() < 0){
            throw  new RuntimeException("not_enought_amount");// ეს ამოწმებს საკმარის თანხას

        }

        transaction.setDebitAccount(debit);
        transaction.setCreditAccount(credit);
        transaction.setAmount(data.amount());
        transaction.setComment(data.comment());
        transactionRepository.save(transaction);

    }
}
