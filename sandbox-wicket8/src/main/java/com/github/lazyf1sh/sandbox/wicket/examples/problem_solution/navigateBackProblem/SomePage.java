package com.github.lazyf1sh.sandbox.wicket.examples.problem_solution.navigateBackProblem;

import org.apache.wicket.markup.html.WebPage;

public class SomePage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        SomeComponent someComp = new SomeComponent("someComponent", new SomeHugeModel());
        add(someComp);
        
    }
   
}
