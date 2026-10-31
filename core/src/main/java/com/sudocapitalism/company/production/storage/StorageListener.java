package com.sudocapitalism.company.production.storage;

public interface StorageListener {

    default void storageCapacityUpgraded() {}
}
