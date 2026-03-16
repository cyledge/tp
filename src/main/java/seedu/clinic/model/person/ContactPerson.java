package seedu.clinic.model.person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.clinic.commons.util.ToStringBuilder;
import seedu.clinic.model.tag.Tag;

/**
 * Represents a contact person in the clinic.
 * A ContactPerson is a basic person with contact information.
 *
 * TODO: NOT INTEGRATED
 */
public class ContactPerson extends Person {

    private final LocalDate dateAdded;

    /**
     * Constructs a ContactPerson with all fields.
     */
    public ContactPerson(Name name, Phone phone, Email email) {
        super(name, phone, email, new Address("N/A"), Collections.emptySet());
        this.dateAdded = LocalDate.now();
    }

    /**
     * Compatibility constructor for subclasses that still require address/tags.
     */
    public ContactPerson(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
        this.dateAdded = LocalDate.now();
    }

    /**
     * Compatibility constructor for subclasses that still require address/tags and ID.
     */
    public ContactPerson(Name name, Phone phone, Email email, Address address, Set<Tag> tags, int id) {
        super(name, phone, email, address, tags, id);
        this.dateAdded = LocalDate.now();
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    /**
     * Returns true if both contact persons are the same person.
     */
    @Override
    public boolean isSamePerson(Person otherPerson) {
        return otherPerson instanceof ContactPerson
                && super.isSamePerson(otherPerson);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ContactPerson)) {
            return false;
        }

        ContactPerson otherContactPerson = (ContactPerson) other;
        return getName().equals(otherContactPerson.getName())
                && getPhone().equals(otherContactPerson.getPhone())
                && getEmail().equals(otherContactPerson.getEmail())
                && dateAdded.equals(otherContactPerson.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getEmail(), dateAdded);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", getName())
                .add("phone", getPhone())
                .add("email", getEmail())
                .add("dateAdded", dateAdded)
                .toString();
    }
}
