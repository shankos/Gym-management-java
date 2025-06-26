public class RegularMember extends GymMember
 {
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    public RegularMember(int id, String name, String location, String phone, String email,
                         String gender, String dob, String startDate, String referralSource) {
        super(id, name, location, phone, email, gender, dob, startDate);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
        this.referralSource = referralSource;
    }

    public int getAttendanceLimit() 
    {
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade()
    {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() 
    {
        return removalReason;
    }

    public String getReferralSource() 
    {
        return referralSource;
    }

    public String getPlan() 
    {
        return plan;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPlan(String plan)
    {
        this.plan = plan;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public void markAttendance()
    {
        incrementAttendance();        
        addLoyaltyPoints(5);            
        if (getAttendanceCount() >= attendanceLimit) 
        {
            isEligibleForUpgrade = true;
        }
    }

    public double getPlanPrice(String plan) 
    {
        switch (plan.toLowerCase())
        {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    public String upgradePlan(String newPlan)
    {
        if (!isEligibleForUpgrade)
        {
            return "Member is not eligible for upgrade.";
        }
        if (newPlan.equalsIgnoreCase(plan)) 
        {
            return "You are already on the " + plan + " plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) 
        {
            return "Invalid plan selected.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded successfully to: " + newPlan;
    }

    public void revertRegularMember(String removalReason)
    {
        resetMember(); 
        this.removalReason = removalReason;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
    }

    @Override
    public double getFullPayment() 
    {
        return price;
    }

    @Override
    public double getDiscountAmount() 
    {
        return price * 0.05;
    }

    @Override
    public double getNetAmountPaid() 
    {
        return getFullPayment() - getDiscountAmount();
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}