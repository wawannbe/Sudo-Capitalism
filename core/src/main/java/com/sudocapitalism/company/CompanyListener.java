package com.sudocapitalism.company;

/**
 * Listener interface for company-related events.
 *
 * @author Elmouu
 */
public interface CompanyListener {

    /**
     * Called whenever the list of employees in a {@link Company} is modified.
     */
    default public void employeesListChanged() {}
}
