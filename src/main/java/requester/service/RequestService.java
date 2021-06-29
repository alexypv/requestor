package requester.service;

import requester.enums.RequestTypeEnum;

public interface RequestService {

    void createRequest(Long value, Long version, RequestTypeEnum requestType);

}
