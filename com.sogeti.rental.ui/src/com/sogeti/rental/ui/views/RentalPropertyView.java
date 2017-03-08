package com.sogeti.rental.ui.views;


import java.security.Principal;
import java.util.Enumeration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class RentalPropertyView extends ViewPart {
	
	Label rentalLabel;
	Label rentalObjet1;
	Label rentalObjet2;
	Label rentalCustomer1;
	Label rentalCustomer2;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		
		Group infogroup = new Group(parent,SWT.NONE);
		infogroup.setText("Informations");
		infogroup.setLayout(new GridLayout(2,false));
		rentalLabel = new Label(parent, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 2;
		rentalLabel.setLayoutData(gd);
		
		rentalObjet1 = new Label(infogroup, SWT.BORDER);
		rentalObjet1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rentalObjet2 = new Label(infogroup, SWT.BORDER);
		rentalObjet2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rentalCustomer1 = new Label(infogroup, SWT.BORDER);
		rentalCustomer1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rentalCustomer2 = new Label(infogroup, SWT.BORDER);
		rentalCustomer2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		
		
		
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
