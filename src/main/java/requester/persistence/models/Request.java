package requester.persistence.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import requester.enums.RequestTypeEnum;

import javax.persistence.*;

/**
 * Запрос
 */
@Entity(name = "request")
@Table(name = "REQUEST", schema = "REQUEST_COUNTER")
@EqualsAndHashCode(callSuper = true)
@Data
public class Request extends AuditEntity {

    /**
     * Тип запроса
     */
    @Column(name = "REQUEST_TYPE", length = 16)
    @Enumerated(EnumType.STRING)
    private RequestTypeEnum type;

    /**
     * Значение счетчика
     */
    @Column(name = "COUNTER_VALUE")
    private Long value;

    /**
     * Версия счетчика.
     */
    @Column(name = "COUNTER_VERSION")
    private Long version;

}
