package requester.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import requester.enums.RequestTypeEnum;
import requester.persistence.models.Counter;
import requester.persistence.repositories.CounterRepository;

@Service
@Log4j2
public class CounterServiceImpl implements CounterService {

    // Repositories
    private final CounterRepository counterRepository;

    // Services
    private final RequestService requestService;

    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository, RequestService requestService) {
        this.counterRepository = counterRepository;
        this.requestService = requestService;
    }

    @Override
    @Transactional
    public Long getCounter() {
        return counterRepository.getCounter().getValue();
    }

    @Override
    public Long changeCounter(RequestTypeEnum requestType) {
        boolean success = false;
        Long value = null;
        while (!success) {
            try {
                value = editCounter(requestType);
                success = true;
            } catch (ObjectOptimisticLockingFailureException e) {
                log.info("  # Counter version has been changed, trying to change again... ");
                success = false;
            }
        }
        return value;
    }

    /**
     * Изменить сущность счетчика в БД
     *
     * @param requestType тип запроса;
     * @return Значение счетчика;
     */
    @Transactional
    public Long editCounter(RequestTypeEnum requestType) {
        log.info("  # Change counter value...");
        Counter counter = counterRepository.getCounter();
        if (requestType.equals(RequestTypeEnum.POST)) counter.setValue(counter.getValue() + 1);
        else if (requestType.equals(RequestTypeEnum.DELETE)) counter.setValue(0L);
        counterRepository.save(counter); // Тут может выбросить исключение ObjectOptimisticLockingFailureException
        // Создаем запись в истории запросов
        requestService.createRequest(counter.getValue(), counter.getVersion(), requestType);
        return counter.getValue();
    }


}
