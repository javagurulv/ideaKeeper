package lv.javaguru.ideakeeper.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lv.javaguru.ideakeeper.config.CoreConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Viktor on 25/02/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreConfig.class)
@TransactionConfiguration(transactionManager = "hibernateTX", defaultRollback = false)
public class DatabaseHibernateTest {

    @Autowired
    @Qualifier("hibernateTX")
    protected PlatformTransactionManager transactionManager;

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    protected ReferenceCardDAO referenceCardDAO;


    @Before
    public void cleanDatabase() {
        List<String> tableNames = getTableNames();
        for(final String tableName : tableNames) {
            doInTransaction(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    Session session = sessionFactory.getCurrentSession();
                    String queryString = "DELETE FROM " + tableName;
                    Query query = session.createSQLQuery(queryString);
                    query.executeUpdate();
                }
            });
        }
    }

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();

        tableNames.add("REFERENCE_CARDS");

        return tableNames;
    }

    protected void doInTransaction(TransactionCallbackWithoutResult callbackWithoutResult) {
        TransactionTemplate tt = new TransactionTemplate(transactionManager,
                new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW));
        tt.execute(callbackWithoutResult);
    }

}
