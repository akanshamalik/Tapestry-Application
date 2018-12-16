import java.sql.Date;

import java.util.regex.Pattern;

public class Student {
	private int studentId;

	private String firstName;

	private String lastName;

	private Date dob;

	private String mobileNo;

	private String emailAddress;

	private Hobbies hobbies; // This will be used for drop-down

	// Default Constructor

	public Student(){

	}
	public Student(int studentId, String firstName, String lastName, Date dob, String mobileNo, String emailAddress, Hobbies hobbies) {

		super();

		this.studentId = studentId;

		this.firstName = firstName;

		this.lastName = lastName;

		this.dob = dob;

		this.mobileNo = mobileNo;

		this.emailAddress = emailAddress;

		this.hobbies = hobbies;

		}

		public int getStudentId() {

		return studentId;

		}
		public void setStudentId(int studentId) {

			this.studentId = studentId;

			}

			public String getFirstName() {

			return firstName;

			}

			public void setFirstName(String firstName) {

			this.firstName = firstName;

			}

			public String getLastName() {

			return lastName;

			}
			public void setLastName(String lastName) {

				this.lastName = lastName;

				}

				public Date getDob() {

				return dob;

				}

				public void setDob(Date dob) {

				this.dob = dob;

				}

				public String getMobileNo() {

				return mobileNo;

				}
				public void setMobileNo(String mobileNo) {

					this.mobileNo = mobileNo;

					}

					public String getEmailAddress() {

					return emailAddress;

					}

					public void setEmailAddress(String emailAddress) {

					this.emailAddress = emailAddress;

					}

					public Hobbies getHobbies() {

					return hobbies;

					}

					public void setHobbies(Hobbies hobbies) {

					this.hobbies = hobbies;

					}
					// validate the email address is in correct format

					public boolean isEmailAddressValid(){

					String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+

					"[a-zA-Z0-9_+&*-]+)*@" +

					"(?:[a-zA-Z0-9-]+\\.)+[a-z" +

					"A-Z]{2,7}$";

					Pattern pat = Pattern.compile(emailRegex);

					if (emailAddress == null)

					return false;

					return pat.matcher(emailAddress).matches();

					}

					// validates the mobile No entered.

					public boolean isMobileNumberValid(){

					if (mobileNo == null || mobileNo.equals(""))

					return false;

					if (mobileNo.length() < 10 || mobileNo.length() > 10)

					return false;

					if (mobileNo.equals("0000000000"))

					return false;

					return true;

					}

					@Override

					public String toString() {

					return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress + ", hobbies=" + hobbies + "]";

					}
}
