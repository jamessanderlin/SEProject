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
}
