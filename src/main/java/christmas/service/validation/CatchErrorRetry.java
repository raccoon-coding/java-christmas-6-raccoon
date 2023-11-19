package christmas.service.validation;

import java.util.function.Supplier;

public class CatchErrorRetry {
    public static void executeWithRetry(Runnable operation) {
        while (true) {
            try {
                operation.run();
                return;
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
