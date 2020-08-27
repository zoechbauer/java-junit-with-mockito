package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowerMockitoMockingStaticMethodTest {

  @Mock
  private Dependency dependency;

  @InjectMocks
  private SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_MockingAStaticMethodCall() {
    final List<Integer> stats = Arrays.asList(1, 2, 3);
    when(dependency.retrieveAllStats()).thenReturn(stats);

    PowerMockito.mockStatic(UtilityClass.class);

    when(UtilityClass.staticMethod(anyLong())).thenReturn(120);

    final int result = systemUnderTest.methodCallingAStaticMethod();
    assertEquals(120, result);

    // To verify a specific method call
    // First : Call PowerMockito.verifyStatic()
    // Second : Call the method to be verified
    PowerMockito.verifyStatic();
    UtilityClass.staticMethod(1 + 2 + 3);

    // verify exact number of calls
    // PowerMockito.verifyStatic(Mockito.times(1));
  }

}
