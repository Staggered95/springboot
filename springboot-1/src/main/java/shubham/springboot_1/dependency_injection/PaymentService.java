package shubham.springboot_1.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay() {
        System.out.println("Payment done");
    }
}

