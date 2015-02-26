package lv.javaguru.ideakeeper.database;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import lv.javaguru.ideakeeper.domain.RefCard;

import org.junit.Test;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

/**
 * Created by Viktor on 25/02/2015.
 */
public class RefCardDAOImplTest extends DatabaseHibernateTest {

    @Test
    public void testCreateClient() {
        doInTransaction(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                RefCard refCard = new RefCard();
                assertThat(refCard.getId(), is(nullValue()));
                referenceCardDAO.create(refCard);
                assertThat(refCard.getId(), is(notNullValue()));
            }
        });
    }

}
