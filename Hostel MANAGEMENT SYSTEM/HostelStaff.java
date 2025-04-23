class HostelStaff extends Person {
    private String role;

    public HostelStaff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void displayInfo() {
        System.out.println("Staff: " + name + ", Role: " + role + ", Age: " + age);
    }
}
