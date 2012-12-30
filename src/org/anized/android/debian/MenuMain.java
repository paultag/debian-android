package org.anized.android.debian;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.anized.android.debian.models.Package;


public class MenuMain extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Package pkg = new Package();
		pkg.fakeData();
		
		setContentView(R.layout.package_overview);
		this.populateView(pkg);
	}
	
	private void populateView(Package pkg) {
		((TextView) findViewById(R.id.source)).setText(pkg.getSource());
		((TextView) findViewById(R.id.priority)).setText(pkg.getPriority());
		((TextView) findViewById(R.id.section)).setText(pkg.getSection());
	}
}