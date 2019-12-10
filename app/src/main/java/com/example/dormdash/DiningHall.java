package com.example.dormdash;

public class DiningHall {
    private String[] Foods;
    private String name;
    public String[] getFoods() {
        return Foods;
    }
    public String getName() {
        return name;
    }
    public String[] foodAtIke() {
        return new String[]{ "10oz Sirloing Steak 16:30", "12oz Ribeye Steak 16:30", "Bacon 16:30", "Beef Kabob 16:30",
                "Beyond Burger Patty 16:30", "Grilled NY Strip Steak 16:30", "Grilled Salmon 16:30", "Mushroom Swiss Burger 16:30", "Steak Tenderloin 16:30", "Pepperoni Pizza 16:30", "Three Cheese Thin Crust Pizza 16:30" };
    }
    public String[] foodAtPAR() {
        return new String[]{ "Bacon 7:00", "Buttermilk Pancakes 7:00", "Hard Cooked Eggs 7:00", "Vegetarian Sausage Patty 7:00" };
    }
    public String[] foodAt57() {
        return new String[] {"3pc Chicken Tenders 9:00" };
    }
}
