package de.westemeyer.imagerenderer;

import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.config.properties.APKeys;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.issue.fields.renderer.IssueRenderContext;
import com.atlassian.jira.issue.fields.renderer.wiki.AtlassianWikiRenderer;
import com.atlassian.jira.plugin.renderer.JiraRendererModuleDescriptor;
import com.atlassian.jira.util.velocity.VelocityRequestContextFactory;

public class ImageRenderer extends AtlassianWikiRenderer
{
	private final String baseUrl;

	public ImageRenderer(EventPublisher eventPublisher, ApplicationProperties applicationProperties,
			VelocityRequestContextFactory velocityRequestContextFactory)
	{
		super(eventPublisher, applicationProperties, velocityRequestContextFactory);
		baseUrl = applicationProperties.getString(APKeys.JIRA_BASEURL);
	}

	public static final String TYPE = "fixed-text-renderer";

	private JiraRendererModuleDescriptor jiraRendererModuleDescriptor;

	@Override
	public JiraRendererModuleDescriptor getDescriptor()
	{
		return jiraRendererModuleDescriptor;
	}

	@Override
	public String getRendererType()
	{
		return TYPE;
	}

	@Override
	public void init(JiraRendererModuleDescriptor jiraRendererModuleDescriptor)
	{
		this.jiraRendererModuleDescriptor = jiraRendererModuleDescriptor;

	}

	@Override
	public String render(String s, IssueRenderContext issueRenderContext)
	{
		String replacedResult = renderTextWithCustomWikiLink(s);
		return super.render(replacedResult, issueRenderContext);
	}

	/**
	 * transforms text like "name" into
	 * <img src="http://hostname.com/jira/images/name.png" alt="name">
	 * 
	 * @param text
	 * @return
	 */
	private String renderTextWithCustomWikiLink(String text)
	{
		String result = text == null ? ""
				: "!" + baseUrl + "/images/" + text.replaceAll(" ", "_") + ".png|alt=" + text + "!";
		return result;
	}

	@Override
	public String renderAsText(String s, IssueRenderContext issuerendercontext)
	{
		return s;
	}

	@Override
	public Object transformForEdit(Object obj)
	{
		return obj;
	}

	@Override
	public Object transformFromEdit(Object obj)
	{
		return obj;
	}

}
