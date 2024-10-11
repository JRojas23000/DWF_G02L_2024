package sv.edu.udb.repository.implementation;

import sv.edu.udb.repository.AccountRepository;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.UUID;

public class JdbcAccountRepository implements AccountRepository {
    //dependencia del bean de la base de datos
    //que para este ejemplo es una base de datos en memoria
    //para finales ilustrativos
    //acceso hacia una base de datos x (mysql, postgresql, oracle, etc)
    private final DataSource ds;
    public JdbcAccountRepository(final DataSource ds){
        this.ds = Objects.requireNonNull(ds);
    }
    @Override
    public String findAccountNumber(final Integer userId){
        return UUID.randomUUID().toString();//Random string
    }
}