public class PremiumMember extends GymMember 
{
    private final double fullPayment = 50000;
    private double amountPaid;
    private double discount;
    private String trainerName;

    public PremiumMember(int id, String name, String location, String phone, String email,
                         String gender, String dob, String startDate, String trainerName) 
                         {
        super(id, name, location, phone, email, gender, dob, startDate);
        this.trainerName = trainerName;
        this.amountPaid = 0;
        this.discount = 0;
    }

    public String getTrainerName()
    {
        return trainerName;
    }

    public String payDueAmount(double amount)
    {
        if (amountPaid + amount > fullPayment) 
        {
            return "Cannot pay more than 50,000. Remaining due: " + (fullPayment - amountPaid);
        } else {
            amountPaid += amount;
            return "Paid " + amount + ". Remaining due: " + (fullPayment - amountPaid);
        }
    }

    public void calculateDiscount()
    {
        if (amountPaid >= fullPayment)
        {
            discount = 5000;
        } else {
            discount = 0;
        }
    }

    public void revertPremiumMember()
    {
        resetMember(); 
        this.amountPaid = 0;
        this.discount = 0;
    }

    @Override
    public void markAttendance() 
    {
        incrementAttendance();
        addLoyaltyPoints(10);
    }

    @Override
    public double getFullPayment()
    {
        return fullPayment;
    }

    @Override
    public double getDiscountAmount()
    {
        return discount;
    }

    @Override
    public double getNetAmountPaid()
    {
        return amountPaid;
    }

    @Override
    public void display() 
    {
        super.display();
        System.out.println("Trainer: " + trainerName);
        System.out.println("Full Payment: " + fullPayment);
        System.out.println("Paid: " + amountPaid);
        System.out.println("Discount: " + discount);
        System.out.println("Loyalty Points: " + getLoyaltyPoints());
    }
}