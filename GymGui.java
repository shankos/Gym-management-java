import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.ArrayList;

public class GymGui extends JFrame 
{
    private JButton regularBtn, premiumBtn, viewBtn;
    private ArrayList<GymMember> memberList;

    public GymGui() 
    {
        setTitle("Gym Membership Portal");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        memberList = new ArrayList<GymMember>();

        JLabel titleLabel = new JLabel("My Gym Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 22));
        titleLabel.setBounds(90, 30, 320, 40);
        add(titleLabel);

        regularBtn = new JButton("Regular Member");
        regularBtn.setBounds(140, 100, 200, 40);
        add(regularBtn);

        premiumBtn = new JButton("Premium Member");
        premiumBtn.setBounds(140, 160, 200, 40);
        add(premiumBtn);

        viewBtn = new JButton("View All Members");
        viewBtn.setBounds(140, 220, 200, 40);
        add(viewBtn);
            
        regularBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                new RegularMemberGUI(memberList).setVisible(true);
            }
        });

        premiumBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new PremiumMemberGUI(memberList).setVisible(true);
            }
        });

       
    }

    public static void main(String[] args) 
    {
        new GymGui().setVisible(true);
    }
}
class RegularMemberGUI extends JFrame 
{
    private ArrayList<GymMember> memberList;

    private JTextField idField, nameField, locationField, phoneField, emailField, referralField, planPriceField, loyaltyField;
    private JComboBox<String> dobDay, dobMonth, dobYear, startDay, startMonth, startYear;
    private JComboBox<String> planBox;
    private JRadioButton maleBtn, femaleBtn, otherBtn;
    private ButtonGroup genderGroup;

