package com.sogeti.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.internal.AggregateWorkingSet;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
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
			RentalAgency ag = (RentalAgency) parentElement;
			return  new Node[]{new Node(ag, Node.CUSTOMERS),new Node(ag,Node.RENTAL),new Node(ag, Node.RENTAL_OBJECT)};
		}
		else if(parentElement instanceof Node){
			return ((Node) parentElement).getChildren();
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
		if (element instanceof Node || element instanceof RentalAgency){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String getText(Object element) {
		if(element instanceof RentalAgency){
			return ((RentalAgency) element).getName();
		}else if(element instanceof Customer){
			return ((Customer) element).getDisplayName();
		}else if(element instanceof RentalObject){
			return ((RentalObject) element).getName();
		}
		return super.getText(element);
	}

}

class Node {
	public static final String RENTAL_OBJECT = "RentalObject";
	public static final String RENTAL = "Rental";
	public static final String CUSTOMERS = "Customers";
	private RentalAgency agency;
	private String label;
	public Node(RentalAgency agency, String label) {
		super();
		this.agency = agency;
		this.label = label;
	}
	
	Object[] getChildren(){
		if(label == CUSTOMERS){
			return agency.getCustomers().toArray();
		}else if(label == RENTAL){
			return agency.getRentals().toArray();
		}else if(label == RENTAL_OBJECT){
			return agency.getObjectsToRent().toArray();
		}
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return label;
	}
}