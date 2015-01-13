import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import com.google.inject.assistedinject.AssistedInject

public class Widget extends Thingy {

    @Inject
    WidgetClient widgetClient
    int numFoos

    @AssistedInject
    Widget(@Assisted int numFoos) {
        this.numFoos = numFoos
    }

    @Override
    void doStuff() {
        widgetClient.doSomethingOnServer(numFoos)
    }
}