    public RegularMemberGUI(ArrayList<GymMember> memberList) 
    {
        this.memberList = memberList;

        setTitle("Regular Member Registration");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel titleLabel = new JLabel("Register Regular Member");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(500, 30, 400, 40);
        add(titleLabel);
        int labelX = 380;
        int fieldX = 530;
        int rowHeight = 40;
        int y = 100;

        JLabel idLabel = new JLabel("Member ID:");
        idLabel.setBounds(labelX, y, 140, 30);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(fieldX, y, 200, 30);
        add(idField);
        y += rowHeight;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(labelX, y, 140, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(fieldX, y, 200, 30);
        add(nameField);
        y += rowHeight;

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(labelX, y, 140, 30);
        add(locationLabel);
        locationField = new JTextField();
        locationField.setBounds(fieldX, y, 200, 30);
        add(locationField);
        y += rowHeight;

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(labelX, y, 140, 30);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(fieldX, y, 200, 30);
        add(phoneField);
        y += rowHeight;

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(labelX, y, 140, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(fieldX, y, 200, 30);
        add(emailField);
        y += rowHeight;

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(labelX, y, 140, 30);
        add(genderLabel);
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        otherBtn = new JRadioButton("Other");
        maleBtn.setBounds(fieldX, y, 70, 30);
        femaleBtn.setBounds(fieldX + 80, y, 80, 30);
        otherBtn.setBounds(fieldX + 170, y, 80, 30);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn); genderGroup.add(femaleBtn); genderGroup.add(otherBtn);
        add(maleBtn); add(femaleBtn); add(otherBtn);
        y += rowHeight;

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(labelX, y, 140, 30);
        add(dobLabel);
        dobDay = new JComboBox<>(getDays());
        dobMonth = new JComboBox<>(getMonths());
        dobYear = new JComboBox<>(getYears());
        dobDay.setBounds(fieldX, y, 60, 30);
        dobMonth.setBounds(fieldX + 70, y, 90, 30);
        dobYear.setBounds(fieldX + 170, y, 80, 30);
        add(dobDay); add(dobMonth); add(dobYear);
        y += rowHeight;

        JLabel startLabel = new JLabel("Start Date:");
        startLabel.setBounds(labelX, y, 140, 30);
        add(startLabel);
        startDay = new JComboBox<>(getDays());
        startMonth = new JComboBox<>(getMonths());
        startYear = new JComboBox<>(getYears());
        startDay.setBounds(fieldX, y, 60, 30);
        startMonth.setBounds(fieldX + 70, y, 90, 30);
        startYear.setBounds(fieldX + 170, y, 80, 30);
        add(startDay); add(startMonth); add(startYear);
        y += rowHeight;

        JLabel referralLabel = new JLabel("Referral Source:");
        referralLabel.setBounds(labelX, y, 140, 30);
        add(referralLabel);
        referralField = new JTextField();
        referralField.setBounds(fieldX, y, 200, 30);
        add(referralField);
        y += rowHeight;

        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(labelX, y, 140, 30);
        add(planLabel);
        planBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planBox.setBounds(fieldX, y, 200, 30);
        add(planBox);
        y += rowHeight;

        JLabel priceLabel = new JLabel("Plan Price:");
        priceLabel.setBounds(labelX, y, 140, 30);
        add(priceLabel);
        planPriceField = new JTextField();
        planPriceField.setBounds(fieldX, y, 200, 30);
        planPriceField.setEditable(false);
        add(planPriceField);
        y += rowHeight;

        JLabel loyaltyLabel = new JLabel("Loyalty Points:");
        loyaltyLabel.setBounds(labelX, y, 140, 30);
        add(loyaltyLabel);
        loyaltyField = new JTextField();
        loyaltyField.setBounds(fieldX, y, 200, 30);
        loyaltyField.setEditable(false);
        add(loyaltyField);

        planBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                String selected = (String) planBox.getSelectedItem();
                if (selected.equalsIgnoreCase("Basic")) 
                {
                    planPriceField.setText("6500");
                } else if (selected.equalsIgnoreCase("Standard")) 
                {
                    planPriceField.setText("12500");
                } else if (selected.equalsIgnoreCase("Deluxe")) 
                {
                    planPriceField.setText("18500");
                }
            }
        });

        planBox.setSelectedIndex(0); 
                int buttonY = 720;

        JButton addBtn = new JButton("Add Member");
        addBtn.setBounds(320, buttonY, 150, 35);
        add(addBtn);

        JButton activateBtn = new JButton("Activate Membership");
        activateBtn.setBounds(480, buttonY, 180, 35);
        add(activateBtn);

        JButton deactivateBtn = new JButton("Deactivate Membership");
        deactivateBtn.setBounds(670, buttonY, 200, 35);
        add(deactivateBtn);

        JButton markBtn = new JButton("Mark Attendance");
        markBtn.setBounds(320, buttonY + 50, 180, 35);
        add(markBtn);

        JButton upgradeBtn = new JButton("Upgrade Plan");
        upgradeBtn.setBounds(510, buttonY + 50, 160, 35);
        add(upgradeBtn);

        JButton revertBtn = new JButton("Revert Member");
        revertBtn.setBounds(680, buttonY + 50, 180, 35);
        add(revertBtn);

        JButton clearBtn = new JButton("Clear Fields");
        clearBtn.setBounds(860, buttonY + 50, 150, 35);
        add(clearBtn);

        JButton saveBtn = new JButton("Add to File");
        saveBtn.setBounds(320, buttonY + 100, 160, 35);
        add(saveBtn);

        JButton readBtn = new JButton("Read from File");
        readBtn.setBounds(500, buttonY + 100, 160, 35);
        add(readBtn);
        addBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    if (idField.getText().equals("") || nameField.getText().equals("") || locationField.getText().equals("")
                            || phoneField.getText().equals("") || emailField.getText().equals("") || referralField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "All fields are required.");
                        return;
                    }

                    int id = Integer.parseInt(idField.getText());
                    if (id <= 0) {
                        JOptionPane.showMessageDialog(null, "Member ID must be a non-nega integer greater than 0.");
                        return;
                    }

                    for (GymMember m : memberList) {
                        if (m.getID() == id) {
                            JOptionPane.showMessageDialog(null, "Member ID already exists.");
                            return;
                        }
                    }

                    String gender = getGender();
                    String dob = getDate(dobDay, dobMonth, dobYear);
                    String start = getDate(startDay, startMonth, startYear);

                    RegularMember m = new RegularMember(id, nameField.getText(), locationField.getText(), phoneField.getText(),
                            emailField.getText(), gender, dob, start, referralField.getText());
                    m.setPlan((String) planBox.getSelectedItem());
                    m.setPrice(Double.parseDouble(planPriceField.getText()));
                    memberList.add(m);

                    JOptionPane.showMessageDialog(null, "Member added.");
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Member ID must be an integer.");
                }
            }
        });

        activateBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null) 
                    {
                        m.activeMembership();
                        JOptionPane.showMessageDialog(null, "Activated.");
                    }
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        deactivateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null) {
                        m.deactivateMembership();
                        JOptionPane.showMessageDialog(null, "Deactivated.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        markBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null && m.getActiveStatus())
                    {
                        m.markAttendance();
                        loyaltyField.setText(String.valueOf(m.getLoyaltyPoints()));
                        JOptionPane.showMessageDialog(null,
                                "Attendance marked.\nTotal: " + m.getAttendanceCount() +
                                        "\nLoyalty Points: " + m.getLoyaltyPoints());
                    } else {
                        JOptionPane.showMessageDialog(null, "Inactive member.");
                    }
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        upgradeBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m instanceof RegularMember)
                    {
                        RegularMember r = (RegularMember) m;
                        if (r.getAttendanceCount() < 30) 
                        {
                            JOptionPane.showMessageDialog(null, "Must attend 30 days.");
                        } else {
                            String newPlan = JOptionPane.showInputDialog("Enter new plan:");
                            String result = r.upgradePlan(newPlan);
                            JOptionPane.showMessageDialog(null, result);
                        }
                    }
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        });

        revertBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m instanceof RegularMember) 
                    {
                        JTextField reasonField = new JTextField();
                        int confirm = JOptionPane.showConfirmDialog(null, reasonField, "Enter reason", JOptionPane.OK_CANCEL_OPTION);
                        if (confirm == JOptionPane.OK_OPTION)
                        {
                            ((RegularMember) m).revertRegularMember(reasonField.getText());
                            JOptionPane.showMessageDialog(null, "Reverted.");
                        }
                    }
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        clearBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                clearFields();
            }
        });

        saveBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    FileWriter fw = new FileWriter("regular_members.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (GymMember m : memberList) 
                    {
                        if (m instanceof RegularMember) 
                        {
                            RegularMember r = (RegularMember) m;
                            bw.write("ID: " + r.getID() + "\n");
                            bw.write("Name: " + r.getName() + "\n");
                            bw.write("Location: " + r.getLocation() + "\n");
                            bw.write("Phone: " + r.getPhone() + "\n");
                            bw.write("Email: " + r.getEmail() + "\n");
                            bw.write("Gender: " + r.getGender() + "\n");
                            bw.write("DOB: " + r.getDOB() + "\n");
                            bw.write("Start Date: " + r.getMembershipStartDate() + "\n");
                            bw.write("Plan: " + r.getPlan() + "\n");
                            bw.write("Attendance: " + r.getAttendanceCount() + "\n");
                            bw.write("Active: " + r.getActiveStatus() + "\n");
                            bw.write("Full Payment: " + r.getFullPayment() + "\n");
                            bw.write("Discount: " + r.getDiscountAmount() + "\n");
                            bw.write("Amount Paid: " + r.getNetAmountPaid() + "\n");
                            bw.write("Loyalty Points: " + r.getLoyaltyPoints() + "\n");
                            bw.write("---------------------------------------------------\n");
                        }
                    }

                    bw.close();
                    JOptionPane.showMessageDialog(null, "Data saved.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file.");
                }
            }
        });

        readBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    FileReader fr = new FileReader("regular_members.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    String content = "";
                    while ((line = br.readLine()) != null)
                    {
                        content += line + "\n";
                    }
                    br.close();

                    JTextArea area = new JTextArea(content);
                    area.setEditable(false);
                    JScrollPane scroll = new JScrollPane(area);
                    scroll.setPreferredSize(new Dimension(600, 400));
                    JOptionPane.showMessageDialog(null, scroll, "Saved Members", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file.");
                }
            }
        });
    }
    private String getGender()
    {
        if (maleBtn.isSelected()) return "Male";
        if (femaleBtn.isSelected()) return "Female";
        return "Other";
    }

    private String getDate(JComboBox<String> day, JComboBox<String> month, JComboBox<String> year) {
        return day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
    }

    private GymMember findMemberById(int id) 
    {
        for (GymMember m : memberList)
        {
            if (m.getID() == id) return m;
        }
        return null;
    }

    private void clearFields()
    {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        referralField.setText("");
        planPriceField.setText("");
        loyaltyField.setText("");
        planBox.setSelectedIndex(0);
        maleBtn.setSelected(true);
        dobDay.setSelectedIndex(0);
        dobMonth.setSelectedIndex(0);
        dobYear.setSelectedIndex(0);
        startDay.setSelectedIndex(0);
        startMonth.setSelectedIndex(0);
        startYear.setSelectedIndex(0);
    }

    private String[] getDays() 
    {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++)
        {
            days[i] = String.valueOf(i + 1);
        }
        return days;
    }

    private String[] getMonths() 
    {
        return new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                            "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

    private String[] getYears()
    {
        String[] years = new String[35];
        for (int i = 0; i < 35; i++) {
            years[i] = String.valueOf(1990 + i);
        }
        return years;
    }
}
class PremiumMemberGUI extends JFrame 
{
    private ArrayList<GymMember> memberList;

