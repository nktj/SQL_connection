import org.postgresql.Driver;
import util.ConnectionManager;
import util.RandomData;

import java.sql.SQLException;

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String sql = "";

        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            for (int i = 0; i <= 30; i++) {
                int dis = (int) (Math.random() * 2);
                if (dis == 0) {
                    sql = String.format("""
                                        INSERT INTO "Clients" (client_type) VALUES ('individual');
                                        INSERT INTO "Individuals" (client_id, full_name, passport_series, passport_number, phone_number, "TIN", address_id)
                                        VALUES
                                        ((SELECT client_id FROM "Clients" ORDER BY client_id DESC LIMIT 1), '%s', '%s', '%s', '%s','%s',%d);
                            """, RandomData.randomFullName(), RandomData.randomPassportSeries(), RandomData.randomPassportNumber(), RandomData.randomPhoneNumber(), RandomData.randomTIN(), 1 + (int) (Math.random() * 7));
                } else {
                    sql = String.format("""
                            INSERT INTO "Clients" (client_type) VALUES ('legal person');                    
                            INSERT INTO "Legal_persons" (client_id, org_name, phone_number, "TIN", "MSRN",address_id)
                            VALUES
                            ((SELECT client_id FROM "Clients" ORDER BY client_id DESC LIMIT 1), '%s', '%s', '%s', '%s',%d)
                            """, RandomData.randomOrganization(), RandomData.randomPhoneNumber(), RandomData.randomTIN(), RandomData.randomTIN(), 1 + (int) (Math.random() * 7));
                }
                statement.execute(sql);
            }
        }
    }
}
