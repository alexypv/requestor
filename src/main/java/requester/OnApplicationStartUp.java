package requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import requester.persistence.models.Counter;
import requester.persistence.repositories.CounterRepository;

@Component
public class OnApplicationStartUp {

    private final CounterRepository counterRepository;

    @Autowired
    public OnApplicationStartUp(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (counterRepository.findAll().isEmpty()) {
            preloadData();
        }
    }

    @Transactional
    public void preloadData() {
        Counter counter = new Counter();
        counter.setAuditParamsForCreation("SYSTEM");
        counter.setValue(0L);
        counterRepository.save(counter);
    }
}
