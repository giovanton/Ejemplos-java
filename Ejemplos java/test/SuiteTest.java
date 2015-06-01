import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import persona.TestPersona;
import ejemploRepaso.base.TestListaPersona;

@RunWith(Suite.class)
@SuiteClasses({
	TestListaPersona.class, TestPersona.class,
})
public class SuiteTest {

}
