/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_case_06.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-06.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_case
*    GoodSink: Case statement contains code
*    BadSink : An empty case statement has no effect
* Flow Variant: 06 Control flow: if(PRIVATE_STATIC_FINAL_FIVE==5) and if(PRIVATE_STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE398_Poor_Code_Quality__empty_case_06 extends AbstractTestCase
{
    /* The variable below is declared "final", so a tool should be able
     * to identify that reads of this will always give its initialized
     * value.
     */
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            int x = (new SecureRandom()).nextInt();
            switch (x)
            {
                /* FLAW: An empty case statement has no effect */
            case 0:
                break;
            default:
                IO.writeLine("Inside the default statement");
                break;
            }
            IO.writeLine("Hello from bad()");
        }
    }

    /* good1() changes PRIVATE_STATIC_FINAL_FIVE==5 to PRIVATE_STATIC_FINAL_FIVE!=5 */
    private void good1() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            int x = (new SecureRandom()).nextInt();

            switch (x)
            {
                /* FIX: Do not include an empty case statement */
            case 0:
                IO.writeLine("Inside the case statement");
                break;
            default:
                IO.writeLine("Inside the default statement");
                break;
            }

            IO.writeLine("Hello from good()");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            int x = (new SecureRandom()).nextInt();
            switch (x)
            {
                /* FIX: Do not include an empty case statement */
            case 0:
                IO.writeLine("Inside the case statement");
                break;
            default:
                IO.writeLine("Inside the default statement");
                break;
            }
            IO.writeLine("Hello from good()");
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
