package DataProvider;

import org.testng.annotations.DataProvider;

public class da_Precondition {

  @DataProvider(name = "data_Login")
  public Object[] dataLogin() {
    return new Object[][] {{"34906", "Manulife@2025#"}
    };
  }
}
