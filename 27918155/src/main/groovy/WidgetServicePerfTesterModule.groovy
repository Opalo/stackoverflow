import com.google.inject.AbstractModule
import com.google.inject.assistedinject.FactoryModuleBuilder

import static com.google.inject.name.Names.named

public class WidgetServicePerfTesterModule extends AbstractModule {

    @Override
    protected void configure() {
        bindConstant().annotatedWith(named('numWidgets')).to(5)
        bind(WidgetClient).to(SimpleWidgetClient)
        bind(WidgetGenerator).to(SimpleWidgetGenerator)
        install(new FactoryModuleBuilder().build(WidgetFactory))
    }
}