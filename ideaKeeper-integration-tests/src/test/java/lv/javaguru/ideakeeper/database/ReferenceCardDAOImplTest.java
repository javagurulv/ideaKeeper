package lv.javaguru.ideakeeper.database;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import lv.javaguru.ideakeeper.domain.ReferenceCard;
import org.junit.Test;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

/**
 * Created by Viktor on 25/02/2015.
 */
public class ReferenceCardDAOImplTest extends DatabaseHibernateTest {

    @Test
    public void testCreateClient() {
        doInTransaction(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                ReferenceCard referenceCard = new ReferenceCard();
                assertThat(referenceCard.getId(), is(nullValue()));
                referenceCardDAO.create(referenceCard);
                assertThat(referenceCard.getId(), is(notNullValue()));
            }
        });
    }

}
