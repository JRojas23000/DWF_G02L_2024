package sv.edu.udb.service.implementation;

import sv.edu.udb.repository.AccountRepository;
import sv.edu.udb.service.TransferService;

import java.util.Objects;

public class TransferServiceImpl implements TransferService {
    //Necesitamos el accountrepository para obtener los numeros de cuenta
    //y ejecutar la transferencia
    //dependemos del bean accountrepository
    private final AccountRepository accountRepository;
    public TransferServiceImpl(final AccountRepository accountRepository){
        this.accountRepository= Objects.requireNonNull(accountRepository);
    }
    @Override
    public Double transfer(final Integer userId1, final Integer userId2,
                           final Double amount){
        //ejecutamos operaciones con los numeros de cuenta
        //devolvemos el doble del amount
        final String accountNumberUser1=accountRepository.findAccountNumber(userId1);
        final String accountNumberUser2= accountRepository.findAccountNumber(userId2);
        return amount*amount;
    }
}
