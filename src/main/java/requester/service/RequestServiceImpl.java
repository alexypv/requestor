package requester.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import requester.enums.RequestTypeEnum;
import requester.persistence.models.Request;
import requester.persistence.repositories.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {

    // Repositories
    private RequestRepository requestRepository;

    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public void createRequest(Long value, Long version, RequestTypeEnum requestType) {
        Request request = new Request();
        request.setAuditParamsForCreation("SYSTEM");
        request.setType(requestType);
        request.setValue(value);
        request.setVersion(version);
        requestRepository.save(request);
    }

}
