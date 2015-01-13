import com.google.inject.Inject
import com.google.inject.name.Named

class SimpleWidgetGenerator implements WidgetGenerator {

    @Inject
    @Named('numWidgets')
    int numWidgets
    @Inject
    WidgetFactory widgetFactory

    @Override
    List<Widget> generateWidgets() {
        (1..numWidgets).collect { widgetFactory.createWidget(new Random().nextInt()) }
    }
}