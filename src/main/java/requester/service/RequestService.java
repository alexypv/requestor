package requester.service;

import requester.enums.RequestTypeEnum;

/**
 * Сервис для работы с историей запросов.
 */
public interface RequestService {

    /**
     * Создать запись в истории запросов
     *
     * @param value       Значение счетчика. {@link requester.persistence.models.Counter}
     * @param version     Версия счетчика. {@link requester.persistence.models.Counter}
     * @param requestType Тип запроса.
     */
    void createRequest(Long value, Long version, RequestTypeEnum requestType);

}
