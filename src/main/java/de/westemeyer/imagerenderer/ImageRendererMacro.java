package de.westemeyer.imagerenderer;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.atlassian.renderer.RenderContext;
import com.atlassian.renderer.v2.RenderMode;
import com.atlassian.renderer.v2.macro.BaseMacro;
import com.atlassian.renderer.v2.macro.MacroException;

public class ImageRendererMacro extends BaseMacro
{
	@Override
	public boolean isInline()
	{
		return true;
	}

	@Override
	public boolean hasBody()
	{
		return true;
	}

	@Override
	public RenderMode getBodyRenderMode()
	{
		return RenderMode.INLINE;
	}

	@Override
	public String execute(Map<String, Object> map, String body, RenderContext renderContext) throws MacroException
	{
		return StringUtils.reverse(body);
	}
}