    private JTextField idField, nameField, locationField, phoneField, emailField;
    private JTextField trainerField, discountField, totalField, loyaltyField;
    private JComboBox<String> dobDay, dobMonth, dobYear, startDay, startMonth, startYear;
    private JRadioButton maleBtn, femaleBtn, otherBtn;
    private ButtonGroup genderGroup;

    public PremiumMemberGUI(ArrayList<GymMember> memberList) 
    {
        this.memberList = memberList;

        setTitle("Premium Member Registration");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Register Premium Member");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(500, 30, 400, 40);
        add(titleLabel);
                int labelX = 380;
        int fieldX = 530;
        int rowHeight = 40;
        int y = 100;

        JLabel idLabel = new JLabel("Member ID:");
        idLabel.setBounds(labelX, y, 140, 30);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(fieldX, y, 200, 30);
        add(idField);
        y += rowHeight;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(labelX, y, 140, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(fieldX, y, 200, 30);
        add(nameField);
        y += rowHeight;

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(labelX, y, 140, 30);
        add(locationLabel);
        locationField = new JTextField();
        locationField.setBounds(fieldX, y, 200, 30);
        add(locationField);
        y += rowHeight;

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(labelX, y, 140, 30);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(fieldX, y, 200, 30);
        add(phoneField);
        y += rowHeight;

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(labelX, y, 140, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(fieldX, y, 200, 30);
        add(emailField);
        y += rowHeight;

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(labelX, y, 140, 30);
        add(genderLabel);
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        otherBtn = new JRadioButton("Other");
        maleBtn.setBounds(fieldX, y, 70, 30);
        femaleBtn.setBounds(fieldX + 80, y, 80, 30);
        otherBtn.setBounds(fieldX + 170, y, 80, 30);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn); genderGroup.add(femaleBtn); genderGroup.add(otherBtn);
        add(maleBtn); add(femaleBtn); add(otherBtn);
        y += rowHeight;

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(labelX, y, 140, 30);
        add(dobLabel);
        dobDay = new JComboBox<>(getDays());
        dobMonth = new JComboBox<>(getMonths());
        dobYear = new JComboBox<>(getYears());
        dobDay.setBounds(fieldX, y, 60, 30);
        dobMonth.setBounds(fieldX + 70, y, 90, 30);
        dobYear.setBounds(fieldX + 170, y, 80, 30);
        add(dobDay); add(dobMonth); add(dobYear);
        y += rowHeight;

        JLabel startLabel = new JLabel("Start Date:");
        startLabel.setBounds(labelX, y, 140, 30);
        add(startLabel);
        startDay = new JComboBox<>(getDays());
        startMonth = new JComboBox<>(getMonths());
        startYear = new JComboBox<>(getYears());
        startDay.setBounds(fieldX, y, 60, 30);
        startMonth.setBounds(fieldX + 70, y, 90, 30);
        startYear.setBounds(fieldX + 170, y, 80, 30);
        add(startDay); add(startMonth); add(startYear);
        y += rowHeight;

        JLabel trainerLabel = new JLabel("Personal Trainer:");
        trainerLabel.setBounds(labelX, y, 140, 30);
        add(trainerLabel);
        trainerField = new JTextField();
        trainerField.setBounds(fieldX, y, 200, 30);
        add(trainerField);
        y += rowHeight;

        JLabel discountLabel = new JLabel("Discount:");
        discountLabel.setBounds(labelX, y, 140, 30);
        add(discountLabel);
        discountField = new JTextField();
        discountField.setBounds(fieldX, y, 200, 30);
        discountField.setEditable(false);
        add(discountField);
        y += rowHeight;

        JLabel totalLabel = new JLabel("Total Amount:");
        totalLabel.setBounds(labelX, y, 140, 30);
        add(totalLabel);
        totalField = new JTextField("50000");
        totalField.setBounds(fieldX, y, 200, 30);
        totalField.setEditable(false);
        add(totalField);
        y += rowHeight;

        JLabel loyaltyLabel = new JLabel("Loyalty Points:");
        loyaltyLabel.setBounds(labelX, y, 140, 30);
        add(loyaltyLabel);
        loyaltyField = new JTextField();
        loyaltyField.setBounds(fieldX, y, 200, 30);
        loyaltyField.setEditable(false);
        add(loyaltyField);
                JButton addBtn = new JButton("Add Member");
        addBtn.setBounds(320, 720, 150, 35);
        add(addBtn);

        addBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if (idField.getText().equals("") || nameField.getText().equals("") || locationField.getText().equals("")
                            || phoneField.getText().equals("") || emailField.getText().equals("") || trainerField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "All fields are required.");
                        return;
                    }

                    int id = Integer.parseInt(idField.getText());
                    if (id <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "Member ID must be a positive integer greater than 0.");
                        return;
                    }

