package org.anized.android.debian.models;

/**
 * @author Paul Tagliamonte
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.util.Log;
import java.util.Map;


/**
 * POJO for holding PTS Package data off the line.
 */
public class Package {
	
	private Map<String, String> versions;
	private String source;
	private String latestVersion;
	private String standardsVersion;
	private String priority;
	private String section;
	private List<String> binaryPackages;
	private Map<String, Integer> lintian;
	private Map<String, Integer> bugs;
	private Developer maintainer;
	private List<Developer> uploaders;
	
	public void fakeData() {
		/* For debugging */
		this.versions = new HashMap<String, String>();
		this.versions.put("unstable", "3.0");
		this.versions.put("testing", "2.0");
		this.versions.put("stable", "1.0");
		
		this.latestVersion = "3.0";
		this.standardsVersion = "3.4.3";
		this.priority = "extra";
		this.section = "python";
		
		this.source = "foo";
		
		this.binaryPackages = new ArrayList<String>();
		this.binaryPackages.add("foo");
		this.binaryPackages.add("python-foo");
		this.binaryPackages.add("python3-foo");
		this.binaryPackages.add("foo-doc");
		
		this.lintian = new HashMap<String, Integer>();
		this.lintian.put("warnings", 10);
		this.lintian.put("errors", 0);
		
		this.bugs = new HashMap<String, Integer>();
		this.bugs.put("all", 20);
		this.bugs.put("fp", 15);
		this.bugs.put("in", 0);
		this.bugs.put("mw", 1);
		this.bugs.put("rc", 4);
		
		this.maintainer = new Developer();
		this.maintainer.setEmail("paultag@debian.org");
		this.maintainer.setName("Paul R. Tagliamonte");
		
		this.uploaders = new ArrayList<Developer>();
		Developer bob = new Developer();
		bob.setEmail("arno@debian.org");
		bob.setName("Arno Trolololol");
		this.uploaders.add(bob);
		
		Developer sue = new Developer();
		sue.setEmail("nondd@example.com");
		sue.setName("Sue Smith-Johnson");
		this.uploaders.add(sue);
	}
	
	public Map<String, String> getVersions() {
		return versions;
	}
	
	public void setVersions(Map<String, String> versions) {
		this.versions = versions;
		Log.d("debian", "Set package versions");
	}
	
	public String getLatestVersion() {
		return latestVersion;
	}
	
	public void setLatestVersion(String latestVersion) {
		this.latestVersion = latestVersion;
		Log.d("debian", "Set latest version to " + latestVersion);
	}
	
	public String getStandardsVersion() {
		return standardsVersion;
	}
	
	public void setStandardsVersion(String standardsVersion) {
		this.standardsVersion = standardsVersion;
		Log.d("debian", "Set standards version to " + standardsVersion);
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
		Log.d("debian", "Set priority to " + priority);
	}
	
	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
		Log.d("debian", "Set section to " + section);
	}
	
	public List<String> getBinaryPackages() {
		return binaryPackages;
	}
	
	public void setBinaryPackages(List<String> binaryPackages) {
		this.binaryPackages = binaryPackages;
		Log.d("debian", "Set binary packages");
	}
	
	public Map<String, Integer> getLintian() {
		return lintian;
	}
	
	public void setLintian(Map<String, Integer> lintian) {
		this.lintian = lintian;
		Log.d("debian", "Set lintian");
	}
	
	public Map<String, Integer> getBugs() {
		return bugs;
	}
	
	public void setBugs(Map<String, Integer> bugs) {
		this.bugs = bugs;
		Log.d("debian", "Set bugs");
	}

	public Developer getMaintainer() {
		return maintainer;
	}

	public void setMaintainer(Developer maintainer) {
		this.maintainer = maintainer;
	}

	public List<Developer> getUploaders() {
		return uploaders;
	}

	public void setUploaders(List<Developer> uploaders) {
		this.uploaders = uploaders;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}