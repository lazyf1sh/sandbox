package com.github.lazyf1sh.sandbox.instrumentation.agent;

import java.lang.instrument.Instrumentation;

public class MyInstrumentationAgent
{
    public static void premain(String agentArgs, Instrumentation inst)
    {
        System.out.println("[Agent] In premain method");
    }

    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        System.out.println("[Agent] In agentmain method");
    }
}
