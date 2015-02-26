package lv.javaguru.ideakeeper.ws.api.resources;

import lv.javaguru.ideakeeper.ws.api.RestException;
import lv.javaguru.ideakeeper.ws.api.domain.RefCardDTO;

public interface RefCardResource {

    static final String CREATE_REF_CARD_URL = "/rest/refCard";
    static final String REF_CARD_URL = "/rest/refCard/{refCardId}";


    RefCardDTO create(RefCardDTO refCardDTO) throws RestException;

    RefCardDTO get(Long refCardId) throws RestException;

    RefCardDTO delete(Long refCardId) throws RestException;

    RefCardDTO update(Long refCardId, 
                      RefCardDTO refCardDTO) throws RestException;

}
