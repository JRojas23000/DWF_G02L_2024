package sv.edu.udb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import sv.edu.udb.configuration.TestInfrastructureConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransferServiceTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp(){
        //creacion del contexto a traves del archivo de configuracion
        context = SpringApplication.run(TestInfrastructureConfig.class);
    }
    //veremos las diferentes formas de acceder a los beans
    @Test
    void getBeanByCastAndTransferMoney(){
        //obtenemos el bean
        final TransferService transferService=(TransferService)context.getBean("transferService");
        //utilizamos el bean sin el operador new
        assertNotNull(transferService);
        final Double amountTransferred=transferService.transfer(1,2,20D);
        assertEquals(400D, amountTransferred);
    }
    @Test
    void getBeanTypeMethodAndTransferMoney(){
        //obtenemos el bean
        final TransferService transferService=context.getBean("transferService", TransferService.class);
        assertNotNull(transferService);//Notnull object
        final Double amountTransfered=transferService.transfer(1,2,20D);
        assertEquals(400D, amountTransfered);
    }
    @Test
    void  getBeanIdWhenIdIsUniqueAndTransferMoney(){
        //Obtenemos el bean
        final TransferService transferService=context.getBean(TransferService.class);
        assertNotNull(transferService);//not null object
        final Double amountTransfered=transferService.transfer(1,2,20D);
        assertEquals(400D, amountTransfered);
    }
}
