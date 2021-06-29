package requester.service;

import requester.enums.RequestTypeEnum;

/**
 * Сервис взаимодействия со счетчиком POST запросов.
 */
public interface CounterService {

    /**
     * Получить текущее значение счетчика.
     *
     * @return Значение счетчика.
     */
    Long getCounter();

    /**
     * Изменить значение счетчика.
     *
     * @param requestType Тип запроса.
     * @return Значение счетчика.
     */
    Long changeCounter(RequestTypeEnum requestType);

}
