public abstract class GymMember
 {
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    public GymMember(int id, String name, String location, String phone, String email,
                     String gender, String DOB, String membershipStartDate) 
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

    // Getters
    public int getID()
    {
        return id;
    }
    public String getName()
    { 
        return name;
    }
    public String getLocation()
    { 
        return location; 
    }
    public String getPhone()
    { 
        return phone; 
    }
    public String getEmail() 
    { 
        return email; 
    }
    public String getGender() 
    {
        return gender; 
    }
    public String getDOB()
    {
        return DOB; 
    }
    public String getMembershipStartDate() 
    {
        return membershipStartDate; 
    }
    public int getAttendanceCount() 
    {
        return attendance; 
    }
    public double getLoyaltyPoints() 
    {
        return loyaltyPoints; 
    }
    public boolean getActiveStatus()
    { 
        return activeStatus;
    }

    // Required methods
    public void incrementAttendance() 
    {
        this.attendance++;
    }

    public void addLoyaltyPoints(double points)
    {
        this.loyaltyPoints += points;
    }

    public void activeMembership()
    {
        this.activeStatus = true;
    }

    public void deactivateMembership() 
    {
        this.activeStatus = false;
    }

    public void resetMember() 
    {
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

    public void display()
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + (activeStatus ? "Active" : "Inactive"));
    }

    public abstract void markAttendance();
    public abstract double getFullPayment();
    public abstract double getDiscountAmount();
    public abstract double getNetAmountPaid();
}
