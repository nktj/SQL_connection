package util;

public class RandomData {

    private static final String[] firstName = {"Emma", "Olivia", "Ava", "Sophia", "Isabella", "Mia", "Charlotte", "Abigail", "Emily", "Harper"};
    private static final String[] midlName = {"Smith", "Brown", "Taylor", "Walker", "Harris", "Davis", "Lewis", "King", "Young", "Moore"};
    private static final String[] lastName = {"Aleksandrovich", "Yuryevich", "Yuryevna", "Aleksandrovna", "Anatolyevich", "Anatolyevna", "Vyacheslavovna", "Vyacheslavovich"};
    private static final String[] organizationType = {"OOO", "OAO", "ZAO"};
    private static final String[] organizationName = {"Izim", "Rukastie", "Puli", "TopSto", "Muchick", "Landish", "Internet", "Navali", "Otvali"};


    public static String randomOrganization() {
        String type = organizationType[(int) (Math.random() * organizationType.length)];
        String name = organizationName[(int) (Math.random() * organizationName.length)];
        String fullOrg = type + " " + name;
        return fullOrg;
    }

    public static String randomFullName() {
        String first = firstName[(int) (Math.random() * firstName.length)];
        String midl = midlName[(int) (Math.random() * midlName.length)];
        String last = lastName[(int) (Math.random() * lastName.length)];
        String fullName = first + " " + midl + " " + last;
        return fullName;
    }

    public static String randomPassportSeries() {
        String passportSeries = Integer.toString(1000 + (int) (Math.random() * 9000));
        return passportSeries;
    }

    public static String randomPassportNumber() {
        String passportNumber = Integer.toString(100000 + (int) (Math.random() * 900000));
        return passportNumber;
    }

    public static String randomPhoneNumber() {
        String phoneNumber = Long.toString(10000000000L + (long) (Math.random() * 90000000000L));
        return phoneNumber;
    }

    public static String randomTIN() {
        String TIN = Long.toString(100000000000L + (long) (Math.random() * 900000000000L));
        return TIN;
    }

    private RandomData() {

    }
}
