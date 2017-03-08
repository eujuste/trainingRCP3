package com.sogeti.rental.ui.views;


import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart implements ISelectionListener{
	
	Label rentalLabel;
	
	Label rentalCustomer1;
	private Group grpDateDeLocation;
	Label startDate;
	Label endDate;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		
		Group infogroup = new Group(parent,SWT.NONE);
		infogroup.setText("Informations");
		infogroup.setLayout(new GridLayout(2,false));
		rentalLabel = new Label(infogroup, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 2;
		rentalLabel.setLayoutData(gd);
		
		 new Label(infogroup, SWT.BORDER).setText("Louer à:");
		
	
		rentalCustomer1 = new Label(infogroup, SWT.BORDER);
		rentalCustomer1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		grpDateDeLocation = new Group(parent, SWT.NONE);
		grpDateDeLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDateDeLocation.setText("Date de location");
		grpDateDeLocation.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_2 = new Label(grpDateDeLocation, SWT.NONE);
		lblNewLabel_2.setText("Start date:");
		
		startDate = new Label(grpDateDeLocation, SWT.NONE);
		
		Label lblNewLabel = new Label(grpDateDeLocation, SWT.NONE);
		lblNewLabel.setText("End date:");
		
		endDate = new Label(grpDateDeLocation, SWT.NONE);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		
		
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void setRental(Rental r)
	{
		
		rentalLabel.setText(r.getRentedObject().getName());
		rentalCustomer1.setText(r.getCustomer().getDisplayName());
		startDate.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(selection instanceof IStructuredSelection){
			Object sel = ((IStructuredSelection) selection).getFirstElement();
			if(sel instanceof Rental){
				setRental((Rental)sel);
			}
		}
		
	}
	 
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		site.getPage().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		getSite().getPage().removeSelectionListener(this);
	}
}
