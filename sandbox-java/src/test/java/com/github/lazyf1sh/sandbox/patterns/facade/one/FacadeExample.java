package com.github.lazyf1sh.sandbox.patterns.facade.one;

import org.junit.Test;

/**
 * 1. adds additional layers of abstraction.<br/>
 * 2. purpose is to provide a single interface rather than multiple interfaces that does the similar kind of jobs<br/>
 * 3. Subsystem interfaces are not aware of Facade and they shouldn’t have any reference of the Facade interface.<br/>
 * 4. it doesn’t hide subsystem interfaces from the client. Whether to use Facade or not is completely dependent on client code.<br/>
 *
 * @see <a href=https://www.journaldev.com/1557/facade-design-pattern-in-java>https://www.journaldev.com/1557/facade-design-pattern-in-java</a>
 * @see <a href=https://www.baeldung.com/java-facade-pattern>https://www.baeldung.com/java-facade-pattern</a>
 * @author Ivan Kopylov
 */
public class FacadeExample
{

    @Test
    public void withoutFacade()
    {
        FuelInjector injector = new FuelInjector();
        AirflowController airflowController = new AirflowController();
        CatalyticConverter coolingController = new CatalyticConverter();
        CatalyticConverter catalyticConverter = new CatalyticConverter();
        Starter starter = new Starter();

        //start engine
        airflowController.takeAir();
        injector.on();
        injector.inject();
        starter.start();
        coolingController.on();
        catalyticConverter.on();

        //stop engine
        injector.off();
        catalyticConverter.off();
        coolingController.off();
        airflowController.off();

    }

    @Test
    public void usingFacade()
    {
        CarEngineFacade engineFacade = new CarEngineFacade();
        engineFacade.startEngine();
        engineFacade.stopEngine();
    }

    class CarEngineFacade
    {
        FuelInjector       injector           = new FuelInjector();
        AirflowController  airflowController  = new AirflowController();
        CatalyticConverter coolingController  = new CatalyticConverter();
        CatalyticConverter catalyticConverter = new CatalyticConverter();
        Starter            starter            = new Starter();

        public void startEngine()
        {
            airflowController.takeAir();
            injector.on();
            injector.inject();
            starter.start();
            coolingController.on();
            catalyticConverter.on();
        }

        public void stopEngine()
        {
            injector.off();
            catalyticConverter.off();
            coolingController.off();
            airflowController.off();
        }
    }

    class FuelInjector
    {
        void on()
        {
        }

        void off()
        {
        }

        void inject()
        {
        }
    }

    class Starter
    {
        void start()
        {
        }
    }

    class AirflowController
    {

        void takeAir()
        {
        }

        void off()
        {
        }

    }

    class CatalyticConverter
    {
        void on()
        {
        }

        void off()
        {
        }
    }

    class CoolingController
    {
        void run()
        {
        }

        void cool()
        {
        }

        void stop()
        {
        }
    }
}
