package org.bitbucket.lazyf1sh.sandbox.wicket.examples.problem_solution.navigateBackProblem;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.Model;

public class SomeHugeModel extends Model<Integer>
{
    public List<Integer> hugeAmountOfData = new ArrayList<Integer>();

    public SomeHugeModel()
    {
        for (int i = 0; i < 10000000; i++)
        {
            hugeAmountOfData.add(i);
        }
        System.out.print("Huge model initialized");
    }
}
