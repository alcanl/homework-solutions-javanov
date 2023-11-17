package org.csystem.homework.solution.stringmap_class;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Ignore
public class StringMapTest {
    private static final StringMap<Integer> stringMap = new StringMap<>();

    @Before
    public void setUp()
    {
        for (var i = 1; i <= 5; ++i)
            stringMap.addElement("Test" + i, i);
    }
    @Test
    public void StringMapAddElementContainsKeyTrueTest()
    {
        Assert.assertTrue(stringMap.addElement("Test5", 5));
    }
    @Test
    public void StringMapAddElementContainsKeyFalseTest()
    {
        Assert.assertFalse(stringMap.addElement("Test6", 6));
    }
    @Test
    public void StringMapRemoveElementTrueTest()
    {
        Assert.assertTrue(stringMap.removeElement("Test6"));
    }
    @Test
    public void StringMapRemoveElementFalseTest()
    {
        Assert.assertFalse(stringMap.removeElement("Test6"));
    }
    @Test
    public void StringMapGetDefaultValueTest()
    {
        Assert.assertEquals(Integer.valueOf(7), stringMap.getValue("Test7", 7));
    }
    @Test
    public void StringMapGetPresentValueTest()
    {
        Assert.assertEquals(Optional.of(4), Optional.of(stringMap.getValue("Test4", 7)));
    }
    @Test
    public void StringMapGetEmptyValueTest()
    {
        Assert.assertEquals(Optional.empty(), stringMap.getValue("Test10"));
    }
    @Test
    public void StringMap_GivenNullKey_ThenThrowsExceptionTest()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue(null));
    }
    @Test
    public void StringMap_GivenEmptyStringKey_ThenThrowsExceptionTest()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue(""));
    }
    @Test
    public void StringMapCountTest()
    {
        Assert.assertEquals(6, stringMap.count());
    }
}
