package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class PowerMockitoMockingConstructorTest {

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_testPrivateMethodCall() throws Exception {

    final ArrayList mockList = mock(ArrayList.class);

    when(mockList.size()).thenReturn(10);

    PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

    final int size = systemUnderTest.methodUsingAnArrayListConstructor();

    assertEquals(10, size);

  }

//  Important Note:
//    You should use Powermock only if you cannot change the bad design of the System under Test (SUT).
//    If you have a good design of your SUT you should build your tests with Mockito and JUnit.
}
