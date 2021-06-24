package cn.wmj.util;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "UserAgent", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class UserAgentMojo extends AbstractMojo {

	public void execute() throws MojoExecutionException, MojoFailureException {
		
	}

}
