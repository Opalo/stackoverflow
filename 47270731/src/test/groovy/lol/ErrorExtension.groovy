package lol

import org.spockframework.runtime.IRunListener
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.ErrorInfo
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.IterationInfo
import org.spockframework.runtime.model.SpecInfo


class ErrorExtension implements IGlobalExtension {

    @Override
    void start() {

    }

    @Override
    void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new ErrorListener())
    }

    @Override
    void stop() {

    }

}

class ErrorListener implements IRunListener {

    def holder = new ThreadLocal<IterationInfo>()

    @Override
    void beforeSpec(SpecInfo spec) {

    }

    @Override
    void beforeFeature(FeatureInfo feature) {

    }

    @Override
    void beforeIteration(IterationInfo iteration) {
        println("iteration info in beforeIteration(): ${holder.get()}")
        holder.set(iteration)
    }

    @Override
    void afterIteration(IterationInfo iteration) {
        println("iteration info in afterIteration(): ${holder.get()}")
        holder.set(null)
    }

    @Override
    void afterFeature(FeatureInfo feature) {

    }

    @Override
    void afterSpec(SpecInfo spec) {

    }

    @Override
    void error(ErrorInfo error) {
        println("iteration info in error(): ${holder.get()}")
        println("error: $error for values: ${holder.get().dataValues.toList()}")
    }

    @Override
    void specSkipped(SpecInfo spec) {

    }

    @Override
    void featureSkipped(FeatureInfo feature) {

    }

}