package sv.edu.udb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import sv.edu.udb.configuration.TestInfrastructureConfig;
import sv.edu.udb.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountRepositoryTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        //contexto a traves del archivo de configuracion
        context = SpringApplication.run(TestInfrastructureConfig.class);
    }

    @Test
    void getBeanByCast() {
        final AccountRepository accountRepository = (AccountRepository) context.getBean("accountRepository");
        assertNotNull(accountRepository);
        final String accountNumber = accountRepository.findAccountNumber(2);
    }

    @Test
    void getBeanTypeMethod() {
        final AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
        assertNotNull(accountRepository);
        final String accountNumber = accountRepository.findAccountNumber(1);
    }

    @Test
    void getBeanByIDWhenIdIsUnique(){
        final AccountRepository accountRepository =context.getBean(AccountRepository.class);
        assertNotNull(accountRepository);
        final String accountNumber=accountRepository.findAccountNumber(2);
    }
}
