package lv.javaguru.ideakeeper.database.impl;

import lv.javaguru.ideakeeper.database.ReferenceCardDAO;
import lv.javaguru.ideakeeper.domain.RefCard;

import org.springframework.stereotype.Component;

/**
 * Created by Viktor on 25/02/2015.
 */
@Component
class ReferenceCardDAOImpl
        extends CRUDOperationDAOImpl<RefCard, Long>
        implements ReferenceCardDAO {

}
