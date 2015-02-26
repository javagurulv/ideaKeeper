package lv.javaguru.ideakeeper.ws.api.resources;

class RefCardResourceUrlBuilder {

    private String baseWebServiceUrl;

    RefCardResourceUrlBuilder(String baseWebServiceUrl) {
        this.baseWebServiceUrl = baseWebServiceUrl;
    }

    public String getCreateUrl() {
        return baseWebServiceUrl + RefCardResource.CREATE_REF_CARD_URL;
    }

    public String getEntityUrl(Long refCardId) {
        return baseWebServiceUrl
                + RefCardResource.REF_CARD_URL.replace("{refCardId}", refCardId.toString());
    }
    
}
