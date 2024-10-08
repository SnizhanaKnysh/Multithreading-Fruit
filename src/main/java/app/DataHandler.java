package app;

import static java.lang.Thread.currentThread;

public class DataHandler {

    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        // критичний блок коду
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ", count++, fruit));
            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}
