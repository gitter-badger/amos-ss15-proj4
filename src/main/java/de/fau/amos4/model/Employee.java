package de.fau.amos4.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import de.fau.amos4.model.fields.Disabled;
import de.fau.amos4.model.fields.MaritalStatus;
import de.fau.amos4.model.fields.Sex;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Employee
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name="client_id")
    Client client;

    @Column
    String firstName;

    @Column
    String maidenName;

    @Column
    String familyName;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    Date birthDate;

    @Column
    String placeOfBirth;

    @Column
    String countryOfBirth;

    @Column
    String street;

    @Column
    String zipCode;

    @Column
    String houseNumber;

    @Column
    String city;

    @Column
    String socialInsuranceNumber;

    @Enumerated(EnumType.STRING)
    Sex sex;

    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    Disabled disabled;

    @Column
    String citizenship;

    @Column
    String employerSocialSavingsNumber;

    @Column
    String iban;

    @Column
    String bic;

    @Column
    String additionToAddress;

    @Column
    String token;

    public Employee()
    {
    }

    public String getAdditionToAddress()
    {
        return additionToAddress;
    }

    public void setAdditionToAddress(String additionToAddress)
    {
        this.additionToAddress = additionToAddress;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMaidenName()
    {
        return maidenName;
    }

    public void setMaidenName(String maidenName)
    {
        this.maidenName = maidenName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPlaceOfBirth()
    {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth)
    {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCountryOfBirth()
    {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth)
    {
        this.countryOfBirth = countryOfBirth;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getSocialInsuranceNumber()
    {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber)
    {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public Disabled getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Disabled disabled)
    {
        this.disabled = disabled;
    }

    public String getCitizenship()
    {
        return citizenship;
    }

    public void setCitizenship(String citizenship)
    {
        this.citizenship = citizenship;
    }

    public String getEmployerSocialSavingsNumber()
    {
        return employerSocialSavingsNumber;
    }

    public void setEmployerSocialSavingsNumber(String employerSocialSavingsNumber)
    {
        this.employerSocialSavingsNumber = employerSocialSavingsNumber;
    }

    public String getIban()
    {
        return iban;
    }

    public void setIban(String iban)
    {
        this.iban = iban;
    }

    public String getBic()
    {
        return bic;
    }

    public void setBic(String bic)
    {
        this.bic = bic;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("client", client)
                .append("firstName", firstName)
                .append("maidenName", maidenName)
                .append("familyName", familyName)
                .append("birthDate", birthDate)
                .append("placeOfBirth", placeOfBirth)
                .append("countryOfBirth", countryOfBirth)
                .append("street", street)
                .append("zipCode", zipCode)
                .append("houseNumber", houseNumber)
                .append("city", city)
                .append("socialInsuranceNumber", socialInsuranceNumber)
                .append("sex", sex)
                .append("maritalStatus", maritalStatus)
                .append("disabled", disabled)
                .append("citizenship", citizenship)
                .append("employerSocialSavingsNumber", employerSocialSavingsNumber)
                .append("iban", iban)
                .append("bic", bic)
                .append("additionToAddress", additionToAddress)
                .append("token", token)
                .toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return new EqualsBuilder()
                .append(id, employee.id)
                .append(client, employee.client)
                .append(firstName, employee.firstName)
                .append(maidenName, employee.maidenName)
                .append(familyName, employee.familyName)
                .append(birthDate, employee.birthDate)
                .append(placeOfBirth, employee.placeOfBirth)
                .append(countryOfBirth, employee.countryOfBirth)
                .append(street, employee.street)
                .append(zipCode, employee.zipCode)
                .append(houseNumber, employee.houseNumber)
                .append(city, employee.city)
                .append(socialInsuranceNumber, employee.socialInsuranceNumber)
                .append(sex, employee.sex)
                .append(maritalStatus, employee.maritalStatus)
                .append(disabled, employee.disabled)
                .append(citizenship, employee.citizenship)
                .append(employerSocialSavingsNumber, employee.employerSocialSavingsNumber)
                .append(iban, employee.iban)
                .append(bic, employee.bic)
                .append(additionToAddress, employee.additionToAddress)
                .append(token, employee.token)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(client)
                .append(firstName)
                .append(maidenName)
                .append(familyName)
                .append(birthDate)
                .append(placeOfBirth)
                .append(countryOfBirth)
                .append(street)
                .append(zipCode)
                .append(houseNumber)
                .append(city)
                .append(socialInsuranceNumber)
                .append(sex)
                .append(maritalStatus)
                .append(disabled)
                .append(citizenship)
                .append(employerSocialSavingsNumber)
                .append(iban)
                .append(bic)
                .append(additionToAddress)
                .append(token)
                .toHashCode();
    }
}
