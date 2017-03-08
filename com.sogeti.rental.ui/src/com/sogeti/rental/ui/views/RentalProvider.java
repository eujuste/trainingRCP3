package com.sogeti.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.internal.AggregateWorkingSet;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalProvider extends LabelProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Collection<?>){
			return ((Collection) inputElement).toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {

		if(parentElement instanceof RentalAgency){
			return ((RentalAgency) parentElement).getCustomers().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String getText(Object element) {
		if(element instanceof RentalAgency){
			return ((RentalAgency) element).getName();
		}else if(element instanceof Customer){
			return ((Customer) element).getDisplayName();
		}
		return super.getText(element);
	}

}
