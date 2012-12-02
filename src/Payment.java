import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Avi Levi, Mudrekh Goderya
 *
 *Description
 *
 *@version 1.0
 *
 */
public class Payment 
{
	private double paidAmount;
	private String paymentType;
	private Date paymentDate;
	
	
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public Payment(double paidAmount, String paymentType, Date paymentDate){
		this.paidAmount = paidAmount;
		this.paymentType=paymentType;
		this.paymentDate = paymentDate;
	}
	
	//Function has newlines built in so no need to add when invoking.
	public String toString(){
		String s = "";		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
		String paymentDateString = formatter.format(this.paymentDate);	
		s = Double.toString(this.paidAmount)+"\n"+this.paymentType+"\n"+paymentDateString+"\n";			              
		return s;
	}
}
