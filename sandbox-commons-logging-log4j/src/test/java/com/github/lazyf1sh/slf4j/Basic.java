package com.github.lazyf1sh.slf4j;

import one.Runner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class Basic {

    private static final Log LOGGER = LogFactory.getLog(Runner.class);

    @Test
    public  void main() {
        LOGGER.debug("Example debug message ..");
        LOGGER.info("Example info message ..");
        LOGGER.warn("Example warn message ..");
        LOGGER.error("Example error message ..");
        LOGGER.fatal("Example fatal message ..");
    }
}
