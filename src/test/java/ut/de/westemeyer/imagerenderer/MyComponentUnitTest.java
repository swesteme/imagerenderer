package ut.de.westemeyer.imagerenderer;

import org.junit.Test;

import de.westemeyer.imagerenderer.MyPluginComponent;
import de.westemeyer.imagerenderer.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}