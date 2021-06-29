package requester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import requester.enums.RequestTypeEnum;
import requester.service.CounterService;

@RestController
@RequestMapping("/api/counter")
public class CountController {

    private CounterService counterService;

    @Autowired
    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public Long getCurrentCount() {
        return counterService.getCounter();
    }

    @PostMapping
    public Long appendToCount() {
        return counterService.changeCounter(RequestTypeEnum.POST);
    }

    @DeleteMapping
    public Long clearCount() {
        return counterService.changeCounter(RequestTypeEnum.DELETE);
    }

    @PostMapping("/test-parallel")
    public Long testParallel() {

        Thread thread1 = new Thread(() -> counterService.changeCounter(RequestTypeEnum.POST));
        Thread thread2 = new Thread(() -> counterService.changeCounter(RequestTypeEnum.POST));
        Thread thread3 = new Thread(() -> counterService.changeCounter(RequestTypeEnum.POST));
        Thread thread4 = new Thread(() -> counterService.changeCounter(RequestTypeEnum.POST));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        return null;
    }


}
