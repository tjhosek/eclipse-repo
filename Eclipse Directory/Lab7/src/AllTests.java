import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AddTest.class, DivideTest.class, GetComplexTest.class, GetConjugateTest.class, IsEqualTest.class, MultiplyTest.class, SubtractTest.class, toStringTest.class})
public class AllTests
{

}