                    for (GymMember m : memberList)
                    {
                        if (m.getID() == id)
                        {
                            JOptionPane.showMessageDialog(null, "Member ID already exists.");
                            return;
                        }
                    }

                    String gender = getGender();
                    String dob = getDate(dobDay, dobMonth, dobYear);
                    String start = getDate(startDay, startMonth, startYear);

                    PremiumMember m = new PremiumMember(id, nameField.getText(), locationField.getText(), phoneField.getText(),
                            emailField.getText(), gender, dob, start, trainerField.getText());

                    memberList.add(m);
                    JOptionPane.showMessageDialog(null, "Premium member added.");
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Member ID must be an integer.");
                }
            }
        });
                JButton activateBtn = new JButton("Activate Membership");
        activateBtn.setBounds(480, 720, 180, 35);
        add(activateBtn);

        JButton deactivateBtn = new JButton("Deactivate Membership");
        deactivateBtn.setBounds(670, 720, 200, 35);
        add(deactivateBtn);

        JButton markBtn = new JButton("Mark Attendance");
        markBtn.setBounds(320, 770, 180, 35);
        add(markBtn);

        JButton payBtn = new JButton("Pay Due");
        payBtn.setBounds(510, 770, 150, 35);
        add(payBtn);

        JButton discountBtn = new JButton("Calculate Discount");
        discountBtn.setBounds(670, 770, 200, 35);
        add(discountBtn);

        JButton revertBtn = new JButton("Revert Member");
        revertBtn.setBounds(880, 770, 150, 35);
        add(revertBtn);

        JButton clearBtn = new JButton("Clear Fields");
        clearBtn.setBounds(1040, 770, 150, 35);
        add(clearBtn);

        JButton saveBtn = new JButton("Add to File");
        saveBtn.setBounds(320, 820, 160, 35);
        add(saveBtn);

        JButton readBtn = new JButton("Read from File");
        readBtn.setBounds(500, 820, 160, 35);
        add(readBtn);
                activateBtn.addActionListener(new ActionListener()
                {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null) {
                        m.activeMembership();
                        JOptionPane.showMessageDialog(null, "Activated.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        deactivateBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null) {
                        m.deactivateMembership();
                        JOptionPane.showMessageDialog(null, "Deactivated.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        markBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m != null && m.getActiveStatus()) 
                    {
                        m.markAttendance();
                        loyaltyField.setText(String.valueOf(m.getLoyaltyPoints()));
                        JOptionPane.showMessageDialog(null, "Attendance marked.\nTotal: " + m.getAttendanceCount() +
                                "\nLoyalty Points: " + m.getLoyaltyPoints());
                    } else {
                        JOptionPane.showMessageDialog(null, "Inactive member.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        payBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m instanceof PremiumMember) 
                    {
                        String amtStr = JOptionPane.showInputDialog("Enter amount to pay:");
                        double amt = Double.parseDouble(amtStr);
                        String result = ((PremiumMember) m).payDueAmount(amt);
                        JOptionPane.showMessageDialog(null, result);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        });

        discountBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m instanceof PremiumMember) 
                    {
                        PremiumMember pm = (PremiumMember) m;
                        pm.calculateDiscount();
                        double d = pm.getDiscountAmount();
                        discountField.setText(String.valueOf(d));
                        JOptionPane.showMessageDialog(null, "Discount: " + d);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        revertBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    GymMember m = findMemberById(id);
                    if (m instanceof PremiumMember) 
                    {
                        JTextField reasonField = new JTextField();
                        int confirm = JOptionPane.showConfirmDialog(null, reasonField, "Enter reason", JOptionPane.OK_CANCEL_OPTION);
                        if (confirm == JOptionPane.OK_OPTION) {
                            ((PremiumMember) m).revertPremiumMember();
                            JOptionPane.showMessageDialog(null, "Reverted.");
                        }
                    }
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                clearFields();
            }
        });

        saveBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    FileWriter fw = new FileWriter("premium_members.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (GymMember m : memberList) 
                    {
                        if (m instanceof PremiumMember) 
                        {
                            PremiumMember p = (PremiumMember) m;
                            bw.write("ID: " + p.getID() + "\n");
                            bw.write("Name: " + p.getName() + "\n");
                            bw.write("Location: " + p.getLocation() + "\n");
                            bw.write("Phone: " + p.getPhone() + "\n");
                            bw.write("Email: " + p.getEmail() + "\n");
                            bw.write("Gender: " + p.getGender() + "\n");
                            bw.write("DOB: " + p.getDOB() + "\n");
                            bw.write("Start Date: " + p.getMembershipStartDate() + "\n");
                            bw.write("Trainer: " + p.getTrainerName() + "\n");
                            bw.write("Attendance: " + p.getAttendanceCount() + "\n");
                            bw.write("Active: " + p.getActiveStatus() + "\n");
                            bw.write("Full Payment: " + p.getFullPayment() + "\n");
                            bw.write("Discount: " + p.getDiscountAmount() + "\n");
                            bw.write("Amount Paid: " + p.getNetAmountPaid() + "\n");
                            bw.write("Loyalty Points: " + p.getLoyaltyPoints() + "\n");
                            bw.write("---------------------------------------------------\n");
                        }
                    }

                    bw.close();
                    JOptionPane.showMessageDialog(null, "Data saved.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file.");
                }
            }
        });

        readBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    FileReader fr = new FileReader("premium_members.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    String content = "";
                    while ((line = br.readLine()) != null) 
                    {
                        content += line + "\n";
                    }
                    br.close();

                    JTextArea area = new JTextArea(content);
                    area.setEditable(false);
                    JScrollPane scroll = new JScrollPane(area);
                    scroll.setPreferredSize(new Dimension(600, 400));
                    JOptionPane.showMessageDialog(null, scroll, "Saved Premium Members", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file.");
                }
            }
        });
    }
    private String getGender()
    {
        if (maleBtn.isSelected()) return "Male";
        if (femaleBtn.isSelected()) return "Female";
        return "Other";
    }

    private String getDate(JComboBox<String> day, JComboBox<String> month, JComboBox<String> year) 
    {
        return day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
    }

    private GymMember findMemberById(int id) 
    {
        for (GymMember m : memberList)
        {
            if (m.getID() == id) return m;
        }
        return null;
    }

    private void clearFields()
    {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        trainerField.setText("");
        discountField.setText("");
        loyaltyField.setText("");
        totalField.setText("50000");
        maleBtn.setSelected(true);
        dobDay.setSelectedIndex(0);
        dobMonth.setSelectedIndex(0);
        dobYear.setSelectedIndex(0);
        startDay.setSelectedIndex(0);
        startMonth.setSelectedIndex(0);
        startYear.setSelectedIndex(0);
    }

    private String[] getDays() 
    {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++)
        {
            days[i] = String.valueOf(i + 1);
        }
        return days;
    }

    private String[] getMonths() 
    {
        return new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                            "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

    private String[] getYears() 
    {
        String[] years = new String[35];
        for (int i = 0; i < 35; i++) {
            years[i] = String.valueOf(1990 + i);
        }
        return years;
    }
}
