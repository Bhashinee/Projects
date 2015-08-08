
package ruwanbook;

import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author rukshani
 */
public class Details {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty supaddress;
        
 
        public Details(String fName, String lName, String address) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.supaddress = new SimpleStringProperty(address);
        }

  
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String lName) {
            lastName.set(lName);
        }
            public String getaddress() {
            return supaddress.get();
        }
 
        public void setaddress(String address) {
            supaddress.set(address);
        }
    }

