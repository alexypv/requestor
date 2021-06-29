package requester.persistence.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Счетчик запросов
 */
@EqualsAndHashCode(callSuper = true)
@Entity(name = "counter")
@Table(name = "COUNTER", schema = "REQUEST_COUNTER")
@Data
public class Counter extends AuditEntity {

    /**
     * Версия
     */
    @Version
    private long version;

    /**
     * Текущее значение счетчика
     */
    @Column(name = "COUNTER_VALUE")
    private Long value;


}
