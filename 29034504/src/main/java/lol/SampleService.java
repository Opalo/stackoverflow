package lol;

public class SampleService {

    public void handleFoo(SampleEnum se) {
        switch (se) {
            case ONE:
                doEventOne();
                break;
            case TWO:
                doEventTwo();
                break;
            default:
                throw new IllegalArgumentException("Do not know how to handle " + se);
        }
    }

    private void doEventOne() {
        System.out.println(1);
    }

    private void doEventTwo() {
        System.out.println(2);
    }
}