import com.google.inject.Inject

import static com.google.inject.Guice.createInjector

public class WidgetServicePerfTester {

    @Inject
    WidgetGenerator widgetGenerator

    static main(args) {
        def injector = createInjector(new WidgetServicePerfTesterModule())
        def perfTester = injector.getInstance(WidgetServicePerfTester)

        perfTester.run()
    }

    void run() {
        List<Widget> widgets = widgetGenerator.generateWidgets()
        widgets.each {
            it.doStuff()
        }
    }
}
