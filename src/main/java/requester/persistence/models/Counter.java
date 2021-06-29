package requester.persistence.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "counter")
@Table(name = "COUNTER", schema = "REQUEST_COUNTER")
@Data
public class Counter extends AuditEntity {

    @Version
    private long version;

    @Column(name = "COUNTER_VALUE")
    private Long value;


}
