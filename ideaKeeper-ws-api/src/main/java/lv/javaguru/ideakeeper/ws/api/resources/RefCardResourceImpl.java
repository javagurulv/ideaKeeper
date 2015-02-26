package lv.javaguru.ideakeeper.ws.api.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import lv.javaguru.ideakeeper.ws.api.RestException;
import lv.javaguru.ideakeeper.ws.api.domain.RefCardDTO;

public class RefCardResourceImpl implements RefCardResource {

    private Client client;
    private RefCardResourceUrlBuilder urlBuilder;


    public RefCardResourceImpl(String baseWebServiceUrl) {
        client = ClientBuilder.newClient();
        urlBuilder = new RefCardResourceUrlBuilder(baseWebServiceUrl);
    }

    @Override
    public RefCardDTO create(RefCardDTO refCardDTO) throws RestException {
        try {
            String refCardUrl = urlBuilder.getCreateUrl();            
            WebTarget target = client.target(refCardUrl);
            return target.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(refCardDTO, MediaType.APPLICATION_JSON), RefCardDTO.class);
        } catch (Throwable e) {
            throw new RestException(e);
        }
    }

    @Override
    public RefCardDTO get(Long refCardId) throws RestException {
        try {
            String refCardUrl = urlBuilder.getEntityUrl(refCardId);
            WebTarget target = client.target(refCardUrl);
            return target.request(MediaType.APPLICATION_XML)
                    .get(RefCardDTO.class);
        } catch (Throwable e) {
            throw new RestException(e);
        }
    }

    @Override
    public RefCardDTO delete(Long refCardId) throws RestException {
        try {
            String refCardUrl = urlBuilder.getEntityUrl(refCardId);
            WebTarget target = client.target(refCardUrl);
            return target.request(MediaType.APPLICATION_XML)
                    .delete(RefCardDTO.class);
        } catch (Throwable e) {
            throw new RestException(e);
        }
    }

    @Override
    public RefCardDTO update(Long refCardId, 
                             RefCardDTO refCardDTO) throws RestException {
        try {
            String refCardUrl = urlBuilder.getEntityUrl(refCardId);
            WebTarget target = client.target(refCardUrl);
            return target.request(MediaType.APPLICATION_XML)
                    .put(Entity.entity(refCardDTO, MediaType.APPLICATION_XML), RefCardDTO.class);
        } catch (Throwable e) {
            throw new RestException(e);
        }
    }

}
